package br.com.fatec.agropecuaria.model.animais;

import java.util.List;

import br.com.fatec.agropecuaria.model.vacina.Vacina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Animal {

	private String registroUnico;
	private Double peso;
	private String raca;
	private String genero;
	private String dataNascimento;
	private List<Vacina> vacinas;
	private String tipo;

}
