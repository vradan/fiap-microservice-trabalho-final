package br.com.fiap.trabalhofinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class TransactionOldDatetimeException extends RuntimeException {

	public TransactionOldDatetimeException(Long transaction, Long minimal) {
		super("The time is old in " + (minimal - transaction) + "ms");
	}

	private static final long serialVersionUID = 1L;

}
