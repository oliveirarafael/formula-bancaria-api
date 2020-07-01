package br.com.formula.bancaria.api.config.validacao.exception;

public class ConflictException extends RuntimeException{

    /**
     * Versionador de objeto. Utilizado para serializações
     */
    private static final long serialVersionUID = 1303426879914266545L;

    public ConflictException(String message) {
        super(message);
    }

}