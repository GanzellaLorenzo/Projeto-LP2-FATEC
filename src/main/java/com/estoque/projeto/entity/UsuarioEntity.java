package com.estoque.projeto.entity;

import com.estoque.projeto.enums.TipoUsuarioEnum;

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
@Table(name= "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "idUsuario")
    private int userId;

    @Enumerated(EnumType.STRING)
    @Column(name= "tipo", nullable= false)
    private TipoUsuarioEnum tipo;

    @Column(name= "nome", nullable= false)
    private String userName;

    @Column(name= "email", nullable= false)
    private String userLoginEmail;

    @Column(name= "senha", nullable= false)
    private String userSenha;
    
    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;
    
}
