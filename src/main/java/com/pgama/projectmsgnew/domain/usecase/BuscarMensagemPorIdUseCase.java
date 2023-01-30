package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;

public interface BuscarMensagemPorIdUseCase {

    MensagemEntity buscarMensagemPorId(Long id);


}
