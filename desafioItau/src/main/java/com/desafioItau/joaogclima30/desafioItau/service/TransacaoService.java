package com.desafioItau.joaogclima30.desafioItau.service;

import com.desafioItau.joaogclima30.desafioItau.dto.TransacaoDTO;
import com.desafioItau.joaogclima30.desafioItau.model.TransacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    @Autowired
    TransacaoModel transacaoModel;

    public TransacaoDTO receberTransacao(Double valor, OffsetDateTime dataHora){
            var transacaoDTO = new TransacaoDTO(valor, dataHora);
            transacaoModel.setValor(valor);
            transacaoModel.setDataHora(dataHora);
            return transacaoDTO;
        }

    }

}
