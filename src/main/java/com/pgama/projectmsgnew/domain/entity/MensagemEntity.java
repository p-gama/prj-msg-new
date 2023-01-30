package com.pgama.projectmsgnew.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MensagemEntity {

    private Long id;

    private String titulo;

    private String texto;

    private String status;

    private LocalDateTime dataEnvio;

    private String contatoNome;

    private String contatoEmail;

    private String contatoTelefone;


}

