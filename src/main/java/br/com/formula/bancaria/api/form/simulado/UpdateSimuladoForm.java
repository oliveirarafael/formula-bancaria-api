package br.com.formula.bancaria.api.form.simulado;

import br.com.formula.bancaria.api.model.entity.Simulado;

public class UpdateSimuladoForm {

    private String titulo;
    private String descricao;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

	public Simulado atualizar(Simulado simulado) {
        simulado.setTitulo(this.titulo);
        simulado.setDescricao(this.descricao);
		return simulado;
	}

    
}