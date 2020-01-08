package br.com.formula.bancaria.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.formula.bancaria.api.dto.ModuloDTO;
import br.com.formula.bancaria.api.repository.ModuloRepository;

@RestController
@RequestMapping("/api/v1/modulos")
public class ModulosController {

    @Autowired
    private ModuloRepository moduloRepository;

    @GetMapping
    @Cacheable("modulos")
    public ResponseEntity<ModuloDTO> get(@PageableDefault(sort = "percentual", 
                                                          direction = Direction.ASC, 
                                                          page = 0, size = 10) Pageable paginacao){



		return null;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ModuloDTO> getUUID(@PathVariable String uuid){
        return null;
    }
    
}