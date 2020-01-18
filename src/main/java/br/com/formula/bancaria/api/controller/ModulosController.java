package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
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

import br.com.formula.bancaria.api.dto.modulo.DetalheModuloDTO;
import br.com.formula.bancaria.api.dto.modulo.ModuloDTO;
import br.com.formula.bancaria.api.form.modulo.CreateModuloForm;
import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.repository.ModuloRepository;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

@RestController
@RequestMapping("/modulos")
public class ModulosController {

    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
	private SimuladoRepository simuladoRepository;

    @GetMapping
    @Cacheable(value = "modulos")
    public Page<ModuloDTO> get(@PageableDefault(sort = "percentual", 
                                                direction = Direction.ASC, 
                                                page = 0, size = 10) Pageable paginacao){

		return ModuloDTO.converte(moduloRepository.findAll(paginacao));
    }

    @GetMapping("/{uuid}")
    @Cacheable(value = "modulosUUID")
    public ResponseEntity<ModuloDTO> getUUID(@PathVariable String uuid){
        Optional<Modulo> optional = moduloRepository.findByUuid(uuid);

        if(optional.isPresent()){
            return ResponseEntity.ok(new ModuloDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{uuid}/perguntas")
    @Cacheable(value = "modulosPerguntas")
    public ResponseEntity<DetalheModuloDTO> getPerguntas(@PathVariable String uuid){
        Optional<Modulo> optional = moduloRepository.findByUuid(uuid);

        if(optional.isPresent()){
            return ResponseEntity.ok(new DetalheModuloDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CacheEvict(value = {"modulos", "modulosUUID", "modulosPerguntas"}, allEntries = true)
    @Transactional
    public ResponseEntity postModulos(@RequestBody @Valid CreateModuloForm moduloFom, UriComponentsBuilder uriBuilder){
        Modulo moduloCadastrado = moduloRepository.save(moduloFom.converte(simuladoRepository));
        URI uri = uriBuilder.path("/{uuid}").buildAndExpand(moduloCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new ModuloDTO(moduloCadastrado));
    }
    
}