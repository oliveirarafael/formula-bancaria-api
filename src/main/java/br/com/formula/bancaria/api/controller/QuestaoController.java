package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

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

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
import br.com.formula.bancaria.api.form.questao.CreateQuestaoForm;
import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.repository.ModuloRepository;
import br.com.formula.bancaria.api.repository.QuestaoRepository;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoRepository perguntaRepository;
    @Autowired
    private ModuloRepository moduloRepository;

    @GetMapping("/{uuid}/comentarios")
    @Cacheable(value = "perguntasComentarios")
    public ResponseEntity<QuestaoDTO> getComentario(@PathVariable UUID uuid){
        Optional<Questao> optional = perguntaRepository.findByUuid(uuid);

        if(optional.isPresent()){
           return ResponseEntity.ok(new QuestaoDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = {"perguntasComentarios"})
    public ResponseEntity<QuestaoDTO> post(@Valid @RequestBody CreateQuestaoForm perguntaForm, UriComponentsBuilder uriBuilder){
        Questao questaoCadastrada = perguntaRepository.save(perguntaForm.converte(moduloRepository));
        URI uri = uriBuilder.path("/{uuid}").buildAndExpand(questaoCadastrada.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new QuestaoDTO(questaoCadastrada));
    }
    
}