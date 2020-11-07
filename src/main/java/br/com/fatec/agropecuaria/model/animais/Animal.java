package br.com.fatec.agropecuaria.model.animais;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Animal {

	private Double id;
	private String registroUnico;
	private Double peso;
	private String raca;
	private String genero;
	private String dataNascimento;

}
