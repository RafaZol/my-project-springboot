package com.example.my_project_springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_project_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.my_project_springboot.model.Produto;
import com.example.my_project_springboot.service.ProdutoService;


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
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id){
        //return produtoService.listaProdutosPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); -> o uso de exceptions não permite mais o uso de Optional por isso gera erro no map
        
            //não precis de um try catch pois a exception é tratada de forma global pela classe GlobalExceptionHandler
            //se o produto não for encontrado a exception RecursoNaoEncontradoException será lançada
            Produto produto = produtoService.listaProdutosPorId(id);
            return ResponseEntity.ok(produto);
        
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return produtoService.save(produto);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
