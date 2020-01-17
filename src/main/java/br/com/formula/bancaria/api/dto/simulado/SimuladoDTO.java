package br.com.formula.bancaria.api.dto.simulado;

import java.time.LocalDateTime;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import br.com.formula.bancaria.api.controller.SimuladoController;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoDTO extends RepresentationModel{

    private String uuid;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHoraCriacao;
    
    public SimuladoDTO(Simulado simulado){
       this.uuid = simulado.getUuid().toString();
       this.titulo = simulado.getTitulo();
       this.descricao = simulado.getDescricao();
       this.dataHoraCriacao = simulado.getDataHoraCriacao();
       add(linkTo(methodOn(SimuladoController.class).getUUID(this.uuid)).withSelfRel());
       add(linkTo(methodOn(SimuladoController.class).get(Pageable.unpaged())).withSelfRel());
       add(linkTo(methodOn(SimuladoController.class).getModulos(this.uuid)).withRel("modulos"));
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