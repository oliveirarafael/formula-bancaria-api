package br.com.formula.bancaria.api.dto.simulado.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import static java.util.UUID.fromString;

import br.com.formula.bancaria.api.controller.SimuladoController;

public abstract class SimuladoLinks extends ResourceSupport {

    protected void add(Object parametro){
        add(links(parametro));
    }
    
    private Link[] links(Object parametro) {
        return new Link[]{
            linkTo(methodOn(SimuladoController.class).get(null)).withRel("simulados").withType("GET"),
            linkTo(methodOn(SimuladoController.class).post(null, null)).withRel("simulados").withType("POST"),
            linkTo(methodOn(SimuladoController.class).delete(fromString(parametro.toString()))).withRel("simulados").withType("DELETE"),
            linkTo(methodOn(SimuladoController.class).put(fromString(parametro.toString()), null)).withRel("simulados").withType("PUT"),
            linkTo(methodOn(SimuladoController.class, parametro).getUUID(null)).withSelfRel().withType("GET"),
            linkTo(methodOn(SimuladoController.class, parametro).getModulos(null)).withRel("modulos").withType("GET")
        };
    }
    
}