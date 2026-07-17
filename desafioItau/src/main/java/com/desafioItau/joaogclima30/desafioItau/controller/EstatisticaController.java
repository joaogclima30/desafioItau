package com.desafioItau.joaogclima30.desafioItau.controller;

import com.desafioItau.joaogclima30.desafioItau.dto.EstatisticasResponse;
import com.desafioItau.joaogclima30.desafioItau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;


@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<EstatisticasResponse> estatistica(){
        DoubleSummaryStatistics stats = transacaoService.getEstatisticas();
        return ResponseEntity.ok(new EstatisticasResponse(stats));
    }

}
