package com.pgama.projectmsgnew.infra;

import com.pgama.projectmsgnew.controller.dto.MensagemDTO;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import com.pgama.projectmsgnew.infra.entity.MensagemEntityDb;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MensagemMapper {

    public default MensagemEntity toDomain(MensagemEntityDb entityDb) {
        MensagemEntity mensagemEntity = new MensagemEntity();
        mensagemEntity.setId(mensagemEntity.getId());
        mensagemEntity.setTitulo(mensagemEntity.getTitulo());
        mensagemEntity.setTexto(mensagemEntity.getTexto());
        mensagemEntity.setStatus(mensagemEntity.getStatus());
        mensagemEntity.setDataEnvio(mensagemEntity.getDataEnvio());
        mensagemEntity.setContatoNome(mensagemEntity.getContatoNome());
        mensagemEntity.setContatoEmail(mensagemEntity.getContatoEmail());
        mensagemEntity.setContatoTelefone(mensagemEntity.getContatoTelefone());
        return mensagemEntity;
    }

    public default MensagemEntityDb  toEntity(MensagemEntity mensagemEntity) {
        MensagemEntityDb entityDb = new MensagemEntityDb();
        entityDb.setId(entityDb.getId());
        entityDb.setTitulo(entityDb.getTitulo());
        entityDb.setTexto(entityDb.getTexto());
        entityDb.setStatus(entityDb.getStatus());
        entityDb.setDataEnvio(entityDb.getDataEnvio());
        entityDb.setContatoNome(entityDb.getContatoNome());
        entityDb.setContatoEmail(entityDb.getContatoEmail());
        entityDb.setContatoTelefone(entityDb.getContatoTelefone());

        return entityDb;
    }

    public static MensagemDTO toDto(MensagemEntity mensagem) {
        return new MensagemDTO(mensagem.getId(), mensagem.getTitulo(), mensagem.getTexto(), mensagem.getStatus(), mensagem.getDataEnvio(), mensagem.getContatoNome(), mensagem.getContatoEmail(), mensagem.getContatoTelefone());
    }

    public static MensagemEntity toEntity(MensagemDTO mensagem) {
        return new MensagemEntity(mensagem.getId(), mensagem.getTitulo(), mensagem.getTexto(), mensagem.getStatus(), mensagem.getDataEnvio(), mensagem.getContatoNome(), mensagem.getContatoEmail(), mensagem.getContatoTelefone());
    }
}