package com.example.abc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "user_already_exists")
public class UserAlreadyExistsException extends RuntimeException {
}
