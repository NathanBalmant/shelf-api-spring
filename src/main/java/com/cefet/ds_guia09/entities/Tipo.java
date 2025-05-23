package com.cefet.ds_guia09.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public Tipo() {
    }

    public Tipo(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipo)) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(id, tipo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
