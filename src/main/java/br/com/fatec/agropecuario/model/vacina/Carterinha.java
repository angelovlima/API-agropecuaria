package br.com.fatec.agropecuario.model.vacina;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carterinha {
	private String tipo;
	private ArrayList<Vacina> carterinha;
	
	public Carterinha(String tipo, ArrayList<Vacina> carterinha) {
		super();
		this.tipo = tipo;
		this.carterinha = carterinha;
	}

	
	
		
	
		
}
