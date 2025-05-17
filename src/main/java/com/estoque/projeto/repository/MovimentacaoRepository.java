package com.estoque.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estoque.projeto.entity.MovimentacaoEntity;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity,Integer > {

}
