package com.pgama.projectmsg.service;

import com.pgama.projectmsg.model.Mensagem;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface MensagemService  {

    Iterable<Mensagem> listAllMensagens();

    Optional<Mensagem> getMensagemById(Long id);

    Mensagem saveMensagem(Mensagem mensagem);

    Mensagem update(Mensagem mensagem);

    void deleteMensagem(Long id);

    Page<Mensagem> findAll(Pageable pageable);
}
