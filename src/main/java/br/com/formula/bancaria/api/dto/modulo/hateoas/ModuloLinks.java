package br.com.formula.bancaria.api.dto.modulo.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import br.com.formula.bancaria.api.controller.ModulosController;

public abstract class ModuloLinks extends ResourceSupport {

    protected void add(Object parametro){
        add(links(parametro));
    }
    
    private Link[] links(Object parametro) {
        return new Link[]{
            linkTo(methodOn(ModulosController.class).get(null)).withRel("modulos").withType("GET"),
            linkTo(methodOn(ModulosController.class).post(null, null)).withRel("modulos").withType("POST"),
            linkTo(methodOn(ModulosController.class, parametro).getUUID(null)).withSelfRel().withType("GET"),
            linkTo(methodOn(ModulosController.class, parametro).getQuestoes(null)).withRel("questoes").withType("GET")
        };
	}
}