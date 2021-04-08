package br.com.desafio.iti.regra;

import br.com.desafio.iti.regras.impl.RegraCaracterEspecial;
import br.com.desafio.iti.regras.impl.RegraCaracterRepetido;
import br.com.desafio.iti.regras.impl.RegraEspacoEmBranco;
import br.com.desafio.iti.regras.impl.RegraLetraMaiuscula;
import br.com.desafio.iti.regras.impl.RegraLetraMinuscula;
import br.com.desafio.iti.regras.impl.RegraQtdeCaracteres;
import br.com.desafio.iti.regras.impl.RegraUmDigito;
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
