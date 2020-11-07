package br.com.fatec.agropecuaria.model.animais;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suino extends Animal{
	
	public Suino(Double id, String registroUnico, Double peso, String raca, String genero, String dataNascimento) {
		super(id, registroUnico, peso, raca, genero, dataNascimento);
		
	}
	
	

}
