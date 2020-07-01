package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.dto.simuladoRespondido.SimuladoRespondidoDTO;
import br.com.formula.bancaria.api.form.questaoRespondida.CreateQuestaoRespondidaForm;
import br.com.formula.bancaria.api.form.simuladoRespondido.CreateSimuladoRespondidoForm;
import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.model.entity.QuestaoRespondida;
import br.com.formula.bancaria.api.model.entity.Resposta;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.model.entity.SimuladoRespondido;
import br.com.formula.bancaria.api.model.entity.Usuario;
import br.com.formula.bancaria.api.repository.QuestaoRepository;
// import br.com.formula.bancaria.api.repository.QuestaoRespondidaRepository;
import br.com.formula.bancaria.api.repository.RespostaRepository;
import br.com.formula.bancaria.api.repository.SimuladoRepository;
import br.com.formula.bancaria.api.repository.SimuladoRespondidoRepository;
import br.com.formula.bancaria.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/simuladosRespondidos")
public class SimuladoRespondidoController {
    @Autowired
    private SimuladoRespondidoRepository simuladoRespondidoRepository;
    @Autowired
    private SimuladoRepository simuladoRepository;
    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    // @Autowired
    // private QuestaoRespondidaRepository questaoRespondidaRepository;

    @GetMapping
    public Page<SimuladoRespondidoDTO> get(@PageableDefault(sort = "dataHoraCriacao", 
                                                  direction = Direction.DESC, 
                                                  page = 0, size = 10) Pageable paginacao){
                                                      
        return SimuladoRespondidoDTO.converte(simuladoRespondidoRepository.findAll(paginacao));
    }

    // @GetMapping("/usuarios/{uuid}")
    // public Page<SimuladoRespondidoDTO> getSimuladosPorUsuario(@PageableDefault(sort = "dataHoraCriacao", 
    //         direction = Direction.DESC,
    //         page = 0, size = 10) Pageable paginacao, UUID uuid){
    //     List<SimuladoRespondido> listaSimulados = simuladoRespondidoRepository.findAll();
    //     List<SimuladoRespondido> listaFiltrada = new ArrayList<>();
    //     for (SimuladoRespondido simulado : listaSimulados) {
    //         if(simulado.getUsuario().getUuid() == uuid)
    //         {
    //             listaFiltrada.add(simulado);
    //         }
    //     }
        
    //     return SimuladoRespondidoDTO.converte(new PageImpl<SimuladoRespondido>(listaFiltrada));
    // }
    @GetMapping("/usuarios/{id}")
    public Page<SimuladoRespondidoDTO> getSimuladosPorUsuario(@PageableDefault(sort = "dataHoraCriacao", 
            direction = Direction.DESC,
            page = 0, size = 10) Pageable paginacao, Long id){
        List<SimuladoRespondido> listaSimulados = simuladoRespondidoRepository.findAll();
        List<SimuladoRespondido> listaFiltrada = new ArrayList<>();
        for (SimuladoRespondido simulado : listaSimulados) {
            if(simulado.getUsuario().getId() == id)
            {
                listaFiltrada.add(simulado);
            }
        }
        
        return SimuladoRespondidoDTO.converte(new PageImpl<SimuladoRespondido>(listaFiltrada));
    }

    // @GetMapping("/{uuid}")
    // public ResponseEntity<SimuladoRespondidoDTO> getUUID(@PathVariable UUID uuid){
    //   Optional<SimuladoRespondido> optional = simuladoRespondidoRepository.findByUuid(uuid);

    //   if(optional.isPresent()){
    //     return ResponseEntity.ok(new SimuladoRespondidoDTO(optional.get()));
    //   }
    //   return ResponseEntity.notFound().build();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<SimuladoRespondidoDTO> getId(@PathVariable Long id){
      Optional<SimuladoRespondido> optional = simuladoRespondidoRepository.findById(id);

