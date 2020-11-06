package br.com.fatec.agropecuaria.services;

import br.com.fatec.agropecuaria.model.boizinho.Boizinho;

public class BoizinhoService {

	public Boizinho cadastrarBoi(String nome, Double peso, Boolean tomouVacina) {
		Boizinho boizinho = new Boizinho(nome, peso, tomouVacina);
		return boizinho;
	}
}
