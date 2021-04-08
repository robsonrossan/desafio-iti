package com.br.desafio.iti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import com.br.desafio.iti.dto.SenhaDTO;
import com.br.desafio.iti.dto.SenhaStatusDTO;
import com.br.desafio.iti.service.ValidacaoSenhaService;

@SpringBootTest
public class DesafioitiApplicationTests {

	@InjectMocks
	private static ValidacaoSenhaService validacaoSenhaService;
	
	@Test
	public void verificarSenhaComNoveCaracter() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!fo");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComAoMenosUmDigito() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComAoMenosUmaLetraMinuscula() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("ABTP9!FOK");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComAoMenosUmaLetraMaiuscula() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("abtp9!fok");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComAoMenosUmCaracterEspecial() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9_fok");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComCaracterRepetido() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!foo");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void verificarSenhaComEspacoEmBranco() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!fo k");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), false);
	}
	
	@Test
	public void validandoSenhaConteudoOK() {
		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setSenha("AbTp9!fok");
		SenhaStatusDTO resultado = validacaoSenhaService.validarRegrasSenha(senhaDTO);
		assertEquals(resultado.isSenhaValida(), true);
	}
}
