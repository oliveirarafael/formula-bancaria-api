package br.com.formula.bancaria.api.form.simulado;

import br.com.formula.bancaria.api.model.Simulado;

public class CreateSimuladoForm {

    private String titulo;
    private String descricao;

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

    public Simulado converte(){
        return new Simulado(titulo, descricao);
    }
}
