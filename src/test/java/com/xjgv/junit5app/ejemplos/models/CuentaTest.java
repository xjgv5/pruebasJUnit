package com.xjgv.junit5app.ejemplos.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal(12313131));
        String esperado = "Andres";
        String actual = cuenta.getPersona();
        Assertions.assertEquals(esperado, actual);
    }
}