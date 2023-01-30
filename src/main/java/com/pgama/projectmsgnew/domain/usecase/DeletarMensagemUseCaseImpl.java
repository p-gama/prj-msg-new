package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarMensagemUseCaseImpl implements DeletarMensagemUseCase{

    @Autowired
    private MensagemGateway mensagemGateway;

    @Autowired
    private MensagemMapper mensagemMapper;
    @Override
    public void deletarMensagem(Long id) {
        mensagemGateway.deletarMensagem(id);
    }
}
