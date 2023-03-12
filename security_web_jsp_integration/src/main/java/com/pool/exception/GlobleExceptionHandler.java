package com.pool.exception;

import java.util.Date;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleExceptionHandler  {
	@ExceptionHandler
	public ResponseEntity<UserExceptionResponse> productNotFoundException(UserNotFoundException exe) {
		UserExceptionResponse res=new UserExceptionResponse();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage(exe.getMessage());
		res.setTimeStamp(new Date());
		return new ResponseEntity<UserExceptionResponse>(res,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ProductExceptionResponse> productNotFoundException(ProductNotFoundException ex,WebRequest request){
		ProductExceptionResponse res=new ProductExceptionResponse();
		res.setMessage(ex.getMessage()+request.getDescription(true));
		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setTimeStamp(new Date());
		return new ResponseEntity<ProductExceptionResponse>(res,HttpStatus.NOT_FOUND);
	}
	@SuppressWarnings("rawtypes")
	@ExceptionHandler
	public ResponseEntity<Object> internalExceptionHandler(Exception ex){
		ProductExceptionResponse res=new ProductExceptionResponse();
		res.setMessage(ex.getMessage());
		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setTimeStamp(new Date());
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
