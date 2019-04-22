package br.com.fiap.trabalhofinal.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.trabalhofinal.exceptions.TransactionOldDatetimeException;
import br.com.fiap.trabalhofinal.repositories.TransactionRepository;
import br.com.fiap.trabalhofinal.vo.TransactionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("Transactions service Rest API")
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository repository;

	@PostMapping("/")
	@ApiOperation("endpoint to save transactions")
	@ApiResponses({ @ApiResponse(code = 201, message = "return code 201 if success"),
			@ApiResponse(code = 204, message = "return code 204 if transaction ocurred more than 60 seconds") })
	public ResponseEntity<Void> saveTransaction(@RequestBody TransactionVO transaction) {
		LocalDateTime minimalTime = LocalDateTime.now().minusSeconds(60);

		if (transaction.getTimestamp().isBefore(minimalTime)) {
			throw new TransactionOldDatetimeException(transaction.getTimestamp(), minimalTime);
		}

		repository.saveTransaction(transaction);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
