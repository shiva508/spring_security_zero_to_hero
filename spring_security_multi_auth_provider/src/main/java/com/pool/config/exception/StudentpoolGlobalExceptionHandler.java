package com.pool.config.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pool.model.exception.CustomErrorResponse;
import com.pool.model.exception.NoRecardsFoundException;

@RestControllerAdvice
public class StudentpoolGlobalExceptionHandler {
	
	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> usernameNotFoundExceptionHandler(UsernameNotFoundException error) {
		return new ResponseEntity<CustomErrorResponse>(
														new CustomErrorResponse()
														.setErrorCode(HttpStatus.NOT_FOUND.toString())
														.setErrorMsg(error.getMessage())
														.setStatus((HttpStatus.NOT_FOUND.value()))
														.setTimestamp(new Date()),
														HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BadCredentialsException.class)
	public ResponseEntity<CustomErrorResponse> badCredentialsExceptionHandler(BadCredentialsException error) {
		return new ResponseEntity<CustomErrorResponse>(
				new CustomErrorResponse()
				.setErrorCode(HttpStatus.NOT_FOUND.toString())
				.setErrorMsg(error.getMessage())
				.setStatus((HttpStatus.NOT_FOUND.value()))
				.setTimestamp(new Date()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoRecardsFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(NoRecardsFoundException error){
		return new ResponseEntity<CustomErrorResponse>(new CustomErrorResponse()
															.setErrorCode(HttpStatus.NOT_FOUND.toString())
															.setErrorMsg(error.getMessage())
															.setStatus((HttpStatus.NOT_FOUND.value()))
															.setTimestamp(new Date()), HttpStatus.NOT_FOUND);
	}
}
