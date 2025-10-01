package com.example.my_project_springboot.controller;

import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.my_project_springboot.model.Usuario;
import com.example.my_project_springboot.security.JwtUtil;
import com.example.my_project_springboot.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UsuarioService usuarioService;

    public AuthControleer(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), "password");
        return ResponseEntity.ok(usuario);                
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));
        if(usuario.isPresent() && usuario.get().getPassword().equals("password")){
            String token = JwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));            
        }
        return ResponseEntity.status(401).body("Credentials error");
    }
}
