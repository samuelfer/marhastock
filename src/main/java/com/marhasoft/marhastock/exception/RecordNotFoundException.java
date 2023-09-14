package com.marhasoft.marhastock.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String mensagem) {
        super(mensagem);
    }
}
