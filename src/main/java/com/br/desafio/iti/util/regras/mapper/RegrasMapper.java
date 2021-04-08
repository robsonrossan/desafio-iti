package com.br.desafio.iti.util.regras.mapper;

import com.br.desafio.iti.regras.RegrasGerais;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegrasMapper {

    public static boolean verificarRegrasSenha(String senha, RegrasGerais... regrasGerais) {

        for (RegrasGerais regra : regrasGerais) {
            
        	boolean senhaInvalida = !regra.getRegrasSenhaInterface().validarRegrasSenha(senha);

            if (senhaInvalida) {
                log.info("Senha Inválida");
                return false;
            }
        }
        log.info("Senha Válida");

        return true;
    }
}
