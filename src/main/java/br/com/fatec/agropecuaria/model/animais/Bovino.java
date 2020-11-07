package br.com.fatec.agropecuaria.model.animais;

import java.util.List;

import br.com.fatec.agropecuario.model.vacina.Vacina;

public class Bovino extends Animal{
	
	public Bovino(String registroUnico, Double peso, String raca,String genero, String dataNascimento, List<Vacina> vacinas) {
		super(registroUnico, peso, raca, genero, dataNascimento, vacinas);
		
	}

}
