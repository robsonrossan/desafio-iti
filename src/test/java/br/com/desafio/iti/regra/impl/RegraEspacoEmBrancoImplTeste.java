package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraEspacoEmBrancoImplTeste {

    private RegraEspacoEmBrancoImpl regraEspacoEmBranco = new RegraEspacoEmBrancoImpl();

    @Test
    public void verificarSenhaSemEspacoEmBranco() {
        assertTrue(regraEspacoEmBranco.validarRegra("abcd"));
    }

    @Test
    public void verificarSenhaComEspacoEmBranco() {
        assertFalse(regraEspacoEmBranco.validarRegra("ab cd"));
    }
}
