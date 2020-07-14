package br.com.formula.bancaria.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.formula.bancaria.api.dto.usuario.UsuarioDTO;
import br.com.formula.bancaria.api.form.usuario.CreateUsuarioForm;
import br.com.formula.bancaria.api.model.entity.Perfil;
import br.com.formula.bancaria.api.model.entity.Usuario;
import br.com.formula.bancaria.api.repository.PerfilRepository;
import br.com.formula.bancaria.api.repository.UsuarioRepository;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;


    @GetMapping
    public Page<UsuarioDTO> get(@PageableDefault(sort = "dataHoraCriacao", 
                                                  direction = Direction.DESC, 
                                                  page = 0, size = 10) final Pageable paginacao) {

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
    @RequestMapping(value = "/lembrarSenha", method = { RequestMethod.POST })
    public ResponseEntity<String> lembrarSenha(@RequestBody @Valid final String email,
        final UriComponentsBuilder uriBuilder) {
        final Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email); // Perfil Aluno

        if(optionalUsuario.get() == null) {
            return ResponseEntity.ok().body("Email enviado");
        }

        Usuario usuario = optionalUsuario.get();
        String novaSenha = generateTempooraryPassword(6);
        usuario.setSenha(new BCryptPasswordEncoder().encode(novaSenha));
        Usuario usuarioAlterado = usuarioRepository.save(usuario);
        Email from = new Email("keepee@saobentoservicos.com.br");
        String subject = "Fórmula Bancária - Solicitação de senha";
        Email to = new Email(usuario.getEmail());
        Content content = new Content("text/html", "Sua senha: " + novaSenha);
        Mail mail = new Mail(from, subject, to, content);

        final SendGrid sendgrid = new SendGrid("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");
        
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendgrid.api(request);

            if(response.getStatusCode() == 200) {
                return ResponseEntity.ok().body("E-mail enviado");
            }
        } catch (IOException ex) {
            
        }

        return ResponseEntity.ok().body("E-mail enviado");
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

    static String generateTempooraryPassword(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
}