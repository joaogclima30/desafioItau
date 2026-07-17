package com.desafioItau.joaogclima30.desafioItau.model;

import java.time.OffsetDateTime;

public class TransacaoModel {

    private double valor;
    private OffsetDateTime dataHora;

    public TransacaoModel(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }


    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
