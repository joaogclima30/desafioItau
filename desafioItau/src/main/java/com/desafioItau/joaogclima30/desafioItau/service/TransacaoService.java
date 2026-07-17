package com.desafioItau.joaogclima30.desafioItau.service;

import com.desafioItau.joaogclima30.desafioItau.dto.TransacaoRequestDTO;
import com.desafioItau.joaogclima30.desafioItau.model.TransacaoModel;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransacaoService {

    private final Queue<TransacaoRequestDTO> transacoes = new ConcurrentLinkedDeque<>();

    public void receberTransacao(TransacaoRequestDTO dto) {
        transacoes.add(dto);
    }

        public void limparTransacoes(TransacaoRequestDTO dto) {
            transacoes.clear();
        }

    public DoubleSummaryStatistics getEstatisticas () {
        OffsetDateTime horarioAtual = OffsetDateTime.now();
        return (DoubleSummaryStatistics) transacoes.stream().filter(t -> t.dataHora().isAfter(horarioAtual.minusSeconds(60)));
    }

}
