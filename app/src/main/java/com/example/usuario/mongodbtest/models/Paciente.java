package com.example.usuario.mongodbtest.models;

import java.util.Date;
import java.util.List;

public class Paciente {
    private String nome;
    private Date dataNasc;
    private String sexo;
    private EnderecoModel endereco;

    public Paciente(String nome, Date dataNasc, String sexo) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
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

}
