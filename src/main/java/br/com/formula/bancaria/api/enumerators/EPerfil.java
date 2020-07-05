package br.com.formula.bancaria.api.enumerators;

public enum EPerfil {   
    PROFESSOR(1), ALUNO(2);

    private final int valor;
    EPerfil(int valorOpcao) {
        valor = valorOpcao;
    }

    public int getValor(){
        return valor;
    }
}