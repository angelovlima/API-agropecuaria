package br.com.fatec.agropecuaria.model.vacina;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vacina {
	private String vacina;
	private boolean vacinado;
	private String agendamento;
	
	public Vacina(String vacina) {
		super();
		this.vacina = vacina;
	}
	
}
