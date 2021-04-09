package com.br.desafio.iti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import br.com.desafio.iti.DesafioitiApplication;
import br.com.desafio.iti.controller.ValidacaoController;
import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.service.ValidacaoSenhaService;

@ContextConfiguration(classes={DesafioitiApplication.class, ValidacaoController.class})
@SpringBootTest
public class RegraEspacoEmBrancoTeste {

	@Autowired
	private ValidacaoSenhaService validacaoSenhaService;
	
	@Autowired
	private ValidacaoController validacaoController;
	
	@Test
	public void verificarSenhaComEspacoEmBrancoValidaControllerTesteValido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9@fok");
		ResponseEntity<SenhaStatusDTO> resultado = validacaoController.validarSenha(senhaDTO);
		assertEquals(resultado.getBody().isSenhaValida(), true);
	}
	
	@Test
	public void verificarSenhaComEspacoEmBrancoValidaControllerTesteInvalido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("");
		ResponseEntity<SenhaStatusDTO> resultado = validacaoController.validarSenha(senhaDTO);
		assertEquals(resultado.getBody().isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComEspacoEmBrancoTesteValido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!fok");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), true);
	}
	
	@Test
	public void verificarSenhaComEspacoEmBrancoTesteInvalido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!fo k");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
}
