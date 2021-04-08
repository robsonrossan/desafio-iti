package br.com.desafio.iti;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.desafio.iti.regra.RegrasSenhaInterface;
import br.com.desafio.iti.regras.impl.RegraCaracterEspecial;
import br.com.desafio.iti.regras.impl.RegraCaracterRepetido;
import br.com.desafio.iti.regras.impl.RegraEspacoEmBranco;
import br.com.desafio.iti.regras.impl.RegraLetraMaiuscula;
import br.com.desafio.iti.regras.impl.RegraLetraMinuscula;
import br.com.desafio.iti.regras.impl.RegraQtdeCaracteres;
import br.com.desafio.iti.regras.impl.RegraUmDigito;

@SpringBootApplication
public class DesafioitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioitiApplication.class, args);
	}

	@Bean
	public List<RegrasSenhaInterface> regrasSenhas(){
		List<RegrasSenhaInterface> regras = Arrays.asList(
				new RegraQtdeCaracteres(),
				new RegraUmDigito(),
				new RegraLetraMinuscula(),
				new RegraLetraMaiuscula(),
				new RegraCaracterEspecial(),
				new RegraCaracterRepetido(),
				new RegraEspacoEmBranco());
		return regras;
	}
}
