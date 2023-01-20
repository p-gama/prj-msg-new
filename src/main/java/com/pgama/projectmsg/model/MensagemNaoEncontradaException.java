package com.pgama.projectmsg.model;

public class MensagemNaoEncontradaException extends RuntimeException {

        public MensagemNaoEncontradaException(long mensagemId) {
            super("Mensagem com id  " +  mensagemId + " nao encontrada");
        }

    }

