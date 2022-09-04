package com.codechallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public final class BadRequestException extends RuntimeException {
	public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }
}