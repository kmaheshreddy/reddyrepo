package com.dxc.exceptions.beans;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class PermissionNotAllowed extends RuntimeException {

	public PermissionNotAllowed(String message) {
		super(message);
	}

}
