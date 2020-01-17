package br.com.formula.bancaria.api.dto.simulado;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.RepresentationModel;

import br.com.formula.bancaria.api.controller.SimuladoController;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoDTO extends RepresentationModel<SimuladoDTO>{

    private String uuid;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHoraCriacao;
    
    public SimuladoDTO(Simulado simulado){
       this.uuid = simulado.getUuid().toString();
       this.titulo = simulado.getTitulo();
       this.descricao = simulado.getDescricao();
       this.dataHoraCriacao = simulado.getDataHoraCriacao();
       add(links());
    }

	private Link[] links() {
        LinkRelation ofSimulados = LinkRelation.of("simulados");

        return new Link[]{
            linkTo(methodOn(SimuladoController.class).get(null)).withRel(ofSimulados).withType("GET"),
            linkTo(methodOn(SimuladoController.class).post(null, null)).withRel(ofSimulados).withType("POST"),
            linkTo(methodOn(SimuladoController.class).delete(this.uuid)).withRel(ofSimulados).withType("DELETE"),
            linkTo(methodOn(SimuladoController.class).put(this.uuid, null)).withRel(ofSimulados).withType("PUT"),
            linkTo(methodOn(SimuladoController.class, this.uuid).getUUID(null)).withSelfRel().withType("GET"),
            linkTo(methodOn(SimuladoController.class, this.uuid).getModulos(null)).withRel("modulos").withType("GET")
        };
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