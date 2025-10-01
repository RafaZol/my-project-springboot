package com.example.my_project_springboot.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {
    
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    
}
