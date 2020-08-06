package br.com.formula.bancaria.api.dto.simulado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.modulo.ModuloDTO;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class DetalheSimuladoDTO {
    private String nome;
    private List<ModuloDTO> modulos = new ArrayList<>();

    public DetalheSimuladoDTO(Simulado simulado){
        this.nome = simulado.getNome();
        this.modulos.addAll(simulado.getModulos().stream().map(ModuloDTO::new).collect(Collectors.toList()));
    }

    public String getTitulo() {
        return nome;
    }
    
    public List<ModuloDTO> getModulos() {
        return modulos;
    }
}