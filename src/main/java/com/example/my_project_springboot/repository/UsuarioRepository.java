package com.example.my_project_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.my_project_springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //a classe como primeiro atributo e a tipagem do id como segundo atributo
    
    Optional<Usuario> findByUsername(String username);
}
