package com.desafioItau.joaogclima30.desafioItau.controller;

import com.desafioItau.joaogclima30.desafioItau.dto.TransacaoDTO;
import com.desafioItau.joaogclima30.desafioItau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @Autowired
    TransacaoDTO transacaoDTO;

    @PostMapping
    public ResponseEntity<Object> receberTransacoes(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.receberTransacao();
        return ResponseEntity.created().build();
    }


}

