package com.lesi.rpg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lesi.rpg.dto.ErrorResponseDto;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException ex){
        ErrorResponseDto errorResponse = new ErrorResponseDto(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }


}
