package br.com.fiap.trabalhofinal.repositories;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.vo.StatisticVO;
import br.com.fiap.trabalhofinal.vo.TransactionVO;

@Repository
@EnableScheduling
public class TransactionRepository {

	private Set<TransactionVO> cache = Collections.synchronizedSet(new HashSet<>());

	public void saveTransaction(TransactionVO transaction) {
		synchronized (cache) {
			cache.add(transaction);
		}
	}

	public StatisticVO getStatistics() {
		StatisticVO statistics = new StatisticVO();

		synchronized (cache) {
			if (cache.size() > 0) {
				statistics.setSum(0d);

				cache.stream().forEach(c -> {
					Double amount = c.getAmount();

					Double sum = statistics.getSum();
					Double min = statistics.getMin();
					Double max = statistics.getMax();

					statistics.setSum(sum + amount);

					if (min == null || amount < min)
						statistics.setMin(amount);

					if (max == null || amount > max)
						statistics.setMax(amount);

					statistics.setCount(statistics.getCount() + 1);
				});

				statistics.setAvg(statistics.getSum() / statistics.getCount());
			}
		}

		return statistics;
	}

	@Scheduled(fixedDelay = 1)
	private void cleanOldDates() {
		long timeMillis = System.currentTimeMillis() - 60000;

		synchronized (cache) {
			cache.removeIf(c -> c.getTimestamp() < timeMillis);
		}
	}

}
