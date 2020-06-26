package br.com.formula.bancaria.api.form.simuladoRespondido;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.form.questaoRespondida.CreateQuestaoRespondidaForm;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.model.entity.SimuladoRespondido;
import br.com.formula.bancaria.api.model.entity.Usuario;

public class CreateSimuladoRespondidoForm {
    
    @NotNull @NotEmpty
    private UUID simuladoUUID;
    @NotNull @NotEmpty
    private UUID usuarioUUID;
    @NotNull
    private List<CreateQuestaoRespondidaForm> questoes;

    public SimuladoRespondido converte(Simulado simulado, Usuario usuario){
        return new SimuladoRespondido(simulado, usuario);
    }

    public UUID getSimuladoUuid() {
        return simuladoUUID;
    }

    public void setSimuladoUuid(UUID simuladoUUID) {
        this.simuladoUUID = simuladoUUID;
    }

    public UUID getUsuarioUuid() {
        return simuladoUUID;
    }

    public void setUsuarioUuid(UUID simuladoUUID) {
        this.simuladoUUID = simuladoUUID;
    }

    public List<CreateQuestaoRespondidaForm> geQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<CreateQuestaoRespondidaForm> questoes) {
        this.questoes = questoes;
    }
}