package br.com.formula.bancaria.api.service.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.formula.bancaria.api.model.Usuario;
import br.com.formula.bancaria.api.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{

    private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(username);

        if(usuario.isPresent()){
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados invalidos!"); 
	}

}