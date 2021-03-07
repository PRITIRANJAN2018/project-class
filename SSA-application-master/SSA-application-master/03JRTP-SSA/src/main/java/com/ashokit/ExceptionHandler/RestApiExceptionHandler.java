package com.ashokit.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.constants.AppConstants;

@RestController
@ControllerAdvice
public class RestApiExceptionHandler {
      
	

	public ResponseEntity<ApiError> handleNoDataFoundException(){
		
		ApiError error=new ApiError(400,AppConstants.EXCEPTION_MESSAGE,new Date());
		
		return new ResponseEntity<ApiError> (error,HttpStatus.BAD_REQUEST);
		
		
	}
	
}
