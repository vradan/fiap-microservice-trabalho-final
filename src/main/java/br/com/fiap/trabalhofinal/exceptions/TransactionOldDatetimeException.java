package br.com.fiap.trabalhofinal.exceptions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class TransactionOldDatetimeException extends RuntimeException {

	public TransactionOldDatetimeException(LocalDateTime timestamp, LocalDateTime now) {
		super("The time is old in " + (ChronoUnit.SECONDS.between(now, timestamp) - 60));
	}

	private static final long serialVersionUID = 1L;

}
