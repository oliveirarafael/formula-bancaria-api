package br.com.formula.bancaria.api.dto.simulado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
// import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.model.entity.Simulado;

public class SimuladoQuestaoDTO {
    private Long id;
    private UUID uuid;
    private String titulo;
    private int quantidadeQuestoesExecucao;
    private List<QuestaoDTO> questoes = new ArrayList<>();

    public SimuladoQuestaoDTO(Simulado simulado) {
        this.setId(simulado.getId());
        this.setUuid(simulado.getUuid());
        this.setTitulo(simulado.getNome());
        this.setQuantidadeQuestoesExecucao(simulado.getQuantidadeQuestaoPorExecucao());
        this.setQuestoes(simulado.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList()));
        this.setQuestoes(getQuestoesSorteadas());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidadeQuestoesExecucao() {
        return quantidadeQuestoesExecucao;
    }

    public void setQuantidadeQuestoesExecucao(int quantidadeQuestoesExecucao) {
        this.quantidadeQuestoesExecucao = quantidadeQuestoesExecucao;
    }

    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoDTO> questoes) {
        this.questoes = questoes;
    }

    private List<QuestaoDTO> getQuestoesSorteadas() {
        Random rand = new Random();
        List<QuestaoDTO> _questoesSorteadas = new ArrayList<>();
        List<Long> listaNumerosSorteados = new ArrayList<>();
     
        for (int i = 1; i <= (questoes.size()); i++) {
            int randomIndex = rand.nextInt(questoes.size());

            while(listaNumerosSorteados.contains((long)randomIndex))
            {
                randomIndex = rand.nextInt(questoes.size());
            }

            QuestaoDTO questaoSorteada = questoes.get(randomIndex);
            listaNumerosSorteados.add((long)randomIndex);

            // Embaralha respostas
            Collections.shuffle(questaoSorteada.getRespostas());

            _questoesSorteadas.add(questaoSorteada);
            // questoes.remove(randomIndex);
        }

        // Embaralha questões sorteadas
        Collections.shuffle(_questoesSorteadas);

        return _questoesSorteadas;
    }
}