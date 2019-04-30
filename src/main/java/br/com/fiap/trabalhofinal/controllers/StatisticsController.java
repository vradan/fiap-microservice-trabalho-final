package br.com.fiap.trabalhofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalhofinal.repositories.TransactionRepository;
import br.com.fiap.trabalhofinal.vo.StatisticVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@Api("Statistics Service Rest API")
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private TransactionRepository repository;

	@GetMapping("/")
	@ApiOperation("return statistics from saveds transactions")
	@ApiResponse(code = 200, message = "return object containing statistics information", response = StatisticVO.class)
	public ResponseEntity<StatisticVO> getStatistics() {
		StatisticVO statistics = repository.getStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}

}
