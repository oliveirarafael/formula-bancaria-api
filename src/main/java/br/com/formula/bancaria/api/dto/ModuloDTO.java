package br.com.formula.bancaria.api.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.formula.bancaria.api.model.entity.Modulo;

public class ModuloDTO {

    private UUID uuid;
    private String titulo;
    private Long percentual;
    private LocalDateTime dataHoraCriacao;

    public ModuloDTO(Modulo modulo){
        this.uuid = modulo.getUuid();
        this.titulo = modulo.getTitulo();
        this.percentual = modulo.getPercentual();
        this.dataHoraCriacao = modulo.getDataHoraCriacao();
    }

	public UUID getUuid() {
		return uuid;
    }
    
	public String getTitulo() {
		return titulo;
    }
    
	public Long getPercentual() {
		return percentual;
    }
    
    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

}