package com.example.my_project_springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
    
    public String obterMensagem(){
        return "Mensagem do Repositório";
    }

}
