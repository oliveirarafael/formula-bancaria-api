package br.com.formula.bancaria.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.entity.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
    Optional<Pergunta> findByUuid(UUID uuid);
}
