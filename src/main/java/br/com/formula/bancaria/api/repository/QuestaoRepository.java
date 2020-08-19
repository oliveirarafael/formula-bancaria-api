package br.com.formula.bancaria.api.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.entity.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long>{
    Optional<Questao> findByUuid(UUID uuid);
    List<Questao> findAllByUuid(Iterator<UUID> uuid);

    Optional<Questao> findById(Long id);
    List<Questao> findAllById(Iterator<Long> ids);
}
