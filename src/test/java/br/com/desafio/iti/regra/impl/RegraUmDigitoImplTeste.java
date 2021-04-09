package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraUmDigitoImplTeste {

    private RegraUmDigitoImpl regraUmDigito = new RegraUmDigitoImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "Abca1",
            "Ab1Ac1"
    })
    public void verificarSenhaComAoMenosUmDigito(String valor) {
        assertTrue(regraUmDigito.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNehhumDigito() {
        assertFalse(regraUmDigito.validarRegra("Abcd"));
    }

}
