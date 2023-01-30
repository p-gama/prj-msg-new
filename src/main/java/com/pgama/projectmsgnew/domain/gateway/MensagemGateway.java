package com.pgama.projectmsgnew.domain.gateway;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;


public interface MensagemGateway {

        Optional<MensagemEntity> findById(Long id);
        MensagemEntity save(MensagemEntity mensagem);

        Page<MensagemEntity> listarMensagens(Pageable pageable);

        void deletarMensagem(Long id);

}



