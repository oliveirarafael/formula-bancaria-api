package br.com.formula.bancaria.api.form.questao;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.form.resposta.CreateRespostaForm;
// import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.model.entity.Resposta;
// import br.com.formula.bancaria.api.repository.ModuloRepository;

public class CreateQuestaoForm {

    // @NotNull
    // private UUID moduloUUID;
    // @NotNull
    // private Long moduloId;
    @NotNull @NotEmpty
    private String assunto;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private String comentario; 
    @Valid
    private List<CreateRespostaForm> respostas;

    // public void setModuloUUID(Long moduloId) {
    //     this.moduloId = moduloId;
    // }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setRespostas(List<CreateRespostaForm> respostas) {
        this.respostas = respostas;
    }

	// public Questao converte(ModuloRepository moduloRepository) {
    //     Optional<Modulo> moduloConsultado = moduloRepository.findById(this.moduloId);
    //     List<Resposta> respostas = new ArrayList<>();
    //     this.respostas.stream().map(respostaForm -> respostas.add(respostaForm.converte()));
        
    //     if(moduloConsultado.isPresent()){
    //         // return new Questao(this.assunto, this.descricao, respostas, Arrays.asList(moduloConsultado.get()), comentario);
    //         return new Questao(this.assunto, this.descricao, respostas, comentario);
    //     }

	// 	return (Questao) Optional.empty().get();
    // }
    
    public Questao converte() {
        List<Resposta> respostas = new ArrayList<>();

        for (CreateRespostaForm respostaForm : this.respostas) {
            respostas.add(respostaForm.converte());
        }

        return new Questao(this.assunto, this.descricao, respostas, comentario);
	}
}