package br.com.formula.bancaria.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.entity.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Long> {
    Optional<Simulado> findByUuid(String UUID);
    
}