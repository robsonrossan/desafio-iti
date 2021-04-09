package br.com.desafio.iti.regra.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegraQtdeCaracterImplTeste {

    private RegraQtdeCaracteresImpl regraQtdeCaracteres = new RegraQtdeCaracteresImpl();

    @ParameterizedTest
    @ValueSource(strings = {
            "aaabbbccc",
            "aaabbbcccd"
    })
    public void verificarSenhaComAQtdeMinimaDeCaracters(String valor) {
        assertTrue(regraQtdeCaracteres.validarRegra(valor));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "aaabbbcc",
            ""
    })
    public void verificarSenhaComAQtdeInsuficienteDeCaracteres(String valor) {
        assertFalse(regraQtdeCaracteres.validarRegra(valor));
    }
}
