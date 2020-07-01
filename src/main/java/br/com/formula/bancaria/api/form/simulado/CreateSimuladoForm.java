package br.com.formula.bancaria.api.form.simulado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class CreateSimuladoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String descricao;
    private int quantidadeQuestaoPorExecucao;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
    }

    public void setQuantidadeQuestaoPorExecucao(int quantidadeQuestaoPorExecucao) {
		this.quantidadeQuestaoPorExecucao = quantidadeQuestaoPorExecucao;
    }

    public Simulado converte(){
        return new Simulado(nome, descricao, quantidadeQuestaoPorExecucao);
    }
}
