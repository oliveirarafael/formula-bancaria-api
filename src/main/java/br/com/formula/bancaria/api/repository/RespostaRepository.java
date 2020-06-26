package br.com.formula.bancaria.api.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.formula.bancaria.api.model.entity.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    Optional<Resposta> findByUuid(UUID uuid);
    List<Resposta> findAllByUuid(Iterator<UUID> uuids);
}