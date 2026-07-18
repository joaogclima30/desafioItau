package com.desafioItau.joaogclima30.desafioItau.service;

import com.desafioItau.joaogclima30.desafioItau.dto.TransacaoRequestDTO;
import com.desafioItau.joaogclima30.desafioItau.model.TransacaoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransacaoService {

    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);

    private final Queue<TransacaoModel> transacoes = new ConcurrentLinkedDeque<>();

    public void receberTransacao(TransacaoRequestDTO dto) {
        transacoes.add(new TransacaoModel(dto.getValor(), dto.getDataHora()));
        log.info("Transação registrada: valor={}, dataHora={}", dto.getValor(), dto.getDataHora());
    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public DoubleSummaryStatistics getEstatisticas() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        transacoes.removeIf(t -> t.getDataHora().isBefore(limite));

        return transacoes.stream()
                .mapToDouble(TransacaoModel::getValor)
                .summaryStatistics();
    }

}
