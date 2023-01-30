package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ListarMensagensUseCaseImpl implements ListarMensagensUseCase {


    private final MensagemGateway mensagemGateway;

    public ListarMensagensUseCaseImpl( MensagemGateway mensagemGateway) {
        this.mensagemGateway = mensagemGateway;
    }

    @Override
    public Page<MensagemEntity> listarMensagens(Pageable pageable) {
        return mensagemGateway.listarMensagens(pageable);
    }


}

