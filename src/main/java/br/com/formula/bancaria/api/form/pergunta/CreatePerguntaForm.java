package br.com.formula.bancaria.api.form.pergunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.formula.bancaria.api.form.comentario.CreateComentarioForm;
import br.com.formula.bancaria.api.form.resposta.CreateRespostaForm;
import br.com.formula.bancaria.api.model.entity.Modulo;
import br.com.formula.bancaria.api.model.entity.Pergunta;
import br.com.formula.bancaria.api.model.entity.Resposta;
import br.com.formula.bancaria.api.repository.ModuloRepository;

public class CreatePerguntaForm {

    @NotNull @NotEmpty
    private String moduloUUID;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private CreateComentarioForm comentario; 
    @Valid
    private List<CreateRespostaForm> respostasForm;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComentario(CreateComentarioForm comentario) {
        this.comentario = comentario;
    }

    public void setRespostas(List<CreateRespostaForm> respostas) {
        this.respostasForm = respostas;
    }

	public Pergunta converte(ModuloRepository moduloRepository) {
        Optional<Modulo> moduloConsultado = moduloRepository.findByUuid(this.moduloUUID);
        List<Resposta> respostas = new ArrayList();
        this.respostasForm.stream().map(respostaForm -> respostas.add(respostaForm.converte()));
        
        if(moduloConsultado.isPresent()){
           return new Pergunta(this.descricao, respostas, Arrays.asList(moduloConsultado.get()), comentario.converte());
        }

		return (Pergunta) Optional.empty().get();
	}
}