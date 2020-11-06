package br.com.fatec.agropecuaria.model.boizinho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boizinho {

	private String nome;
	
	private Double peso;
	
	private Boolean tomouVacina;
}
