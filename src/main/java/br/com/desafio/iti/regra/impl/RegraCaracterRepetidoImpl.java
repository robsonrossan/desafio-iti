package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraCaracterRepetidoImpl implements Regra {

    @Override
    public boolean validarRegra(String senha) {

        log.info("Verifica se a senha tem caracteres repetidos");

        return contemCaracteresDuplicados(senha);
    }

    private boolean contemCaracteresDuplicados(String senha) {
        for (int i = 0; i < senha.length(); i++) {
            for (int j = i + 1; j < senha.length(); j++) {
                if (senha.charAt(i) == senha.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
