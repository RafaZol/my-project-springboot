package com.example.my_project_springboot.service;

import org.springframework.stereotype.Service;

import com.example.my_project_springboot.repository.MensagemRepository;

//Serviço para lógica de negócios relacionada a mensagens

@Service
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
