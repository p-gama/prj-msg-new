package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.controller.dto.MensagemDTO;
import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import com.pgama.projectmsgnew.exception.MensagemNaoEncontradaException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarMensagemPorIdUseCaseImpl implements BuscarMensagemPorIdUseCase {

    @Autowired
    private MensagemGateway mensagemGateway;

    @Autowired
    private MensagemMapper mensagemMapper;
    @Override
    public MensagemDTO buscarMensagemPorId(Long id) {
        Optional<MensagemEntity> mensagemEntity = mensagemGateway.findById(id);
        if (mensagemEntity.isEmpty()) {
            throw new MensagemNaoEncontradaException("A mensagem não foi encontrada.");
        }
        return mensagemMapper.toDto(mensagemEntity.get());
    }
}
