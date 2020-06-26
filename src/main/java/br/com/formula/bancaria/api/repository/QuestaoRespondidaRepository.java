package br.com.formula.bancaria.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.formula.bancaria.api.model.entity.QuestaoRespondida;

public interface QuestaoRespondidaRepository extends JpaRepository<QuestaoRespondida, Long> {
    Optional<QuestaoRespondida> findByUuid(UUID uuid);
    
}