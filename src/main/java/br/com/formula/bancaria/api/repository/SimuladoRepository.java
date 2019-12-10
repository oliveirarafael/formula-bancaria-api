package br.com.formula.bancaria.api.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.formula.bancaria.api.model.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, UUID> {

    
}