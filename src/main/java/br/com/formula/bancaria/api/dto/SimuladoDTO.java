package br.com.formula.bancaria.api.dto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoDTO {

    private String uuid;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHoraCriacao;

    public SimuladoDTO(Simulado simulado){
       this.uuid = simulado.getUuid().toString();
       this.titulo = simulado.getTitulo();
       this.descricao = simulado.getDescricao();
       this.dataHoraCriacao = simulado.getDataHoraCriacao();
    }

	public String getUuid() {
		return uuid;
	}

	public String getTitulo() {
		return titulo;
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