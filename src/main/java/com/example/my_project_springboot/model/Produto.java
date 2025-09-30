package com.example.my_project_springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Indica que esta classe é uma entidade JPA
@Table(name = "produtos") //Mapeia a entidade para a tabela "produtos" no banco de dados
public class Produto {

    @Id //Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Especifica que o valor da chave primária será gerado automaticamente pelo banco de dados
    private Long id;
        
    private String nome;

    private Double preco;
    
    public Produto() {
    }

    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;    
    }

    public Double getPreco(){
        return this.preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }
    
}
