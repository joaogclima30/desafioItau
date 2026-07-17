package com.desafioItau.joaogclima30.desafioItau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.OffsetDateTime;


public record TransacaoRequestDTO(@NotNull(message = "Esse campo não pode ser nulo") @Min(0) Double valor,
                                  @NotNull(message = "Esse campo não pode ser nulo")
                                  @Past(message = "Para uma transação ocorrer, deve ocorrer no passado") OffsetDateTime dataHora) {


}
