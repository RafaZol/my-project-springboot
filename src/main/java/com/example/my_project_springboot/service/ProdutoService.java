package com.example.my_project_springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.my_project_springboot.exceptions.RecursoNaoEncontradoException;
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
        //verifica se o produto existe antes de tentar deletar
        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id " + id + " não encontrado");

        }
        produtoRepository.deleteById(id);
    }    

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //public Optional<Produto> listaProdutosPorId(Long id){ -> o uso de exceptions não permite mais o uso de Optional
    public Produto listaProdutosPorId(Long id){
        return produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com id " + id + " não encontrado"));
    }

}
