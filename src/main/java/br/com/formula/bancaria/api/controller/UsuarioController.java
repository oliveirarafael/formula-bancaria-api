package br.com.formula.bancaria.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.dto.usuario.UsuarioDTO;
import br.com.formula.bancaria.api.form.usuario.CreateUsuarioForm;
import br.com.formula.bancaria.api.model.entity.Perfil;
import br.com.formula.bancaria.api.model.entity.Usuario;
import br.com.formula.bancaria.api.repository.PerfilRepository;
import br.com.formula.bancaria.api.repository.UsuarioRepository;
import br.com.formula.bancaria.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDTO> get(
            @PageableDefault(sort = "dataHoraCriacao", direction = Direction.DESC, page = 0, size = 10) final Pageable paginacao) {

        return UsuarioDTO.converte(usuarioRepository.findAll(paginacao));
    }

    @PostMapping
    @Transactional
    @RequestMapping(value = "/alunos", method = { RequestMethod.POST })
    public ResponseEntity<UsuarioDTO> postAluno(@RequestBody @Valid final CreateUsuarioForm usuarioForm,
            final UriComponentsBuilder uriBuilder) {
        final Optional<Perfil> perfilAluno = perfilRepository.findById((long) 2); // Perfil Aluno

        usuarioForm.setSenha(new BCryptPasswordEncoder().encode(usuarioForm.getSenha()));
        final Usuario usuarioParaCadastrar = usuarioForm.converte();
        usuarioParaCadastrar.addPerfil(perfilAluno.get());
        final Usuario usuarioCadastrado = usuarioRepository.save(usuarioParaCadastrar);
        final URI uri = uriBuilder.path("/usuarios/{uuid}").buildAndExpand(usuarioCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuarioCadastrado));
    }

    @PostMapping
    @Transactional
    @RequestMapping(value = "/professores", method = { RequestMethod.POST })
    public ResponseEntity<UsuarioDTO> postProfessor(@RequestBody @Valid final CreateUsuarioForm usuarioForm,
            final UriComponentsBuilder uriBuilder) {
        final Optional<Perfil> perfilAluno = perfilRepository.findById((long) 1); // Perfil Professor

        usuarioForm.setSenha(new BCryptPasswordEncoder().encode(usuarioForm.getSenha()));
        final Usuario usuarioParaCadastrar = usuarioForm.converte();
        usuarioParaCadastrar.addPerfil(perfilAluno.get());
        final Usuario usuarioCadastrado = usuarioRepository.save(usuarioParaCadastrar);
        final URI uri = uriBuilder.path("/usuarios/{uuid}").buildAndExpand(usuarioCadastrado.getUuid()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuarioCadastrado));
    }

    @PostMapping
    @Transactional
    @RequestMapping(value = "/esqueceu-senha", method = { RequestMethod.POST })
    public ResponseEntity<String> esqueceuSenha(@RequestParam("email") String email) {
        usuarioService.gerarSenhaProvisoria(email);
        return ResponseEntity.ok().body("E-mail enviado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getId(@PathVariable final Long id) {
        final Optional<Usuario> optional = usuarioRepository.findById((long) id);

        if (optional.isPresent()) {
            final UsuarioDTO usuarioDto = new UsuarioDTO(optional.get());

            return ResponseEntity.ok(usuarioDto);
        }
        return ResponseEntity.notFound().build();
    }

}