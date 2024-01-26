package dev.shoxruhjon.ekorxona.config;

import dev.shoxruhjon.ekorxona.exception.AuthException;
import dev.shoxruhjon.ekorxona.exception.DataAlreadyExistsException;
import dev.shoxruhjon.ekorxona.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AuthException.class)
    public ResponseEntity<String> authException(AuthException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<String> forbidden(AccessDeniedException e) {
        return ResponseEntity.status(403).body(e.getMessage());
    }

    @ExceptionHandler(value = DataAlreadyExistsException.class)
    public ResponseEntity<String> dataAlreadyExists(DataAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<String> dataNotFound(DataNotFoundException e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }
}
