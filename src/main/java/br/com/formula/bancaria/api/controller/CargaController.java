package br.com.formula.bancaria.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.formula.bancaria.api.service.carga.CargaService;

@RestController
@RequestMapping("/cargas")
public class CargaController {

    @Autowired
    private CargaService carga;

    @GetMapping("/simulados")
    public ResponseEntity simulado(){
       carga.executa();
       return ResponseEntity.ok().build();
    }

}