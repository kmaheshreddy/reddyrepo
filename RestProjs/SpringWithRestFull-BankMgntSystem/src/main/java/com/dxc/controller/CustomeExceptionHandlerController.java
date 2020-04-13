package com.dxc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.dxc.exceptions.beans.AccountHolderNotFound;
import com.dxc.exceptions.beans.ErrorResponse;
import com.dxc.exceptions.beans.MissingHeaderInfoException;
import com.dxc.exceptions.beans.MoneyNotDipositedError;
import com.dxc.exceptions.beans.MoneyNotWithdwanError;

@ControllerAdvice
public class CustomeExceptionHandlerController{
	private String NOT_FOUND = "NOT_FOUND";
    private String NOT_MODIFIED = "NOT_MODIFIED";
     
   
    @ExceptionHandler(AccountHolderNotFound.class)
    public ResponseEntity<Object> AccountHolderNotFoundHandle(AccountHolderNotFound e,WebRequest req){
    	List<String> details=new ArrayList();
    	details.add(e.getLocalizedMessage());
    	ErrorResponse error=new ErrorResponse(NOT_FOUND,details);
    	return new ResponseEntity<Object>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MoneyNotDipositedError.class)
    public ResponseEntity<Object> AccountHolderNotFoundHandle(MoneyNotDipositedError e,WebRequest req){
    	List<String> details=new ArrayList();
    	details.add(e.getLocalizedMessage());
    	ErrorResponse error=new ErrorResponse(NOT_FOUND,details);
    	return new ResponseEntity<Object>(error,HttpStatus.NOT_MODIFIED);
    }
    @ExceptionHandler(MoneyNotWithdwanError.class)
    public ResponseEntity<Object> AccountHolderNotFoundHandle(MoneyNotWithdwanError e,WebRequest req){
    	List<String> details=new ArrayList();
    	details.add(e.getLocalizedMessage());
    	ErrorResponse error=new ErrorResponse(NOT_FOUND,details);
    	return new ResponseEntity<Object>(error,HttpStatus.NOT_MODIFIED);
    }
 

}
