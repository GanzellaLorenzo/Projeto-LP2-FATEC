package com.estoque.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.projeto.dto.LoginRequest;
import com.estoque.projeto.entity.GestorEntity;
import com.estoque.projeto.service.GestorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/gestores")
@RequiredArgsConstructor
public class GestorController {
    private final GestorService gestorService;
    
    @GetMapping
    public ResponseEntity<List<GestorEntity>> listarTodos() {
        return ResponseEntity.ok(gestorService.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GestorEntity> buscarPorId(@PathVariable Integer id) {
        return gestorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<GestorEntity> criar(@RequestBody GestorEntity gestor) {
        return new ResponseEntity<>(gestorService.salvar(gestor), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GestorEntity> atualizar(@PathVariable Integer id, @RequestBody GestorEntity gestor) {
        try {
            return ResponseEntity.ok(gestorService.atualizar(id, gestor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<GestorEntity> login(@RequestBody LoginRequest request) {
        return gestorService.login(request.getEmail(), request.getSenha())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}