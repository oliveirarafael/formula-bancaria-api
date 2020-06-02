package br.com.formula.bancaria.api.form.simulado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Simulado;

public class UpdateSimuladoForm {
	
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
    private String descricao;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

	public Simulado atualizar(Simulado simulado) {
        simulado.setTitulo(this.titulo);
		return simulado;
	}

}