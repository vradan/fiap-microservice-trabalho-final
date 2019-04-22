package br.com.fiap.trabalhofinal.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.trabalhofinal.vo.TransactionVO;

@Repository
public class TransactionRepository {

	private List<TransactionVO> cache = new ArrayList<>();

	public void saveTransaction(TransactionVO transaction) {
		cache.add(transaction);
	}

}
