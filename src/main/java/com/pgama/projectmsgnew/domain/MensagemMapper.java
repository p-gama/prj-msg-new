package com.pgama.projectmsgnew.domain;

import com.pgama.projectmsgnew.controller.dto.MensagemDTO;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;




@Mapper(componentModel = "spring")
public interface MensagemMapper {

    MensagemEntity toEntity(MensagemDTO mensagemDTO);

    MensagemDTO toDto(MensagemEntity entity);

}

//    public default MensagemEntity toEntity(MensagemDTO mensagemDTO) {
//        MensagemEntity mensagemEntity = new MensagemEntity();
//        mensagemEntity.setTitulo(mensagemDTO.getTitulo());
//        mensagemEntity.setTexto(mensagemDTO.getTexto());
//        mensagemEntity.setStatus(mensagemDTO.getStatus());
//        mensagemEntity.setDataEnvio(mensagemDTO.getDataEnvio());
//        mensagemEntity.setContatoNome(mensagemDTO.getContatoNome());
//        mensagemEntity.setContatoEmail(mensagemDTO.getContatoEmail());
//        mensagemEntity.setContatoTelefone(mensagemDTO.getContatoTelefone());
//        return mensagemEntity;
//    }


//    public default MensagemDTO toDto(MensagemEntity entity) {
//        MensagemDTO mensagemDTO = new MensagemDTO(entity.getId(), entity.getTitulo(), entity.getTexto(), entity.getStatus(), entity.getDataEnvio(), entity.getContatoNome(), entity.getContatoEmail(), entity.getContatoTelefone());
//        mensagemDTO.setTitulo(entity.getTitulo());
//        mensagemDTO.setTexto(entity.getTexto());
//        mensagemDTO.setStatus(entity.getStatus());
//        mensagemDTO.setDataEnvio(entity.getDataEnvio());
//        mensagemDTO.setContatoNome(entity.getContatoNome());
//        mensagemDTO.setContatoEmail(entity.getContatoEmail());
//        mensagemDTO.setContatoTelefone(entity.getContatoTelefone());
//        return mensagemDTO;
//
//    }
//
//}