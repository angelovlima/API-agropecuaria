package br.com.fatec.agropecuario.model.vacina;

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
	
	public void setVacinadoTeste(boolean vacinado) {
		this.vacinado = vacinado;
	}
	public boolean getVacinado() {
		return this.vacinado;
	}
}
