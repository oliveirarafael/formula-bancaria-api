package br.com.formula.bancaria.api.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;
    private String descricao;
    private Boolean correta;
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @ManyToOne
    private Pergunta pergunta;
}