package br.com.formula.bancaria.api.dto.base;

import java.util.UUID;

public class SimpleViewModelDTO {
    private Long id;
    private UUID uuid;
    private String descricao;

    public SimpleViewModelDTO(Long id, UUID uuid, String descricao)
    {
        this.id = id;
        this.uuid = uuid;
        this.descricao = descricao;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }
}