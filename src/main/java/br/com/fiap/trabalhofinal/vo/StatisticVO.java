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
public class StatisticVO {

	@ApiModelProperty(value = "represents the sum of all transactions in the last 60 seconds", example = "25170.90")
	private Double sum;

	@ApiModelProperty(value = "represents the minimum transaction in the last 60 seconds", example = "20")
	private Double min;

	@ApiModelProperty(value = "represents the maximum transaction in the last 60 seconds", example = "25000.17")
	private Double max;

	@ApiModelProperty(value = "represents the average value of all transaction in the last 60 seconds", example = "8390.30")
	private Double avg;

	@ApiModelProperty(value = "represents the count of how much transactions have occurred in the last 60 seconds", example = "3")
	private long count;

}
