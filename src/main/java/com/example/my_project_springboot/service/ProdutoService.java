package com.example.my_project_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.my_project_springboot.model.Produto;
import com.example.my_project_springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;        
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }    

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> listaProdutosPorId(Long id){
        return produtoRepository.findById(id);
    }

}
