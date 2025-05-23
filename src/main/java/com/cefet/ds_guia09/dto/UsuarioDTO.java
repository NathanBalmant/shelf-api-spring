package com.cefet.ds_guia09.dto;

import com.cefet.ds_guia09.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }
}
