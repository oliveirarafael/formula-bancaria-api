package br.com.formula.bancaria.api.controller;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.entity.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
    Optional<Pergunta> findByUuid(String uuid);
}
