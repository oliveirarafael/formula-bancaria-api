package br.com.formula.bancaria.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.formula.bancaria.api.model.entity.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long>{
    Optional<Modulo> findByUuid(UUID uuid);
}