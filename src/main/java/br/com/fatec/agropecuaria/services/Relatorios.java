package br.com.fatec.agropecuaria.services;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.model.precos.Arroba;
import br.com.fatec.agropecuaria.model.precos.Quilo;

public class Relatorios {

	Calculador calculador = new Calculador();
	public void quantidadeTotalAnimaisCadastrados(List<Bovino> bovinos, List<Suino> suinos) {
		System.out.println("Quantidade total de animais cadastrados:" + calculador.calcularTotalAnimais(bovinos, suinos));
	}
	
	public void precoDoRebanho(List<Bovino> bovinos, List<Suino> suinos, Arroba precoArroba, Quilo precoQuilo) {
		System.out.println("Preço total do rebanho em quilo: " +
				calculador.calcularPrecoQuilo( bovinos, suinos, precoQuilo));
		System.out.println("Preço total do rebanho em arroba: " + 
				calculador.calcularPrecoArroba(bovinos, suinos, precoArroba));
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
		System.out.println("Porcentagem do rebanho vacinada: "+calculador.calcularPorcentagem(bovinos, suinos)+"%");
		System.out.println("Quantos faltam vacinar: "+calculador.faltamVacinar(bovinos, suinos));
	}
	
	public void registroUnicoBovino(List<Bovino> bovinos) {
		for (Bovino bovino: bovinos) {
			System.out.println(bovino.getRegistroUnico());
		}
	}
	
	public void registroUnicoSuino(List<Suino> suinos) {
		for (Suino suino: suinos) {
			System.out.println(suino.getRegistroUnico());
		}
	}
	
}
