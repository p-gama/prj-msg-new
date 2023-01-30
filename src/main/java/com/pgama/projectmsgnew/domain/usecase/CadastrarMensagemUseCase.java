package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;

public interface CadastrarMensagemUseCase {

    MensagemEntity cadastrarMensagem(MensagemEntity mensagem);
}
