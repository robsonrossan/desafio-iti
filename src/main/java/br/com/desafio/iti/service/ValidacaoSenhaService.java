package br.com.desafio.iti.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.regra.RegrasSenhaInterface;

@Service
public class ValidacaoSenhaService {

	private List<RegrasSenhaInterface> regrasSenha;
	
	public ValidacaoSenhaService(List<RegrasSenhaInterface> regrasSenha) {
		this.regrasSenha = regrasSenha;
	}
	
    public SenhaStatusDTO validarRegrasSenha(SenhaDTO senhaDTO) {
    	boolean senhaOk = false;
    	
    	for(RegrasSenhaInterface regra: regrasSenha) {
    		senhaOk = regra.validarRegrasSenha(senhaDTO.getSenha());
    		if(!senhaOk) {
    			break;
    		}
    	}
        return SenhaStatusDTO.builder()
                .senhaValida(senhaOk)
                .build();
    }
}
