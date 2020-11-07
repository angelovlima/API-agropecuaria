package br.com.fatec.agropecuaria.model.animais;

import br.com.fatec.agropecuario.model.vacina.Carterinha;

public class Bovino extends Animal{
	
	public Bovino(String registroUnico, Double peso, String raca,String genero, String dataNascimento, Carterinha carterinha) {
		super(registroUnico, peso, raca, genero, dataNascimento, carterinha);
		
	}

}
