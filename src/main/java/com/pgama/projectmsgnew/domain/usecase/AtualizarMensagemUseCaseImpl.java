package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.MensagemMapper;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import com.pgama.projectmsgnew.exception.MensagemNaoEncontradaException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AtualizarMensagemUseCaseImpl implements AtualizarMensagemUseCase {

    @Autowired
    private MensagemGateway mensagemGateway;
    @Autowired
    private MensagemMapper mensagemMapper;

    @Override
    public MensagemEntity atualizarMensagem(Long id, MensagemEntity mensagem) {
        MensagemEntity mensagemSalva = mensagemGateway.findById(id)
                .orElseThrow(() -> new MensagemNaoEncontradaException("A mensagem não foi encontrada."));

        mensagemSalva.setTitulo(mensagem.getTitulo());
        mensagemSalva.setTexto(mensagem.getTexto());
        mensagemSalva.setStatus(mensagem.getStatus());
        mensagemSalva.setDataEnvio(mensagem.getDataEnvio());
        mensagemSalva.setContatoNome(mensagem.getContatoNome());
        mensagemSalva.setContatoEmail(mensagem.getContatoEmail());
        mensagemSalva.setContatoTelefone(mensagem.getContatoTelefone());

        return mensagemGateway.save(mensagemSalva);
    }
}