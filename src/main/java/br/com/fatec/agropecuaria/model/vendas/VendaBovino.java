package br.com.fatec.agropecuaria.model.vendas;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;

public class VendaBovino extends Venda {

	List<Bovino> bovinos;
	public VendaBovino(String dataVenda, Double valorTotal) {
		super(dataVenda, valorTotal);
		
	}
}
