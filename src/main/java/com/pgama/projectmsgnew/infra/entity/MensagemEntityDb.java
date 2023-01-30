package com.pgama.projectmsgnew.infra.entity;


import com.pgama.projectmsgnew.domain.entity.MensagemEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="mensagem")
public class MensagemEntityDb  extends MensagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_mensagem")
    private String titulo;

    @Column(name = "mensagem")
    private String texto;

    @Column(name = "status")
    private String status;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;

    @Column(name = "contato_nome")
    private String contatoNome;
    @Column(name = "contato_email")
    private String contatoEmail;
    @Column(name = "contato_tel")
    private String contatoTelefone;

    public MensagemEntityDb() {

    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
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

    public MensagemEntityDb(Long id, String titulo, String texto, String status, LocalDateTime dataEnvio, String contatoNome, String contatoEmail, String contatoTelefone) {
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

