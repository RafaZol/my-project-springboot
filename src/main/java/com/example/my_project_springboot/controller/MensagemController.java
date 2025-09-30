package com.example.my_project_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_project_springboot.service.MensagemService;

@RestController
@RequestMapping
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/")
    public String obterMensagem() {
        return mensagemService.obterMensagem();
    }
    
}
