package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraLetraMaiusculaImplTeste {

    private RegraLetraMaiusculaImpl regraLetraMaiuscula = new RegraLetraMaiusculaImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "Abca",
            "AbAc"
    })
    public void verificarSenhaComAoMenosUmaLetraMaiscula(String valor) {
        assertTrue(regraLetraMaiuscula.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNenhumaLetraMaiscula() {
        assertFalse(regraLetraMaiuscula.validarRegra("abcd"));
    }
}
