package com.example.usuario.mongodbtest.models;

public class CartaoModel {
    private String numero;
    private String nmTitular;
    private String apelido;

    public CartaoModel(String numero, String nmTitular, String apelido) {
        this.numero = numero;
        this.nmTitular = nmTitular;
        this.apelido = apelido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNmTitular() {
        return nmTitular;
    }

    public void setNmTitular(String nmTitular) {
        this.nmTitular = nmTitular;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
