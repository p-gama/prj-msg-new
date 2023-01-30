package com.pgama.projectmsgnew.domain.usecase;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListarMensagensUseCase {

    Page<MensagemEntity> listarMensagens(Pageable pageable);
}
