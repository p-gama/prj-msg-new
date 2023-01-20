package com.pgama.projectmsg.model;

import java.util.List;

public class CamposInvalidosException extends RuntimeException {

        public CamposInvalidosException(List<CamposInvalidos> camposInvalidos) {
            super("campos invalidos" + camposInvalidos);
        }

    }

