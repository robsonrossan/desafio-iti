package br.com.desafio.iti.service.impl;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.regra.Regra;
import br.com.desafio.iti.service.ValidacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacaoServiceImpl implements ValidacaoService {

    private List<Regra> regrasValidacao;

    public ValidacaoServiceImpl(List<Regra> regrasValidacao) {
        this.regrasValidacao = regrasValidacao;
    }

    public SenhaStatusDTO validarSenha(SenhaDTO senhaDTO) {
        boolean senhaOk = false;

        for (Regra regra : regrasValidacao) {
            senhaOk = regra.validarRegra(senhaDTO.getSenha());
            if (!senhaOk) {
                break;
            }
        }
        return SenhaStatusDTO.builder()
                .senhaValida(senhaOk)
                .build();
    }
}
