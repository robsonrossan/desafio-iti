package br.com.desafio.iti.regra.impl;

import br.com.desafio.iti.regra.Regra;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class RegraCaracterEspecialImpl implements Regra {

    private final String CARACTER_ESPECIAL_VALIDO = "!|@|#|$|%|^|&|\\*|(|)|\\-|\\+";

    @Override
    public boolean validarRegra(String senha) {

        log.info("Verifica se a senha tem caracteres especiais validos");

        final String existeCaracterEspecial = "^(?=.*[" + CARACTER_ESPECIAL_VALIDO + "]).*$";

        if (caracterInvalido(senha)) {
            log.info("A senha possui um caractere especial inválido.");
            return false;
        }
        return senha.matches(existeCaracterEspecial);
    }

    private boolean caracterInvalido(String senha) {

        final String caracterEspecialInvalido = "(?=[\\p{P}\\p{S}])(?![" + CARACTER_ESPECIAL_VALIDO + "])[\\w\\p{P}\\p{S}]";
        Pattern pattern = Pattern.compile(caracterEspecialInvalido);
        Matcher matcher = pattern.matcher(senha);
        return matcher.find();
    }
}
