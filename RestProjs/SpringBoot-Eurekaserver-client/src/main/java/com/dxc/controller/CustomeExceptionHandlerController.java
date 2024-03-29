package com.dxc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.dxc.exceptions.beans.ErrorResponse;
import com.dxc.exceptions.beans.MissingHeaderInfoException;
import com.dxc.exceptions.beans.PermissionNotAllowed;
import com.dxc.exceptions.beans.RecordNotFoundException;

@ControllerAdvice
public class CustomeExceptionHandlerController{
	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";
    private String UNAUTHORIZED = "UNAUTHORIZED";
     
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException
                        (RecordNotFoundException ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MissingHeaderInfoException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException
                        (MissingHeaderInfoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
 
    @ExceptionHandler(PermissionNotAllowed.class)
    public ResponseEntity<Object> handlingUnautharizedExcpetions(PermissionNotAllowed ex,WebRequest wr){
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse response=new ErrorResponse(UNAUTHORIZED, details);
     return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
