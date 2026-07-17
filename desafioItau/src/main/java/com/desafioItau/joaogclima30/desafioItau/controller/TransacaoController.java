package com.desafioItau.joaogclima30.desafioItau.controller;

import com.desafioItau.joaogclima30.desafioItau.dto.TransacaoRequestDTO;
import com.desafioItau.joaogclima30.desafioItau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Object> receber(@Valid @RequestBody TransacaoRequestDTO dto){
        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            return ResponseEntity.unprocessableEntity().build();
        }
        transacaoService.receberTransacao(new TransacaoRequestDTO(dto.valor(), dto.dataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deletar(@Valid @RequestBody TransacaoRequestDTO dto){
        transacaoService.limparTransacoes(dto);
        return ResponseEntity.ok().build();
    }

}

