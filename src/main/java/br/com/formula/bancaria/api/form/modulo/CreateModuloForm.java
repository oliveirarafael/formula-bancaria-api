package br.com.formula.bancaria.api.form.modulo;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

public class CreateModuloForm {

    // @NotNull @NotEmpty
    // private String simuladoUUID;
    @NotNull
    private Long simuladoId;
    @NotNull
    private Integer percentual;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String descricao;

    // public void setSimuladoUUID(String simuladoUUID) {
    //     this.simuladoUUID = simuladoUUID;
    // }
    public void setSimuladoId(Long simuladoId) {
        this.simuladoId = simuladoId;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Modulo converte(SimuladoRepository simuladoRepository) {
        // Optional<Simulado> simulado = simuladoRepository.findByUuid(UUID.fromString(simuladoUUID));
        Optional<Simulado> simulado = simuladoRepository.findById(simuladoId);

        if(simulado.isPresent()){
            return new Modulo(this.nome, this.descricao, this.percentual, simulado.get());
        }
        
		return (Modulo) Optional.empty().get();
	}
}