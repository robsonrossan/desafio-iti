package br.com.desafio.iti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.service.ValidacaoSenhaService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/iti/validacao")
public class ValidacaoController {

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
