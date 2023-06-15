package com.app.exception_handler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.app.dto.apiResponse;

@RestControllerAdvice
public class GlobalExceptionhandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		System.out.println("in methodnotvalid exception handler");
		List<FieldError> fieldErrors = e.getFieldErrors();
		Map<String,String> map = fieldErrors.stream().collect(Collectors.toMap(f -> f.getField(), f -> f.getDefaultMessage()));
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	
	

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleAllException(RuntimeException e){
		System.out.println("in global exception handler");
		return new ResponseEntity<>(new apiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
