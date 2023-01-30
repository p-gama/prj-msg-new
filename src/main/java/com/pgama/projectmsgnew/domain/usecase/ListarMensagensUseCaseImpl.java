package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListarMensagensUseCaseImpl implements ListarMensagensUseCase {


    @Autowired
    private final MensagemGateway mensagemGateway;
    @Autowired
    private MensagemMapper mensagemMapper;

    @Override
    public Page<MensagemEntity> listarMensagens(Pageable pageable) {
        return mensagemGateway.listarMensagens(pageable);
    }
}

