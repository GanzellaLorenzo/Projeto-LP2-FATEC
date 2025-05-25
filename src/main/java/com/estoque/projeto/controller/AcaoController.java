package com.estoque.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.projeto.entity.AcaoEntity;
import com.estoque.projeto.service.AcaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/acoes")
@RequiredArgsConstructor
public class AcaoController {

    private final AcaoService acaoService;

    @GetMapping
    public ResponseEntity<List<AcaoEntity>> listarTodas() {
        return ResponseEntity.ok(acaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcaoEntity> buscarPorId(@PathVariable Long id) {
        return acaoService.buscarPorId(id)
                .map(acao -> ResponseEntity.ok(acao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AcaoEntity> registrarAcao(@RequestBody AcaoEntity acao) {
        try {
            AcaoEntity acaoRegistrada = acaoService.registrarAcao(acao);
            return new ResponseEntity<>(acaoRegistrada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}