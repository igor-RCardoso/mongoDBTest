package com.example.usuario.mongodbtest.models;

public class Especialidade {
    private String nome;
    private String descricao;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Especialidade(String nome, String descricao) {

        this.nome = nome;
        this.descricao = descricao;
    }
}
