package br.com.formula.bancaria.api.dto.modulo;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.model.entity.Modulo;

public class ModuloDTO {

    private Long id;
    private String uuid;
    private Integer quantidadeQuestoesPorSimulado;
    private LocalDateTime dataHoraCriacao;
    private String nome;
    private String descricao;

    public ModuloDTO(Modulo modulo) {
        this.id = modulo.getId();
        this.uuid = modulo.getUuid().toString();
        this.quantidadeQuestoesPorSimulado = modulo.getQuantidadeQuestoesPorSimulado();
        this.dataHoraCriacao = modulo.getDataHoraCriacao();
        this.setNome(modulo.getNome());
        this.setDescricao(modulo.getDescricao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUuid() {
		return uuid;
    }
    
	public Integer getQuantidadeQuestoesPorSimulado() {
		return quantidadeQuestoesPorSimulado;
    }
    
    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

	public static Page<ModuloDTO> converte(Page<Modulo> modulos) {
		if(Optional.ofNullable(modulos).isPresent()){
            return modulos.map(ModuloDTO::new);
         }
         return Page.empty();
	}

}