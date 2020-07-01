package br.com.formula.bancaria.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.formula.bancaria.api.model.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findById(Long id);
}