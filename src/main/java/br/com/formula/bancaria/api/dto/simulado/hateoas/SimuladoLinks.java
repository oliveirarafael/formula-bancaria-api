package br.com.formula.bancaria.api.dto.simulado.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import br.com.formula.bancaria.api.controller.SimuladoController;

public abstract class SimuladoLinks extends RepresentationModel {

    protected void add(Object parametro){
        add(links(parametro));
    }
    
    private Link[] links(Object parametro) {
        LinkRelation ofSimulados = LinkRelation.of("simulados");

        return new Link[]{
            linkTo(methodOn(SimuladoController.class).get(null)).withRel(ofSimulados).withType("GET"),
            linkTo(methodOn(SimuladoController.class).post(null, null)).withRel(ofSimulados).withType("POST"),
            linkTo(methodOn(SimuladoController.class).delete(parametro.toString())).withRel(ofSimulados).withType("DELETE"),
            linkTo(methodOn(SimuladoController.class).put(parametro.toString(), null)).withRel(ofSimulados).withType("PUT"),
            linkTo(methodOn(SimuladoController.class, parametro).getUUID(null)).withSelfRel().withType("GET"),
            linkTo(methodOn(SimuladoController.class, parametro).getModulos(null)).withRel("modulos").withType("GET")
        };
	}
}