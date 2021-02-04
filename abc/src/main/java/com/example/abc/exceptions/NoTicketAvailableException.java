package com.example.abc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "no_ticket_available")
public class NoTicketAvailableException extends RuntimeException {
}
