package br.com.formula.bancaria.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.entity.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long>{
    Optional<Questao> findByUuid(UUID uuid);
}
