package br.com.fiap.trabalhofinal.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVO {

	@ApiModelProperty("time when the transaction occurred")
	private Long timestamp;

	@ApiModelProperty("value of the transaction")
	private Double amount;

	@Override
	public String toString() {
		return "timestamp=" + timestamp + ";amount=" + amount;
	}

}
