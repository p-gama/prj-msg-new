package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarMensagemUseCaseImpl implements CadastrarMensagemUseCase {
    @Autowired
    private MensagemGateway mensagemGateway;

    @Autowired
    private MensagemMapper mensagemMapper;


    @Override
    public MensagemEntity cadastrarMensagem(MensagemEntity mensagem) {
        return mensagemGateway.save(mensagem);
    }
}

