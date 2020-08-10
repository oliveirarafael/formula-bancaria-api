package br.com.formula.bancaria.api.dto.modulo;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.model.entity.Modulo;

public class ModuloDTO{

    private String uuid;
    private Integer quantidadeQuestoesPorSimulado;
    private LocalDateTime dataHoraCriacao;

    public ModuloDTO(Modulo modulo){
        this.uuid = modulo.getUuid().toString();
        this.quantidadeQuestoesPorSimulado = modulo.getQuantidadeQuestoesPorSimulado();
        this.dataHoraCriacao = modulo.getDataHoraCriacao();
    }

	public String getUuid() {
		return uuid;
    }
    
	public Integer getQuantidadeQuestoesPorSimulado() {
		return quantidadeQuestoesPorSimulado;
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