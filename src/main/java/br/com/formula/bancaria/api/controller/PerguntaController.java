package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.dto.pergunta.PerguntaDTO;
import br.com.formula.bancaria.api.form.pergunta.CreatePerguntaForm;
import br.com.formula.bancaria.api.model.entity.Pergunta;
import br.com.formula.bancaria.api.repository.ModuloRepository;
import br.com.formula.bancaria.api.repository.PerguntaRepository;

@RestController
@RequestMapping("/api/v1/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private ModuloRepository moduloRepository;

    @GetMapping("/{uuid}/cometarios")
    @Cacheable(value = "perguntasComentarios")
    public ResponseEntity<PerguntaDTO> getComentario(@PathVariable String uuid){
        Optional<Pergunta> optional = perguntaRepository.findByUuid(uuid);

        if(optional.isPresent()){
           return ResponseEntity.ok(new PerguntaDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = {"perguntasComentarios"})
    public ResponseEntity<PerguntaDTO> post(@Valid @RequestBody CreatePerguntaForm perguntaForm, UriComponentsBuilder uriBuilder){
        Pergunta perguntaCadastrada = perguntaRepository.save(perguntaForm.converte(moduloRepository));
        URI uri = uriBuilder.path("/{uuid}").buildAndExpand(perguntaCadastrada.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new PerguntaDTO(perguntaCadastrada));
    }
    
}