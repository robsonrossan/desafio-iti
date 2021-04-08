package com.br.desafio.iti.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SenhaDTO {

    private String senha;
    
    @JsonIgnore
    public boolean validarParametroSenha() {
        return Objects.isNull(this.senha);
    }
}