package br.com.formula.bancaria.api.form.modulo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateModuloForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private Long percetual;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPercetual(Long percetual) {
        this.percetual = percetual;
    }
}