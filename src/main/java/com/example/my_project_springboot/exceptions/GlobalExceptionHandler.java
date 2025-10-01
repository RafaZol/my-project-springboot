package com.example.my_project_springboot.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // -> indica que essa classe vai tratar exceções de forma global para todos os controllers
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RecursoNaoEncontradoException.class) // -> indica que esse método vai tratar a exceção RecursoNaoEncontradoException  
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Recurso Não Encontrado");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // -> indica que esse método vai tratar a exceção RecursoNaoEncontradoException  
    public ResponseEntity<Object> handleRecursoNaoEncontrado(Exception ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Recurso Interno do servidor");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
