package br.com.formula.bancaria.api.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;
    private String titulo;
    private Long percentual;
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @ManyToOne
    private Simulado simulado;

    @ManyToMany(mappedBy = "modulos")
    private List<Pergunta> perguntas;
}