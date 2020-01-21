package br.com.formula.bancaria.api.form.comentario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Comentario;

public class CreateComentarioForm {

    @NotNull @NotEmpty
    private String descricao;
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Comentario converte(){
        return new Comentario(this.descricao);
    }
}