package com.example.usuario.mongodbtest.models;

public class Consulta {
    private Medico medico;
    private Especialidade especialidade;
    private double valor;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Consulta(Medico medico, Especialidade especialidade, double valor) {

        this.medico = medico;
        this.especialidade = especialidade;
        this.valor = valor;
    }
}
