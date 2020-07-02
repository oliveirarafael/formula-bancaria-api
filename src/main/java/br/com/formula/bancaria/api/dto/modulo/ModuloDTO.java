package br.com.formula.bancaria.api.dto.modulo;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.dto.modulo.hateoas.ModuloLinks;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class ModuloDTO extends ModuloLinks {

    private String uuid;
    private Long percentual;
    private LocalDateTime dataHoraCriacao;

    public ModuloDTO(Modulo modulo){
        this.uuid = modulo.getUuid().toString();
        this.percentual = modulo.getPercentualRepresentativoSimulado();
        this.dataHoraCriacao = modulo.getDataHoraCriacao();
        add(this.uuid);
    }

	public String getUuid() {
		return uuid;
    }
    
	public Long getPercentual() {
		return percentual;
    }
    
    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

	public static Page<ModuloDTO> converte(Page<Modulo> modulos) {
		if(Optional.ofNullable(modulos).isPresent()){
            return modulos.map(ModuloDTO::new);
         }
         return Page.empty();
	}

}