package com.cefet.ds_guia09.dto;

import com.cefet.ds_guia09.entities.Produto;
import com.cefet.ds_guia09.entities.Tipo;


public class ProdutoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Double estoque;
    private Double preco;
    private Tipo tipo;

    public ProdutoDTO() {
    
}

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.titulo = produto.getTitulo();
        this.descricao = produto.getDescricao();
        this.estoque = produto.getEstoque();
        this.preco = produto.getPreco();
        this.tipo = produto.getTipo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getEstoque() {
        return estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public Tipo getTipo() {
        return tipo;
    }
    

}


