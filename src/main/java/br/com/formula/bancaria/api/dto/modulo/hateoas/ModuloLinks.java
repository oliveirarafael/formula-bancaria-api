package br.com.formula.bancaria.api.dto.modulo.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.formula.bancaria.api.controller.ModulosController;

public abstract class ModuloLinks extends RepresentationModel {

    protected void add(Object parametro){
        add(links(parametro));
    }
    
    private Link[] links(Object parametro) {
        LinkRelation ofSimulados = LinkRelation.of("modulos");

        return new Link[]{
            linkTo(methodOn(ModulosController.class).get(null)).withRel(ofSimulados).withType("GET"),
            linkTo(methodOn(ModulosController.class).post(null, null)).withRel(ofSimulados).withType("POST"),
            linkTo(methodOn(ModulosController.class, parametro).getUUID(null)).withSelfRel().withType("GET"),
            linkTo(methodOn(ModulosController.class, parametro).getPerguntas(null)).withRel("perguntas").withType("GET")
        };
	}
}