package br.com.fiap.trabalhofinal.vo;

import java.util.Date;

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
	private Date timestamp;

	@ApiModelProperty("value of the transaction")
	private double amount;

}
