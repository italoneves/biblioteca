package br.com.italo.biblioteca.dto;

import br.com.italo.biblioteca.dominio.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;


    public CategoriaDTO(Categoria c ) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
    }
}
