package com.example.my_project_springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.my_project_springboot.model.Usuario;
import com.example.my_project_springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository  usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;        
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String username, String password){
        String senhaCriptografada = passwordEncoder.encode(password);
        Usuario usuario = new Usuario(username, senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

}
