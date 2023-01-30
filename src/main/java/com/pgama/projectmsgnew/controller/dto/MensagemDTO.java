package com.pgama.projectmsgnew.controller.dto;

import com.pgama.projectmsgnew.domain.entity.MensagemEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class MensagemDTO  {

    private Long id;

    private String titulo;

    private String texto;

    private String status;

    private LocalDateTime dataEnvio;

    private String contatoNome;

    private String contatoEmail;

    private String contatoTelefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public void setContatoNome(String contatoNome) {
        this.contatoNome = contatoNome;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }

    public void setContatoEmail(String contatoEmail) {
        this.contatoEmail = contatoEmail;
    }

    public String getContatoTelefone() {
        return contatoTelefone;
    }

    public void setContatoTelefone(String contatoTelefone) {
        this.contatoTelefone = contatoTelefone;
    }

    public MensagemDTO(Long id, String titulo, String texto, String status, LocalDateTime dataEnvio, String contatoNome, String contatoEmail, String contatoTelefone) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.status = status;
        this.dataEnvio = dataEnvio;
        this.contatoNome = contatoNome;
        this.contatoEmail = contatoEmail;
        this.contatoTelefone = contatoTelefone;
    }
}
