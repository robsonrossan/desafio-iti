package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegraUmDigitoImpl implements Regra {

    @Override
    public boolean validarRegra(String senha) {

        log.info("Verifica se a senha tem ao menos 1 dígito");

        return senha.chars().anyMatch(Character::isDigit);
    }
}
