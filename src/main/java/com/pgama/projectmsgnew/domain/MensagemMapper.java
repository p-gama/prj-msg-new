package com.pgama.projectmsgnew.domain;

import com.pgama.projectmsgnew.controller.dto.MensagemDTO;
import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface MensagemMapper {
    MensagemEntity toEntity(MensagemDTO mensagemDTO);


    MensagemDTO toDto(MensagemEntity mensagem);

}