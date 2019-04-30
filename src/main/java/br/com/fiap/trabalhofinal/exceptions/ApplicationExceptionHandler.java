package br.com.fiap.trabalhofinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<>(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(TransactionOldDatetimeException.class)
	public final ResponseEntity<String> handleTransactionOldDatetimeExceptions(TransactionOldDatetimeException ex,
			WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

}
