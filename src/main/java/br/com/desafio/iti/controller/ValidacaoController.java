package br.com.desafio.iti.controller;

import br.com.desafio.iti.dto.SenhaDTO;
import br.com.desafio.iti.dto.SenhaStatusDTO;
import br.com.desafio.iti.service.ValidacaoService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/iti/validacao")
public class ValidacaoController {

    private ValidacaoService validacaoService;

    public ValidacaoController(ValidacaoService validacaoService) {
        this.validacaoService = validacaoService;
    }

    @PostMapping("/senha")
    public ResponseEntity<SenhaStatusDTO> validarSenha(@NonNull @RequestBody SenhaDTO senhaDTO) {

        if (!senhaDTO.validarParametroSenha()) {
            log.error("Valor Senha Obrigatório");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(validacaoService.validarSenha(senhaDTO));
    }
}
