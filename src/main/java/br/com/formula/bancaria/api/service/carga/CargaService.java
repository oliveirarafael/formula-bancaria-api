package br.com.formula.bancaria.api.service.carga;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Simulado;
import br.com.formula.bancaria.api.repository.SimuladoRepository;

@Service
public class CargaService {

    @Autowired
    private SimuladoRepository simuladoRepository;

    public void executa(){

       List<Modulo> modulosCPA10CEA =  Arrays.asList(
           new Modulo(0, 1),
           new Modulo(0, 2),
           new Modulo(0, 3),
           new Modulo(0, 4),
           new Modulo(0, 5),
           new Modulo(0, 6),
           new Modulo(0, 7)
       );

       List<Modulo> modulosCPA20 =  Arrays.asList(
           new Modulo(0, 1),
           new Modulo(0, 2),
           new Modulo(0, 3),
           new Modulo(0, 4),
           new Modulo(0, 5),
           new Modulo(0, 6)
       );

       List<Modulo> modulosAAI =  Arrays.asList(
           new Modulo(0, 1),
           new Modulo(0, 2),
           new Modulo(0, 3),
           new Modulo(0, 4),
           new Modulo(0, 5),
           new Modulo(0, 6),
           new Modulo(0, 8),
           new Modulo(0, 9),
           new Modulo(0, 10),
           new Modulo(0, 11),
           new Modulo(0, 12),
           new Modulo(0, 13),
           new Modulo(0, 14),
           new Modulo(0, 15)
       );

        Simulado cpa10 = new Simulado("CPA 10");
        Simulado cpa20 = new Simulado("CPA 20");
        Simulado cea = new Simulado("CEA");
        Simulado aai = new Simulado("AAI");

        modulosCPA10CEA.forEach(m -> {
            cpa10.adiciona(m);
            cea.adiciona(m);
        });

        modulosCPA20.forEach(m -> {
            cpa20.adiciona(m);
        });

        modulosAAI.forEach(m -> {
            aai.adiciona(m);
        });

       List<Simulado> simulados = Arrays.asList(cpa10, cpa20, cea, aai);

       simulados.forEach(s -> simuladoRepository.save(s));
    }
}