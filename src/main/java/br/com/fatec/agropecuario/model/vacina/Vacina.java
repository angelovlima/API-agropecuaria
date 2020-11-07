package br.com.fatec.agropecuario.model.vacina;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vacina {
	private String vacina;
	private boolean vacinado;
	private String agendamento;
	
	public Vacina(String vacina, boolean vacinado, String agendamento) {
		super();
		this.vacina = vacina;
		this.vacinado = vacinado;
		this.agendamento = agendamento;
	}
}
