package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarMensagemUseCaseImpl implements DeletarMensagemUseCase{

    @Autowired
    private MensagemGateway mensagemGateway;

    @Override
    public void deletarMensagem(Long id) {
        mensagemGateway.deletarMensagem(id);
    }
}
