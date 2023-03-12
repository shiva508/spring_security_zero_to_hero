package com.pool.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProjectIdException.class)
	public ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request) {
		ExceptionResponse res = new ExceptionResponse();
		res.setMessage(ex.getMessage());
		res.setTimeStamp(new Date());
		return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
	}

	
	/*
	 * @ExceptionHandler(value = { Exception.class }) public ResponseEntity<Object>
	 * handleGlobalExcption(Exception ex, WebRequest request) { ExceptionResponse
	 * res = new ExceptionResponse(); res.setMessage(ex.getMessage());
	 * res.setTimeStamp(new Date()); return new ResponseEntity(res,
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	 
}
