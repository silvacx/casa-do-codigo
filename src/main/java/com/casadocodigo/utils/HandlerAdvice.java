package com.casadocodigo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        Collection<String> messages = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(
                fieldError -> {
                    String post = String.format("Field %s %s", fieldError.getField(), fieldError.getDefaultMessage());
                    messages.add(post);
                }
        );

        Error standardizedError = new Error(messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);

    }

    @ExceptionHandler
    public ResponseEntity<Error> handleResponseStatusException(ResponseStatusException responseStatusException) {
        Collection<String> messages = new ArrayList<>();
        messages.add(responseStatusException.getReason());

        Error standardizedError = new Error(messages);
        return ResponseEntity.status(responseStatusException.getStatus()).body(standardizedError);
    }
}
