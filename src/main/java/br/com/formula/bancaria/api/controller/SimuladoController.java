package br.com.formula.bancaria.api.controller;

import java.net.URI;
import java.util.List;

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

import br.com.formula.bancaria.api.dto.SimuladoDTO;
import br.com.formula.bancaria.api.form.simulado.SimuladoFormCreate;
import br.com.formula.bancaria.api.model.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

@RestController
@RequestMapping("/simulados")
public class SimuladoController {

    @Autowired
    private SimuladoRepository simuladoRepository;

    
    @GetMapping
    public List<SimuladoDTO> get(){
        return SimuladoDTO.converte(simuladoRepository.findAll());
    }

    @GetMapping("/{uuid}")
    public SimuladoDTO getUUID(String uuid){
       return null;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid SimuladoFormCreate simuladoFomCreate, UriComponentsBuilder uriBuilder){
        Simulado simuladoCadastrado = simuladoRepository.save(simuladoFomCreate.converte());
        URI uri = uriBuilder.path("/simulados/{uuid}").buildAndExpand(simuladoCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(simuladoCadastrado);
    }

    @PutMapping
    public void put(){

    }

    @DeleteMapping
    public void delete(){

    }


}