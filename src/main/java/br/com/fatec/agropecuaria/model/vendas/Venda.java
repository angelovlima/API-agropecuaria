package br.com.fatec.agropecuaria.model.vendas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Venda {
	private String dataVenda;
	private Double valorTotal;

}