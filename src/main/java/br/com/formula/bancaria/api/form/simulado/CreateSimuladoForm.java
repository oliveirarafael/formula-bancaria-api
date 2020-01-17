package br.com.formula.bancaria.api.form.simulado;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.form.modulo.CreateModuloForm;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class CreateSimuladoForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String descricao;
    private List<CreateModuloForm> modulo;

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
