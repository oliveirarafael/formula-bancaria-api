package br.com.formula.bancaria.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.formula.bancaria.api.dto.pergunta.PerguntaDTO;
import br.com.formula.bancaria.api.model.entity.Pergunta;

@RestController
@RequestMapping("/api/v1/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping("/{uuid}/cometarios")
    @Cacheable(value = "perguntasComentarios")
    public ResponseEntity<PerguntaDTO> getComentario(@PathVariable String uuid){
        Optional<Pergunta> optional = perguntaRepository.findByUuid(uuid);

        if(optional.isPresent()){
           return ResponseEntity.ok(new PerguntaDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }
    
}