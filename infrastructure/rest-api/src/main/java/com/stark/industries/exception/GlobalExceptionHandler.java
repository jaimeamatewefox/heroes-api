package com.stark.industries.exception;

import com.wefox.server.lib.common.core.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
class Error {
    private Number status;
    private String message;
}

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> handleNoSuchElementFoundException(
            NotFoundException exception
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(
                        Error.builder()
                                .message(exception.getMessage())
                                .status(status.value())
                                .build());
    }
}
