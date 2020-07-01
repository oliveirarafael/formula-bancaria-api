package br.com.formula.bancaria.api.dto.simulado;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import br.com.formula.bancaria.api.dto.simulado.hateoas.SimuladoLinks;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoDTO extends SimuladoLinks{

    private UUID uuid;
    private String nome;
    private String descricao;
    private LocalDateTime dataHoraCriacao;
    
    public SimuladoDTO(Simulado simulado){
       this.uuid = simulado.getUuid();
       this.nome = simulado.getNome();
       this.descricao = simulado.getDescricao();
       this.dataHoraCriacao = simulado.getDataHoraCriacao();
       add(this.uuid);
    }

	public UUID getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

    public static Page<SimuladoDTO> converte(Page<Simulado> simulados){
        if(Optional.ofNullable(simulados).isPresent()){
           return simulados.map(SimuladoDTO::new);
        }
        return Page.empty();
    }
}