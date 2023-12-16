package com.xjgv.junit5app.ejemplos.models;

import com.xjgv.junit5app.ejemplos.models.excepciones.DineroInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        String esperado = "Andres";
        String actual = cuenta.getPersona();
        assertEquals(esperado, actual);
        assertTrue(actual.equals("Andres"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        assertEquals(1000.123, cuenta.getSaldo().doubleValue());
        assertNotNull(cuenta.getSaldo());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.999"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.999"));

        //assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);

    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.123", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.123", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteExceptionCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.123"));
        Exception exeception =assertThrows(DineroInsuficienteException.class, () -> {
           cuenta.debito(new BigDecimal(1500));
        });
        String esperado = "Saldo insuficiente";
        String actual = exeception.getMessage();
        assertEquals(esperado, actual);
    }
}