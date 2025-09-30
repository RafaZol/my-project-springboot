package com.example.my_project_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_project_springboot.model.Produto;
import com.example.my_project_springboot.service.ProdutoService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long id){
        return produtoService.listaProdutosPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto save(Produto produto){
        return produtoService.save(produto);
    } 

    public void delete(Produto produto){
        produtoService.delete(produto.getId());
    }

}
