package br.com.fiap.trabalhofinal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalhofinal.vo.StatisticVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@Api("Statistics Service Rest API")
@RequestMapping("/statistics")
public class StatisticsController {

	@GetMapping("/")
	@ApiOperation("return statistics from saveds transactions")
	@ApiResponse(code = 200, message = "return object containing statistics information", response = StatisticVO.class)
	public ResponseEntity<StatisticVO> getStatistics() {
		return new ResponseEntity<StatisticVO>(new StatisticVO(25170.90, 20, 25000.17, 8390.30, 3), HttpStatus.OK);
	}

}
