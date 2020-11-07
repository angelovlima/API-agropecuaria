package br.com.fatec.agropecuario.model.vacina;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carterinha {
		private ArrayList<Vacina> carterinha;

		public Carterinha(ArrayList<Vacina> carterinha) {
			super();
			this.carterinha = carterinha;
		}
		
	
		
}
