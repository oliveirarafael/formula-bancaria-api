package br.com.formula.bancaria.api.dto.simulado;

import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.modulo.ModuloDTO;
import br.com.formula.bancaria.api.dto.simulado.hateoas.SimuladoLinks;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class DetalheSimuladoDTO extends SimuladoLinks{
    private String titulo;
    private List<ModuloDTO> modulos;

    public DetalheSimuladoDTO(Simulado simulado){
        this.titulo = simulado.getTitulo();
        this.modulos.addAll(simulado.getModulos().stream().map(ModuloDTO::new).collect(Collectors.toList()));
        add(simulado.getUuid());
    }

    public String getTitulo() {
        return titulo;
    }
    
    public List<ModuloDTO> getModulos() {
        return modulos;
    }
}