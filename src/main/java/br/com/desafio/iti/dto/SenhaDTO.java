package br.com.desafio.iti.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.Objects;

@Data
public class SenhaDTO {

    private String senha;

    @JsonIgnore
    public boolean validarParametroSenha() {
        return !Objects.isNull(this.senha) && this.senha.length() > 0;
    }
}