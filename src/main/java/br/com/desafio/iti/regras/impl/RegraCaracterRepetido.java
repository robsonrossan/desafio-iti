package br.com.desafio.iti.regras.impl;

import org.springframework.stereotype.Component;

import br.com.desafio.iti.regra.RegrasSenhaInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegraCaracterRepetido implements RegrasSenhaInterface {

	@Override
	public boolean validarRegrasSenha(String senha) {
		
		log.info("Verifica se a senha tem caracteres repetidos");
		
		return caracterUnico(senha);
	}
	
	private boolean caracterUnico(String senha) {

		for (int i = 0; i < senha.length(); i++) {

			for (int j = i + 1; j < senha.length(); j++) {

				if (senha.charAt(i) == senha.charAt(j)) {

					return false;
				}
			}
		}
		return true;
	}
}
