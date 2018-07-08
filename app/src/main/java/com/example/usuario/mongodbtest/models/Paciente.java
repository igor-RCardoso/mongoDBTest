package com.example.usuario.mongodbtest.models;

import java.util.Date;

public class Paciente {
    private String nome;
    private Date dataNasc;
    private String sexo;
    private int reputacao;

    public Paciente(String nome, Date dataNasc, String sexo, int reputacao) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.reputacao = reputacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getReputacao() {
        return reputacao;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }
}
