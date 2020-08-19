package br.com.formula.bancaria.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;

import br.com.formula.bancaria.api.model.entity.SimuladoRespondido;

public interface SimuladoRespondidoRepository extends JpaRepository<SimuladoRespondido, Long> {
    Optional<SimuladoRespondido> findByUuid(UUID uuid);
    List<SimuladoRespondido> findByUsuarioId(Long idUsuario);
    List<SimuladoRespondido> findBySimuladoId(Long idSimulado);
    List<SimuladoRespondido> findBySimuladoIdAndUsuarioId(Long idSimulado, Long idUsuario);

    // List<Todo> searchResults = repository.findAll(searchSpec);
}