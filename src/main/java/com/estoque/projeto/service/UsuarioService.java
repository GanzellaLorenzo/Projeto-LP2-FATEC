
package com.estoque.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.projeto.entity.UsuarioEntity;
import com.estoque.projeto.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioEntity incluir(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity editar(int id, UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodos() {
        return usuarioRepository.findAll();
    }
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}


