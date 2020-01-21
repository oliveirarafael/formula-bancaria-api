package br.com.formula.bancaria.api.dto.modulo;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;

import br.com.formula.bancaria.api.dto.modulo.hateoas.ModuloLinks;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class ModuloDTO extends ModuloLinks {

    private String uuid;
    private String titulo;
    private Long percentual;
    private LocalDateTime dataHoraCriacao;

    public ModuloDTO(Modulo modulo){
        this.uuid = modulo.getUuid().toString();
        this.titulo = modulo.getTitulo();
        this.percentual = modulo.getPercentual();
        this.dataHoraCriacao = modulo.getDataHoraCriacao();
        add(this.uuid);
    }

	public String getUuid() {
		return uuid;
    }
    
	public String getTitulo() {
		return titulo;
    }
    
	public Long getPercentual() {
		return percentual;
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