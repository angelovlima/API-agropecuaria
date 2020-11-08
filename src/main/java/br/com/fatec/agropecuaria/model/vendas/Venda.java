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
	private Double valorTotal;
	private List<Suino> suinos;
	private List<Bovino> bovinos;

	public Venda(String dataVenda, Double valorTotal, List<Suino> suinos) {
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
		this.suinos = suinos;
	}
	
	public Venda(String dataVenda, List<Bovino> bovinos, Double valorTotal) {
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
		this.bovinos = bovinos;
	}
	
	public Venda(String dataVenda, Double valorTotal) {
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}
	
	public Venda(String dataVenda) {
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}
}
