package br.com.formula.bancaria.api.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

//@Entity
public class Modulo {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;
    private String titulo;
    private Long percentual;
    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    //@ManyToOne
    private Simulado simulado;
    private Collection<Pergunta> perguntas;
}