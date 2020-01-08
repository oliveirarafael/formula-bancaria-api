package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String descricao;
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "pergunta")
    private List<Resposta> respostas;

    @ManyToMany(mappedBy = "perguntas")
    private List<Modulo> modulos;
}