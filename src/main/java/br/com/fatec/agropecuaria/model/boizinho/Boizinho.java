package br.com.fatec.agropecuaria.model.boizinho;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Boizinho {

	private String nome;
	
	private Double peso;
	
	private Boolean tomouVacina;

}
