package com.desafioItau.joaogclima30.desafioItau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.OffsetDateTime;


public class TransacaoRequestDTO {


    @NotNull(message = "Esse campo não pode ser nulo")
    @Min(0)
    private double valor;

    @NotNull(message = "Esse campo não pode ser nulo")
    @Past(message = "Para uma transação ocorrer, deve ocorrer no passado")
    private OffsetDateTime dataHora;

    public TransacaoRequestDTO(double valor, OffsetDateTime dataHora) {
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
