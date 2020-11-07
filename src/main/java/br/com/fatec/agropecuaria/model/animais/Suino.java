package br.com.fatec.agropecuaria.model.animais;


import br.com.fatec.agropecuario.model.vacina.Carterinha;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suino extends Animal{
	
	public Suino(String registroUnico, Double peso, String raca, String genero, String dataNascimento, Carterinha carterinha) {
		super(registroUnico, peso, raca, genero, dataNascimento, carterinha);
		
	}
	
	

}
