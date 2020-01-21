package br.com.formula.bancaria.api.dto.modulo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.pergunta.PerguntaDTO;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class DetalheModuloDTO {

    private String titulo;
    private List<PerguntaDTO> perguntas;

    public DetalheModuloDTO(Modulo modulo){
        this.titulo = modulo.getTitulo();
        this.perguntas.addAll(modulo.getPerguntas().stream().map(PerguntaDTO::new).collect(Collectors.toList()));
    }
    
    public String getTitulo() {
        return titulo;
    }

    public List<PerguntaDTO> getPerguntas() {
        Collections.shuffle(perguntas);
        return perguntas;
    }
    
}