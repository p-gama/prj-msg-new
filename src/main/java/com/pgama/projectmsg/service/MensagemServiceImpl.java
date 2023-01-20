package com.pgama.projectmsg.service;

import com.pgama.projectmsg.model.Mensagem;
import com.pgama.projectmsg.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class MensagemServiceImpl implements MensagemService {

    private MensagemRepository mensagemRepository;

    @Autowired
    public void setMensagemRepository(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    @Override
    public Iterable<Mensagem> listAllMensagens() {
        return mensagemRepository.findAll();
    }

    @Override
    public Optional<Mensagem> getMensagemById(Long id) {
        return mensagemRepository.findById(id);
    }

    @Override
    public Mensagem saveMensagem(Mensagem mensagem) {
        return  mensagemRepository.save(mensagem);
    }

    @Override
    public Mensagem update(Mensagem mensagem) {
        return  mensagemRepository.save(mensagem);
    }

    @Override
    public void deleteMensagem(Long id) {
        mensagemRepository.deleteById(id);
    }

    @Override
    public Page<Mensagem> findAll(Pageable pageable) {
        return mensagemRepository.findAll(pageable);
    }
}
