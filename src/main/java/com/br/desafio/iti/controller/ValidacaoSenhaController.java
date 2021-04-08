package com.br.desafio.iti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.desafio.iti.dto.SenhaDTO;
import com.br.desafio.iti.dto.SenhaStatusDTO;
import com.br.desafio.iti.service.ValidacaoSenhaService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/iti/validacao")
public class ValidacaoSenhaController {

    @Autowired
    ValidacaoSenhaService validacaoSenhaService;

    @PostMapping("/senha")
    public ResponseEntity<SenhaStatusDTO> validarSenha(@NonNull @RequestBody SenhaDTO senhaDTO) {

        if (senhaDTO.validarParametroSenha()) {
            log.error("Valor Senha Obrigatório");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(validacaoSenhaService.validarRegrasSenha(senhaDTO));
    }
}
