package com.pool.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomozedExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ProductExceptionResponse res=new ProductExceptionResponse();
		res.setMessage(ex.getMessage());
		res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		res.setTimeStamp(new Date());
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
