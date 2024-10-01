package com.shubham.execption;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shubham.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExecption.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExcptionHandler(ResourceNotFoundExecption execption){
		String message=execption.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidExecption(MethodArgumentNotValidException exception){
		Map<String, String> resp=new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((eror)->{
			String fieldName=((FieldError)eror).getField();
			String getMessge=eror.getDefaultMessage();
			resp.put(fieldName, getMessge);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
