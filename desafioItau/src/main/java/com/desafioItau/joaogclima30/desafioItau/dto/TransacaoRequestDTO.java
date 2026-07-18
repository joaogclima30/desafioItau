package com.desafioItau.joaogclima30.desafioItau.dto;

import jakarta.validation.constraints.*;

import java.time.OffsetDateTime;


public class TransacaoRequestDTO {



    @NotNull(message = "O campo valor não pode ser nulo")
    @DecimalMin(value = "0.0", message = "O valor da transação não pode ser negativo")
    private Double valor;

    @NotNull(message = "O campo dataHora não pode ser nulo")
    @PastOrPresent(message = "A transação não pode ocorrer no futuro")
    private OffsetDateTime dataHora;

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
