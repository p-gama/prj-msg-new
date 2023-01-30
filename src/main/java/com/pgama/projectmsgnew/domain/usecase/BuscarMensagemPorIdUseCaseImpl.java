package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import com.pgama.projectmsgnew.exception.MensagemNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;

public class BuscarMensagemPorIdUseCaseImpl implements BuscarMensagemPorIdUseCase {

    @Autowired
    private MensagemGateway mensagemGateway;
    @Override
    public MensagemEntity buscarMensagemPorId(Long id) {
        return mensagemGateway.findById(id).orElseThrow(() -> new MensagemNaoEncontradaException("A mensagem não foi encontrada."));
    }


}