      if(optional.isPresent()){
        return ResponseEntity.ok(new SimuladoRespondidoDTO(optional.get()));
      }
      return ResponseEntity.notFound().build();
    }

    // @PostMapping
    // @Transactional
    // public ResponseEntity<SimuladoRespondidoDTO> post(@RequestBody @Valid CreateSimuladoRespondidoForm simuladoRespondidoForm, UriComponentsBuilder uriBuilder){
    //     Simulado simulado = simuladoRepository.findByUuid(simuladoRespondidoForm.getSimuladoUuid()).get();
    //     Usuario usuario = usuarioRepository.findByUuid(simuladoRespondidoForm.getUsuarioUuid()).get();

    //     SimuladoRespondido simuladoRespondido = simuladoRespondidoRepository.save(simuladoRespondidoForm.converte(simulado, usuario));
        
    //     // Obtém os ids das questões
    //     List<UUID> questaoIds = new ArrayList<>();
    //     for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
    //         questaoIds.add(questaoRespondida.getQuestaoUuid());
    //     }
        
    //     // Busca as questões por ids (Busca única para evitar sobrecarga no banco)
    //     List<Questao> questoes = questaoRepository.findAllByUuid(questaoIds.iterator());

    //     // Obtém os ids das respostas
    //     List<UUID> respostaIds = new ArrayList<>();
    //     for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
    //         respostaIds.add(questaoRespondida.getRespostaEscolhidaUuid());
    //     }
        
    //     // Busca as respostas por ids (Busca única para evitar sobrecarga no banco)
    //     List<Resposta> respostas = respostaRepository.findAllByUuid(respostaIds.iterator());

    //     // Objeto que armazena todas as respostas respondidas do simulado respondido
    //     List<QuestaoRespondida> questoesRespondidas = new ArrayList<QuestaoRespondida>();
    //     for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
    //         Questao questao = questoes.stream().filter(q -> q.getUuid().equals(questaoRespondida.getQuestaoUuid())).findFirst().get();
    //         Resposta resposta = respostas.stream().filter(q -> q.getUuid().equals(questaoRespondida.getRespostaEscolhidaUuid())).findFirst().get();
            
    //         questoesRespondidas.add(new QuestaoRespondida(questao, resposta));
    //     }

    //     simuladoRespondido.setQuestoes(questoesRespondidas);

    //     // Salva simulado respondido no banco
    //     simuladoRespondidoRepository.save(simuladoRespondido);

    //     URI uri = uriBuilder.path("/simuladosRespondidos/{uuid}").buildAndExpand(simuladoRespondido.getUuid()).toUri();
    //     return ResponseEntity.created(uri).body(new SimuladoRespondidoDTO(simuladoRespondido));
    // }

    @PostMapping
    @Transactional
    public ResponseEntity<SimuladoRespondidoDTO> post(@RequestBody @Valid CreateSimuladoRespondidoForm simuladoRespondidoForm, UriComponentsBuilder uriBuilder){
        Simulado simulado = simuladoRepository.findById(simuladoRespondidoForm.getSimuladoId()).get();
        Usuario usuario = usuarioRepository.findById(simuladoRespondidoForm.getUsuarioId()).get();

        SimuladoRespondido simuladoRespondidoParaCadastrar = simuladoRespondidoForm.converte(simulado, usuario);
        // SimuladoRespondido simuladoRespondidoCadastrado = simuladoRespondidoRepository.save(simuladoRespondidoParaCadastrar);
        
        // Obtém os ids das questões
        List<Long> questaoIds = new ArrayList<>();
        for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
            questaoIds.add(questaoRespondida.getQuestaoId());
        }
        
        // Busca as questões por ids (Busca única para evitar sobrecarga no banco)
        List<Questao> questoes = questaoRepository.findAllById(questaoIds);

        // Obtém os ids das respostas
        List<Long> respostaIds = new ArrayList<>();
        for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
            respostaIds.add(questaoRespondida.getRespostaEscolhidaId());
        }
        
        // Busca as respostas por ids (Busca única para evitar sobrecarga no banco)
        List<Resposta> respostas = respostaRepository.findAllById(respostaIds);

        // Objeto que armazena todas as respostas respondidas do simulado respondido
        List<QuestaoRespondida> questoesRespondidas = new ArrayList<QuestaoRespondida>();
        for (CreateQuestaoRespondidaForm questaoRespondida : simuladoRespondidoForm.geQuestoes()) {
            Questao questao = questoes.stream().filter(q -> q.getId().equals(questaoRespondida.getQuestaoId())).findFirst().get();
            Resposta resposta = respostas.stream().filter(q -> q.getId().equals(questaoRespondida.getRespostaEscolhidaId())).findFirst().get();
            
            questoesRespondidas.add(new QuestaoRespondida(simuladoRespondidoParaCadastrar, questao, resposta));
        }

        simuladoRespondidoParaCadastrar.setQuestoes(questoesRespondidas);

        // Salva simulado respondido no banco
        SimuladoRespondido simuladoRespondidoCadastrado = simuladoRespondidoRepository.save(simuladoRespondidoParaCadastrar);
        // questaoRespondidaRepository.saveAll(questoesRespondidas);

        URI uri = uriBuilder.path("/simuladosRespondidos/{uuid}").buildAndExpand(simuladoRespondidoCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new SimuladoRespondidoDTO(simuladoRespondidoCadastrado));
    }
}