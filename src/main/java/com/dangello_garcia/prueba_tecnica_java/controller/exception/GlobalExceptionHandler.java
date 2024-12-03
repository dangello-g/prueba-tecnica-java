package com.dangello_garcia.prueba_tecnica_java.controller.exception;

import com.dangello_garcia.prueba_tecnica_java.dto.MessageDTO;
import com.dangello_garcia.prueba_tecnica_java.dto.ValidationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO<List<ValidationDTO>>> validationException(MethodArgumentNotValidException validException){

        List<ValidationDTO> errors = new ArrayList<>();
        BindingResult result = validException.getBindingResult();

        for (FieldError fieldError: result.getFieldErrors()) {
            errors.add(new ValidationDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(new MessageDTO<>(true, errors));
    }
}
