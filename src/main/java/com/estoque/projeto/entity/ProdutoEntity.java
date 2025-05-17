package com.estoque.projeto.entity;

import com.estoque.projeto.enums.StatusProdutoEnum;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "idprod")
    private int prodId;

    @Column(name= "nome", length= 200, nullable= false)
    private String prodNome;

    @Column(name= "descricao", nullable= true)
    private String prodDescricao;

    @Column(name= "precoCompra", nullable= true)
    private BigDecimal prodPrecoCompra;

    @Column(name= "precoVenda", nullable= false)
    private BigDecimal prodPrecoVenda;

    @Column(name= "quantidade", nullable= false)
    private int quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name= "status", nullable= false)
    private StatusProdutoEnum status;

}
