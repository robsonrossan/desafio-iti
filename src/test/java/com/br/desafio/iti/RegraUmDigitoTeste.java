package com.br.desafio.iti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import br.com.desafio.iti.controller.ValidacaoController;
import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.service.ValidacaoSenhaService;

@SpringBootTest(classes={br.com.desafio.iti.controller.ValidacaoController.class})
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"br.com.desafio.iti.controller.ValidacaoController"})
public class RegraUmDigitoTeste {
	
	@MockBean
	private static ValidacaoSenhaService validacaoSenhaService;
	
	@MockBean
	private static ValidacaoController validacaoController;
	
	@Test
	public void verificarSenhaComAoMenosUmDigitoValido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComAoMenosUmDigitoInvalido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}

}
