package br.com.formula.bancaria.api.util;

import java.util.Random;

public class GeradorSenhaUtil {
    
    public static String gerarSenha(){
        Random random = new Random();
        return String.valueOf(random.nextInt(99999999));
    }
}