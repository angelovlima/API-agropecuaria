package br.com.fatec.agropecuaria.model.vendas;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
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
	private List<Suino> suinos;
	private List<Bovino> bovinos;

	public Venda(String dataVenda, Double valorTotalArroba, List<Suino> suinos) {
		this.dataVenda = dataVenda;
		this.valorTotalArroba = valorTotalArroba;
		
		this.suinos = suinos;
	}
	
	public Venda(String dataVenda, List<Bovino> bovinos, Double valorTotalArroba) {
		this.dataVenda = dataVenda;
		this.valorTotalArroba = valorTotalArroba;
		this.bovinos = bovinos;
	}
	
	public Venda(String dataVenda, Double valorTotalArroba) {
		this.dataVenda = dataVenda;
		this.valorTotalArroba = valorTotalArroba;
	}
	
	public Venda(String dataVenda) {
		this.dataVenda = dataVenda;
		
	}
}
