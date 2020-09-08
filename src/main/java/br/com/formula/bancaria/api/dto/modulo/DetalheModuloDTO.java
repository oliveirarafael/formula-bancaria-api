package br.com.formula.bancaria.api.dto.modulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import br.com.formula.bancaria.api.dto.questao.QuestaoDTO;
import br.com.formula.bancaria.api.model.entity.Modulo;

public class DetalheModuloDTO {

    private List<QuestaoDTO> questoes;

    public DetalheModuloDTO(Modulo modulo){
        this.questoes = new ArrayList<>();
        this.questoes.addAll(modulo.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList()));
        embaralhaQuestoes();
    }

    public DetalheModuloDTO(Modulo modulo, int quantidadeQuestoes){
        this.questoes = new ArrayList<>();
        List<QuestaoDTO> questoes = modulo.getQuestoes().stream().map(QuestaoDTO::new).collect(Collectors.toList());
        // embaralhaQuestoes();
        Random rand = new Random();
        List<Long> listaNumerosSorteados = new ArrayList<>();
        for (int i = 1; i <= quantidadeQuestoes; i++) {
            int randomIndex = rand.nextInt(questoes.size());

            // Estrutura de repetição para impedir que um mesmo número seja obtido novamente
            while(listaNumerosSorteados.contains((long)randomIndex))
            {
                randomIndex = rand.nextInt(questoes.size());
            }

            // Obtém a questão com base no número randomizado gerado
            QuestaoDTO questaoSorteada = questoes.get(randomIndex);
            listaNumerosSorteados.add((long)randomIndex);

             // Embaralha respostas
            Collections.shuffle(questaoSorteada.getRespostas());

            // Armazena a questão na listagem de questões
            this.questoes.add(questaoSorteada);
        }
    }
    
    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }
    
    private void embaralhaQuestoes(){
        Collections.shuffle(questoes);
    }
    
}