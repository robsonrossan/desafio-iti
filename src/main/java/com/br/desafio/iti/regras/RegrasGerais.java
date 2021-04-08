package com.br.desafio.iti.regras;

import com.br.desafio.iti.regras.impl.RegraCaracterEspecial;
import com.br.desafio.iti.regras.impl.RegraCaracterRepetido;
import com.br.desafio.iti.regras.impl.RegraLetraMaiuscula;
import com.br.desafio.iti.regras.impl.RegraLetraMinuscula;
import com.br.desafio.iti.regras.impl.RegraQtdeCaracteres;
import com.br.desafio.iti.regras.impl.RegraUmDigito;
import com.br.desafio.iti.regras.impl.RegraEspacoEmBranco;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegrasGerais {

	NOVE_OU_MAIS_CARACTERES(new RegraQtdeCaracteres()),
	
	PELO_MENOS_UM_DIGITO (new RegraUmDigito()),
	
	PELO_MENOS_UMA_LETRA_MINUSCULA (new RegraLetraMinuscula()),
	
	PELO_MENOS_UMA_LETRA_MAIUSCULA (new RegraLetraMaiuscula()),
	
	CARACTER_ESPECIAL (new RegraCaracterEspecial()),
	
	CARACTER_REPETIDO (new RegraCaracterRepetido()),
	
	ESPACO_EM_BRANCO (new RegraEspacoEmBranco());
		
	private final RegrasSenhaInterface regrasSenhaInterface;
}
