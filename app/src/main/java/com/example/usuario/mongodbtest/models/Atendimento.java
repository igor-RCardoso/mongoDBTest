package com.example.usuario.mongodbtest.models;

import java.util.Date;

public class Atendimento {
    private Consulta consulta;
    private Paciente paciente;
    private Date dataConsulta;
    private double valor;
    private boolean emergencial;
    private boolean foi_pago;

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEmergencial() {
        return emergencial;
    }

    public void setEmergencial(boolean emergencial) {
        this.emergencial = emergencial;
    }

    public boolean isFoi_pago() {
        return foi_pago;
    }

    public void setFoi_pago(boolean foi_pago) {
        this.foi_pago = foi_pago;
    }

    public Atendimento(Consulta consulta, Paciente paciente, Date dataConsulta, double valor, boolean emergencial, boolean foi_pago) {
        this.consulta = consulta;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.valor = valor;
        this.emergencial = emergencial;
        this.foi_pago = foi_pago;
    }
}
