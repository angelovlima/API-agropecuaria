package br.com.fatec.agropecuaria.model.animais;


import java.util.List;

import br.com.fatec.agropecuaria.model.vacina.Vacina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suino extends Animal{
	
	public Suino(String registroUnico, Double peso, String raca, String genero, String dataNascimento, List<Vacina> vacinas) {
		super(registroUnico, peso, raca, genero, dataNascimento, vacinas);
		
	}
	
	

}
