package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraCaracterEspecialImplTeste {

    private RegraCaracterEspecialImpl regraCaracterEspecial = new RegraCaracterEspecialImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "aa!aaa",
            "aa@aaa",
            "aa#aaa",
            "aa$aaa",
            "aa%aaa",
            "aa^aaa",
            "aa&aaa",
            "aa*aaa",
            "aa(aaa",
            "aa)aaa",
            "aa-aaa",
            "aa+aaa"
    })
    public void verificarSenhaComAoMenosUmCaracterEspecialPermitido(String valor) {
        assertTrue(regraCaracterEspecial.validarRegra(valor));
    }

    @Test
    public void verificarSenhaSemNenhumCaracterEspecial() {
        assertFalse(regraCaracterEspecial.validarRegra("aaaaaa"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa=aaa", "aa[aaa", "aa}aaa"})
    public void verificarSenhaComCaracterEspecialNaoPermitido(String valor) {
        assertFalse(regraCaracterEspecial.validarRegra(valor));
    }
}
