package com.pgama.projectmsg.model;

public class CamposInvalidos {

    private final String campo;
    private final String descricao;

    public CamposInvalidos(String descricao, String campo) {
        this.descricao = descricao;
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public String getDescricao() {
        return descricao;
    }
}
