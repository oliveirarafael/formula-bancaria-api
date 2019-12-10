package br.com.formula.bancaria.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.model.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

    @Autowired
    private SimuladoRepository simuladoRepository;

    
    @GetMapping
    public void get(){

    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid Simulado simulado, UriComponentsBuilder uriBuilder){
        simuladoRepository.save(simulado);
        URI uri = uriBuilder.path("/simulados/{uuid}").buildAndExpand(simulado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(simulado);
    }

    @PutMapping
    public void put(){

    }

    @DeleteMapping
    public void delete(){

    }


}