package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.controller.dto.MensagemDTO;


public interface BuscarMensagemPorIdUseCase {

    MensagemDTO buscarMensagemPorId(Long id);


}
