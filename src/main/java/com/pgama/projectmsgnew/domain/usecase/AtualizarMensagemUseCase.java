package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;

public interface AtualizarMensagemUseCase {

   MensagemEntity atualizarMensagem(Long id, MensagemEntity mensagem);

}
