package br.com.fatec.agropecuaria.model.vendas;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Venda {
	private String dataVenda;
	private Double valorTotalArroba;
	private Double valorTotalQuilo;
	private List<Animal> animais;

	public Venda(String dataVenda, Double valorTotalArroba, List<Animal> animais) {
		this.dataVenda = dataVenda;
		this.valorTotalArroba = valorTotalArroba;
		
		this.animais = animais;
	}
	
	public Venda(String dataVenda, Double valorTotalArroba) {
		this.dataVenda = dataVenda;
		this.valorTotalArroba = valorTotalArroba;
	}
	
	public Venda(String dataVenda) {
		this.dataVenda = dataVenda;
		
	}
}
