package com.example.abc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "booked_too_late")
public class BookedTooLateException extends RuntimeException {
}
