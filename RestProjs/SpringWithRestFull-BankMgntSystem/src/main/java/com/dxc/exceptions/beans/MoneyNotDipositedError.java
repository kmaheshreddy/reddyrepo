package com.dxc.exceptions.beans;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class MoneyNotDipositedError extends Exception{
	public MoneyNotDipositedError(String message) {
	   super(message);
	}

}
