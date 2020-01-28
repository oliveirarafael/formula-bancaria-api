package br.com.formula.bancaria.api.form.pergunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.form.comentario.CreateComentarioForm;
import br.com.formula.bancaria.api.form.resposta.CreateRespostaForm;
import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Questao;
import br.com.formula.bancaria.api.model.entity.Resposta;
import br.com.formula.bancaria.api.repository.ModuloRepository;

public class CreateQuestaoForm {

    @NotNull
    private UUID moduloUUID;
    @NotNull @NotEmpty
    private String descricao;
    @Valid
    private CreateComentarioForm comentario; 
    @Valid
    private List<CreateRespostaForm> respostas;

    public void setModuloUUID(UUID moduloUUID) {
        this.moduloUUID = moduloUUID;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComentario(CreateComentarioForm comentario) {
        this.comentario = comentario;
    }

    public void setRespostas(List<CreateRespostaForm> respostas) {
        this.respostas = respostas;
    }

	public Questao converte(ModuloRepository moduloRepository) {
        Optional<Modulo> moduloConsultado = moduloRepository.findByUuid(this.moduloUUID);
        List<Resposta> respostas = new ArrayList();
        this.respostas.stream().map(respostaForm -> respostas.add(respostaForm.converte()));
        
        if(moduloConsultado.isPresent()){
           return new Questao(this.descricao, respostas, Arrays.asList(moduloConsultado.get()), comentario.converte());
        }

		return (Questao) Optional.empty().get();
	}
}