package com.example.SpringBootCrudMongoDB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SpringBootCrudMongoDB.model.Employee;

@ControllerAdvice
public class GlobalException extends Exception {
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<?> employeeNotFoundException(Exception ex)
	{
		
		ErrorDetails err=new ErrorDetails(ex.getMessage(),"kjdgycfg");
		return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
   
}
