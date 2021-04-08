package com.br.desafio.iti.regras.impl;

import org.springframework.stereotype.Component;
import com.br.desafio.iti.regras.RegrasSenhaInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegraQtdeCaracteres implements RegrasSenhaInterface {

	@Override
	public boolean validarRegrasSenha(String senha) {
		
        log.info("Verifica se a senha tem nove ou mais caracteres");

        return senha.length() >= 9;
    }
}
