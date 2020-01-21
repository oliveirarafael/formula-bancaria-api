package br.com.formula.bancaria.api.form.modulo;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

public class CreateModuloForm {

    @NotNull @NotEmpty
    private String simuladoUUID;
    @NotNull @NotEmpty
    private String titulo;
    @NotNull
    private Long percentual;

    public void setSimuladoUUID(String simuladoUUID) {
        this.simuladoUUID = simuladoUUID;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

	public Modulo converte(SimuladoRepository simuladoRepository) {
        Optional<Simulado> simulado = simuladoRepository.findByUuid(UUID.fromString(simuladoUUID));

        if(simulado.isPresent()){
            return new Modulo(this.titulo, this.percentual, simulado.get());
        }
        
		return (Modulo) Optional.empty().get();
	}
}