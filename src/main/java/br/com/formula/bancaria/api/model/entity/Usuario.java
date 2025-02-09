package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.formula.bancaria.api.enumerators.EPerfil;

@Entity
public class Usuario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID uuid = UUID.randomUUID();
	private String nome;
	private String email;
	private String senha;
	private Boolean assinante;
	private LocalDateTime dataHoraCriacao = LocalDateTime.now();

	@Version
	private Long versao;

	/**
	 * Versionador do objeto. Usado para serializações
	 */
	private static final long serialVersionUID = -3699430255730586480L;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Usuario() { }
	
	public Usuario(String nome, String email, String senha)
	{
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public Boolean getAssinante() {
		return assinante;
	}

	public void setAssinante(Boolean assinante) {
		this.assinante = assinante;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	public void addPerfil(Perfil perfil)
	{
		if(!this.perfis.contains(perfil))
		{
			this.perfis.add(perfil);
		}
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Boolean possuiPerfil(Perfil perfil)
	{
		if(this.perfis == null) return false;

		if(this.perfis.size() == 0) return false;

		return this.perfis.contains(perfil);
	}

	public Boolean possuiPerfilAluno()
	{
		if(this.perfis == null) return false;

		if(this.perfis.size() == 0) return false;

		Long idPerfilAluno = new Long(EPerfil.ALUNO.getValor());

		Optional<Perfil> optional = this.perfis.stream().filter(q -> q.getId().equals(idPerfilAluno)).findFirst();
		if(optional.isPresent()){
			return (optional.get() != null);
		}

		return false;
	}

	public Boolean possuiPerfilProfessor()
	{
		if(this.perfis == null) return false;

		if(this.perfis.size() == 0) return false;

		Long idPerfilAluno = new Long(EPerfil.PROFESSOR.getValor());

		Optional<Perfil> optional = this.perfis.stream().filter(q -> q.getId().equals(idPerfilAluno)).findFirst();
		if(optional.isPresent()){
			return (optional.get() != null);
		}

		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assinante == null) ? 0 : assinante.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (assinante == null) {
			if (other.assinante != null)
				return false;
		} else if (!assinante.equals(other.assinante))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [assinante=" + assinante + ", email=" + email + ", id=" + id + ", nome=" + nome + ", perfis="
				+ perfis + ", senha=" + senha + "]";
	}

}