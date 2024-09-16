package com.dio.space.controller.exception;

import com.dio.space.service.exception.BusinessException;
import com.dio.space.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handlerBusinessException(BusinessException businessException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(businessException.getMessage());
    }

}
