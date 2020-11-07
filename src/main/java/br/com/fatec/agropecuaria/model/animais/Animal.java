package br.com.fatec.agropecuaria.model.animais;

import br.com.fatec.agropecuario.model.vacina.Carterinha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Animal {

	private String registroUnico;
	private Double peso;
	private String raca;
	private String genero;
	private String dataNascimento;
	private Carterinha carterinha;

}
