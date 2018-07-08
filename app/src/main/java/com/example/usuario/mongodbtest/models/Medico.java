package com.example.usuario.mongodbtest.models;

public class Medico {
    private String nome;
    private String cpf;
    private String crm;
    private int reputacao;
    private String telefone;
    private String senha;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getReputacao() {
        return reputacao;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medico(String nome, String cpf, String crm, int reputacao, String telefone, String senha, String email) {

        this.nome = nome;
        this.cpf = cpf;
        this.crm = crm;
        this.reputacao = reputacao;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
    }
}
