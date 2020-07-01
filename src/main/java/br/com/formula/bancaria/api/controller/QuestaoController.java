package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
// import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
// import org.springframework.cache.annotation.CacheEvict;
// import org.springframework.cache.annotation.Cacheable;
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
import br.com.formula.bancaria.api.model.entity.Resposta;
// import br.com.formula.bancaria.api.repository.ModuloRepository;
import br.com.formula.bancaria.api.repository.QuestaoRepository;
import br.com.formula.bancaria.api.repository.RespostaRepository;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoRepository questaoRepository;
    // @Autowired
    // private ModuloRepository moduloRepository;
    @Autowired
    private RespostaRepository respostaRepository;

    // @GetMapping("/{uuid}/comentarios")
    // // @Cacheable(value = "perguntasComentarios")
    // public ResponseEntity<QuestaoDTO> getComentario(@PathVariable UUID uuid){
    //     Optional<Questao> optional = perguntaRepository.findByUuid(uuid);

    //     if(optional.isPresent()){
    //        return ResponseEntity.ok(new QuestaoDTO(optional.get()));
    //     }

    //     return ResponseEntity.notFound().build();
    // }

    @PostMapping
    @Transactional
    // @CacheEvict(value = {"perguntasComentarios"})
    public ResponseEntity<QuestaoDTO> post(@Valid @RequestBody CreateQuestaoForm perguntaForm, UriComponentsBuilder uriBuilder){
        Questao questaoParaCadastrar = perguntaForm.converte();
        List<Resposta> respostasParaCadastrar = questaoParaCadastrar.getRespostas();
        Questao questaoCadastrada = questaoRepository.save(questaoParaCadastrar);

        for (Resposta resposta : respostasParaCadastrar) {
            resposta.setQuestao(questaoCadastrada);
        }

        List<Resposta> respostasCadastradas = respostaRepository.saveAll(respostasParaCadastrar);
        questaoCadastrada.setRespostas(respostasCadastradas);
        URI uri = uriBuilder.path("/{uuid}").buildAndExpand(questaoCadastrada.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new QuestaoDTO(questaoCadastrada));
    }

    @GetMapping
    public Page<QuestaoDTO> get(@PageableDefault(sort = "dataHoraCriacao", 
                                                  direction = Direction.DESC, 
                                                  page = 0, size = 10) Pageable paginacao){
                                                      
        return QuestaoDTO.converte(questaoRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestaoDTO> getId(@PathVariable Long id){
      Optional<Questao> optional = questaoRepository.findById((long)id);

      if(optional.isPresent()){
        return ResponseEntity.ok(new QuestaoDTO(optional.get()));
      }
      return ResponseEntity.notFound().build();
    }
    
}