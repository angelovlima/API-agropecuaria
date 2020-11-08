package br.com.fatec.agropecuaria.services;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;

public class Relatorios {

	Calculador calculador = new Calculador();
	public void quantidadeTotalAnimaisCadastrados(List<Bovino> bovinos, List<Suino> suinos) {
		System.out.println("Quantidade total de animais cadastrados:" + calculador.calcularTotalAnimais(bovinos, suinos));
	}
	
	public void precoDoRebanho() {
		System.out.println("Preco total rebanho");
	}
	
	public void pesoDoRebanhoQuiloArroba(List<Bovino> bovinos, List<Suino> suinos) {
		System.out.println("Peso total quilo:" + calculador.calcularPesoQuilo(bovinos, suinos));
		System.out.println("Peso total arroba:" + calculador.calcularPesoArroba(bovinos, suinos));
	}
	
	public void quantidadeFemeaMacho(List<Bovino> bovinos, List<Suino> suinos) {
		System.out.println("Quantidade Femeas:" +calculador.calcularFemea(bovinos, suinos));
		System.out.println("Quantidade Machos:" + calculador.calcularMacho(bovinos, suinos));
	}
	
	public void dadosVacina(List<Bovino> bovinos, List<Suino> suinos) {
		System.out.println("Porcentagem do rebanho vacinada: "+calculador.calcularPorcentagem(bovinos, suinos));
		System.out.println("Quantos faltam vacinar: "+calculador.faltamVacinar(bovinos, suinos));
	}
	
	
}
