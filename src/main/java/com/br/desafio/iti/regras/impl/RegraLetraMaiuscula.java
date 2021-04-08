package com.br.desafio.iti.regras.impl;

import org.springframework.stereotype.Component;
import com.br.desafio.iti.regras.RegrasSenhaInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegraLetraMaiuscula implements RegrasSenhaInterface {

    @Override
    public boolean validarRegrasSenha(String senha) {

        log.info("Verifica se a senha tem pelo  menos uma letra maiúscula");

        return senha.chars().anyMatch(Character::isUpperCase);
    }

}
