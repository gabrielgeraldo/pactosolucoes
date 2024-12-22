package com.pactosolucoes.rh.exception;

public class VagaNotFoundException extends RuntimeException {

    public VagaNotFoundException() {
        super("Vaga não encontrado");
    }

    public VagaNotFoundException(String message) {
        super(message);
    }
}