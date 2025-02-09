package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.dto.simulado.DetalheSimuladoDTO;
import br.com.formula.bancaria.api.dto.simulado.SimuladoDTO;
import br.com.formula.bancaria.api.dto.simulado.SimuladoQuestaoDTO;
import br.com.formula.bancaria.api.form.simulado.CreateSimuladoForm;
import br.com.formula.bancaria.api.form.simulado.UpdateSimuladoForm;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

   @Autowired
    private SimuladoRepository simuladoRepository;

    @GetMapping
    public Page<SimuladoDTO> get(@PageableDefault(sort = "dataHoraCriacao", 
                                                  direction = Direction.DESC, 
                                                  page = 0, size = 10) Pageable paginacao){
                                                      
        return SimuladoDTO.converte(simuladoRepository.findAll(paginacao));
    }

   //  @GetMapping("/{uuid}")
   //  public ResponseEntity<SimuladoDTO> getUUID(@PathVariable UUID uuid){
   //    Optional<Simulado> optional = simuladoRepository.findByUuid(uuid);

   //    if(optional.isPresent()){
   //      return ResponseEntity.ok(new SimuladoDTO(optional.get()));
   //    }
   //    return ResponseEntity.notFound().build();
   //  }

   @GetMapping("/{id}")
    public ResponseEntity<SimuladoDTO> getId(@PathVariable Long id){
      Optional<Simulado> optional = simuladoRepository.findById((long)id);

      if(optional.isPresent()){
        return ResponseEntity.ok(new SimuladoDTO(optional.get()));
      }
      return ResponseEntity.notFound().build();
    }

   //  @PutMapping("/{uuid}")
   //  @Transactional
   //  public ResponseEntity<SimuladoDTO> put(@PathVariable UUID uuid, @RequestBody @Valid UpdateSimuladoForm simuladoForm){
   //      Optional<Simulado> optional = simuladoRepository.findByUuid(uuid);
   //      if(optional.isPresent()){
   //         Simulado simulado = simuladoForm.atualizar(optional.get());
   //         return ResponseEntity.ok(new SimuladoDTO(simulado));
   //      }

   //      return ResponseEntity.notFound().build();
   //  }

   @PutMapping("/{id}")
   @Transactional
   public ResponseEntity<SimuladoDTO> put(@PathVariable Long id, @RequestBody @Valid UpdateSimuladoForm simuladoForm){
       Optional<Simulado> optional = simuladoRepository.findById(id);
       if(optional.isPresent()){
          Simulado simulado = simuladoForm.atualizar(optional.get());
          return ResponseEntity.ok(new SimuladoDTO(simulado));
       }

       return ResponseEntity.notFound().build();
   }

   // @DeleteMapping("/{uuid}")
   // @Transactional
   // public ResponseEntity<Object> delete(@PathVariable UUID uuid){
   //    Optional<Simulado> optional = simuladoRepository.findByUuid(uuid);
   //    if(optional.isPresent()){
   //       simuladoRepository.delete(optional.get());
   //       return ResponseEntity.noContent().build();
   //    }
   //    return ResponseEntity.notFound().build();
   // }

   @DeleteMapping("/{id}")
   @Transactional
   public ResponseEntity<Object> delete(@PathVariable Long id){
      Optional<Simulado> optional = simuladoRepository.findById(id);
      if(optional.isPresent()){
         simuladoRepository.delete(optional.get());
         return ResponseEntity.noContent().build();
      }
      return ResponseEntity.notFound().build();
   }

   //  @GetMapping("/{uuid}/modulos")
   //  public ResponseEntity<DetalheSimuladoDTO> getModulos(@PathVariable UUID uuid){
   //     Optional<Simulado> optional = simuladoRepository.findByUuid(uuid);

   //     if(optional.isPresent()){
   //        return ResponseEntity.ok(new DetalheSimuladoDTO(optional.get()));
   //     }
   //     return ResponseEntity.notFound().build();
   //  }
   @GetMapping("/{id}/modulos")
    public ResponseEntity<DetalheSimuladoDTO> getModulos(@PathVariable Long id){
       Optional<Simulado> optional = simuladoRepository.findById(id);

       if(optional.isPresent()){
          return ResponseEntity.ok(new DetalheSimuladoDTO(optional.get()));
       }
       return ResponseEntity.notFound().build();
    }

   //  @GetMapping("/{uuid}/questoes")
   //  public ResponseEntity<DetalheSimuladoDTO> getQuestoes(@PathVariable UUID uuid){
   //     Optional<Simulado> optional = simuladoRepository.findByUuid(uuid);

   //     if(optional.isPresent()){
   //        return ResponseEntity.ok(new DetalheSimuladoDTO(optional.get()));
   //     }
   //     return ResponseEntity.notFound().build();
   //  }

   @GetMapping("/{id}/questoes")
    public ResponseEntity<DetalheSimuladoDTO> getQuestoes(@PathVariable Long id){
       Optional<Simulado> optional = simuladoRepository.findById(id);

       if(optional.isPresent()){
          return ResponseEntity.ok(new DetalheSimuladoDTO(optional.get()));
       }
       return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<SimuladoDTO> post(@RequestBody @Valid CreateSimuladoForm simuladoFom, UriComponentsBuilder uriBuilder){
        Simulado simuladoCadastrado = simuladoRepository.save(simuladoFom.converte());
        URI uri = uriBuilder.path("/simulados/{uuid}").buildAndExpand(simuladoCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new SimuladoDTO(simuladoCadastrado));
    }

    @GetMapping("/{id}/gerar")
    public ResponseEntity<SimuladoQuestaoDTO> gerar(@PathVariable Long id){
       Optional<Simulado> optional = simuladoRepository.findById(id);

       if(optional.isPresent()){
          return ResponseEntity.ok(new SimuladoQuestaoDTO(optional.get()));
       }
       return ResponseEntity.notFound().build();
    }
}