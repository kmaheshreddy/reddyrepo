package com.dxc.exceptions.beans;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountHolderNotFound extends Exception {
public AccountHolderNotFound(String message) {
	super(message);
}
}
