package com.pgama.projectmsgnew.infra.dataprovider;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.exception.MensagemNaoEncontradaException;
import com.pgama.projectmsgnew.infra.MensagemMapper;
import com.pgama.projectmsgnew.infra.entity.MensagemEntityDb;
import com.pgama.projectmsgnew.domain.gateway.MensagemGateway;
import com.pgama.projectmsgnew.infra.repository.MensagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class MensagemDataProvider implements MensagemGateway {

    private final MensagemRepository mensagemRepository;

    @Autowired
    private final MensagemMapper mensagemMapper;

    @Override
    public Optional<MensagemEntity> findById(Long id) {
        Optional<MensagemEntityDb> mensagem = mensagemRepository.findById(id);
        return mensagem.map(mensagemMapper::toDomain);
    }


    @Override
    public MensagemEntity save(MensagemEntity mensagem) {
        MensagemEntityDb mensagemEntityDb = mensagemMapper.toEntity(mensagem);
        MensagemEntityDb mensagemSalva = mensagemRepository.save(mensagemEntityDb);
        return mensagemMapper.toDomain(mensagemSalva);
    }


    public void deletarMensagem(Long id) {
        MensagemEntityDb mensagemEntityDb = mensagemRepository.findById(id)
                .orElseThrow(() -> new MensagemNaoEncontradaException("Mensagem com id " + id + " nao encontrada"));
        mensagemRepository.delete(mensagemEntityDb);
    }

    @Override
    public Page<MensagemEntity> listarMensagens(Pageable pageable) {
        Page<MensagemEntityDb> mensagensDb = mensagemRepository.findAll(pageable);
        return mensagensDb.map(mensagemMapper::toEntity);
    }
}





