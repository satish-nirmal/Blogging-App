package com.codewithsatish.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithsatish.blog.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourseNotFountException.class)
	public ResponseEntity<?> userNotFoundException(ResourseNotFountException ex){
		
		String message = ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Map<String, String>> handleMedhodArgsNotValidException(MethodArgumentNotValidException ex){
	
		Map<String, String> map = new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			map.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
	}

}
