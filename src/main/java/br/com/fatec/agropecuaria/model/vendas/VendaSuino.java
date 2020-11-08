package br.com.fatec.agropecuaria.model.vendas;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Suino;

public class VendaSuino extends Venda {

	List<Suino> suinos;
	public VendaSuino(String dataVenda, Double valorTotal) {
		super(dataVenda, valorTotal);
		
	}
}
