package com.br.desafio.iti.regras.impl;

import org.springframework.stereotype.Component;
import com.br.desafio.iti.regras.RegrasSenhaInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegraEspacoEmBranco implements RegrasSenhaInterface {

    @Override
    public boolean validarRegrasSenha(String senha) {

        log.info("Verifica se a senha tem espaço em branco");

        return senha.chars().noneMatch(Character::isWhitespace); 
    }

}
