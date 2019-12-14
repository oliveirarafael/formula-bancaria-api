package br.com.formula.bancaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.formula.bancaria.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
}