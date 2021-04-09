package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraCaracterRepetidoImplTeste {

    private RegraCaracterRepetidoImpl regraCaracterRepetidoImpl = new RegraCaracterRepetidoImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "abca",
            "abac",
            "aabc",
            "aaaa"
    })
    public void verificarSenhaComCaracteresRepetidos(String valor) {
        assertFalse(regraCaracterRepetidoImpl.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemCaracteresRepetidos() {
        assertTrue(regraCaracterRepetidoImpl.validarRegra("abcd"));
    }
}
