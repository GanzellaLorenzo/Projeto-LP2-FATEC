package com.estoque.projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "produto_estoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProdutoEstoqueId.class)
public class ProdutoEstoqueEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @Id
    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private EstoqueEntity estoque;

    @Column(nullable = false)
    private Integer quantidade;
}

class ProdutoEstoqueId implements Serializable {
    private Long produto;
    private Long estoque;
}