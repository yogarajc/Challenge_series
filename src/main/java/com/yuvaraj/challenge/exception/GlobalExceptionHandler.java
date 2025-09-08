package com.yuvaraj.challenge.exception;

import com.yuvaraj.challenge.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgValidationException(MethodArgumentNotValidException e){

        StringBuilder exception = new StringBuilder();

        e.getBindingResult().getAllErrors().forEach(objectError ->
        {
            String fieldName, message;
            fieldName = ((FieldError)objectError).getField();
            message = objectError.getDefaultMessage();

            exception.append(fieldName).append(" : ").append(message).append("|");

        });
        return new ResponseEntity<>(new ResponseDTO(exception.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> handleRuntimeException(RuntimeException e){

        return new ResponseEntity<>(new ResponseDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
