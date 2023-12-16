package com.xjgv.junit5app.ejemplos.models.excepciones;

public class DineroInsuficienteException extends RuntimeException {
    public DineroInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
