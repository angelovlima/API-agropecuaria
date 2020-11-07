package br.com.fatec.agropecuaria.model.animais;

import br.com.fatec.agropecuario.model.vacina.Carterinha;

public class Bovino extends Animal{
	
	public Bovino(Double id, String registroUnico, Double peso, String raca,String genero, String dataNascimento, Carterinha carterinha) {
		super(id, registroUnico, peso, raca, genero, dataNascimento, carterinha);
		
	}

}
