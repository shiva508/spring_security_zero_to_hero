package com.pool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DuplicateDressException extends RuntimeException {

	public DuplicateDressException(String message) {
		super(message);
	}

}
