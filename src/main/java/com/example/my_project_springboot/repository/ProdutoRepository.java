package com.example.my_project_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.my_project_springboot.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> { //a classe como primeiro atributo e a tipagem do id como segundo atributo

    
}
