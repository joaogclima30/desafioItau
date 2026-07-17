package com.desafioItau.joaogclima30.desafioItau.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.;

import java.time.OffsetDateTime;


public record TransacaoDTO(@NotNull(message = "Esse campo não pode ser nulo") @Negative Double valor,
                           @NotNull(message = "Esse campo não pode ser nulo")
                           @Past(message = "Para uma transação ocorrer, deve ocorrer no passado") OffsetDateTime dataHora) {


}
