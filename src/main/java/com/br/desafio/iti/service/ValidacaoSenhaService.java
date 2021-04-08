package com.br.desafio.iti.service;

import org.springframework.stereotype.Service;
import com.br.desafio.iti.dto.SenhaDTO;
import com.br.desafio.iti.dto.SenhaStatusDTO;
import com.br.desafio.iti.regras.RegrasGerais;
import com.br.desafio.iti.util.regras.mapper.RegrasMapper;

@Service
public class ValidacaoSenhaService {

    public SenhaStatusDTO validarRegrasSenha(SenhaDTO senhaDTO) {
        
        boolean senhaOk = RegrasMapper.verificarRegrasSenha(senhaDTO.getSenha(),
        		RegrasGerais.NOVE_OU_MAIS_CARACTERES,
        		RegrasGerais.PELO_MENOS_UM_DIGITO,
        		RegrasGerais.PELO_MENOS_UMA_LETRA_MINUSCULA,
        		RegrasGerais.PELO_MENOS_UMA_LETRA_MAIUSCULA,        		
        		RegrasGerais.CARACTER_ESPECIAL,
        		RegrasGerais.CARACTER_REPETIDO,
        		RegrasGerais.ESPACO_EM_BRANCO);

        return SenhaStatusDTO.builder()
                .senhaValida(senhaOk)
                .build();
    }
}
