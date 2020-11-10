package br.com.fatec.agropecuaria.services;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.model.precos.Arroba;
import br.com.fatec.agropecuaria.model.precos.Quilo;
import br.com.fatec.agropecuaria.model.vendas.Venda;

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
			System.out.println("Registro: "+bovino.getRegistroUnico());
		}
	}
	
	public void registroUnicoSuino(List<Suino> suinos) {
		for (Suino suino: suinos) {
			System.out.println("Registro: "+suino.getRegistroUnico());
		}
	}
	
	public double precoUnicoBovinoArroba(String identificador, List<Bovino> bovinos, Arroba precoArroba, double totalPrecoArroba) {
		double bovinoArroba = calculador.calcularPrecoBovinoArroba(identificador, bovinos, precoArroba);
		System.out.println("Preço do Bovino por Arroba: " + bovinoArroba);
		totalPrecoArroba += bovinoArroba;
		return totalPrecoArroba;
	}
	
	public double precoUnicoBovinoQuilo(String identificador, List<Bovino> bovinos, Quilo precoQuilo, double totalPrecoQuilo) {
		double bovinoQuilo = calculador.calcularPrecoBovinoQuilo(identificador, bovinos, precoQuilo);
		System.out.println("Preço do Bovino por Quilo: " + bovinoQuilo);
		totalPrecoQuilo += bovinoQuilo;
		return totalPrecoQuilo;
	}
	
	public double precoUnicoSuinoArroba(String identificador, List<Suino> suinos, Arroba precoArroba, double totalPrecoArroba) {
		double suinoArroba = calculador.calcularPrecoSuinoArroba(identificador, suinos, precoArroba);
		System.out.println("Preço do Suíno por Arroba: " + suinoArroba);
		totalPrecoArroba += suinoArroba;
		return totalPrecoArroba;
	}
	
	public double precoUnicoSuinoQuilo(String identificador, List<Suino> suinos, Quilo precoQuilo, double totalPrecoQuilo) {
		double suinoQuilo = calculador.calcularPrecoSuinoQuilo(identificador, suinos, precoQuilo);
		System.out.println("Preço do Suíno por Quilo: " + suinoQuilo);
		totalPrecoQuilo += suinoQuilo;
		return totalPrecoQuilo;
	}
	
	public void precoTotalArroba(double totalPrecoArroba) {
		System.out.println("Preço total em Arroba: " + totalPrecoArroba);
	}
	
	public void precoTotalQuilo(double totalPrecoQuilo) {
		System.out.println("Preço total em Quilo: " + totalPrecoQuilo);
	}
	
	public void registroVendas(List<Venda> vendasBoi, List<Venda> vendasPorco, Arroba precoArroba, Quilo precoQuilo) {
		if(vendasPorco.size() != 0) {
			System.out.println("//////////////////// REGISTRO DE VENDAS DE SUINOS ////////////////////\n\n");
			for (Venda venda : vendasPorco) {
				System.out.println("Data da venda: " + venda.getDataVenda());
				System.out.println("Valor total da venda em Arroba: " + venda.getValorTotalArroba() + "\n");
				System.out.println("Valor total da venda em KG: " + venda.getValorTotalQuilo() + "\n");
				System.out.println("Total de animais vendidos: " + vendasPorco.size() + "\n");
				System.out.println("### Lista de Animais Vendidos ###\n");
				for (Suino suino : venda.getSuinos()) {
					System.out.println("////////////////////////////////////////\n");
					System.out.println("Registro único: " + suino.getRegistroUnico() + "\n");
					System.out.println("Peso do animal: " + suino.getPeso() + " Arrobas \n");
					System.out.println("Preço do animal em Arroba: " + suino.getPeso() * precoArroba.getPreco() + "\n");
					System.out.println("Preço do animal em KG: " + (suino.getPeso()*15) * precoQuilo.getPreco() + "\n");
					System.out.println("Raça do animal: " + suino.getRaca() + "\n");
					System.out.println("Gênero do animal: " + (suino.getGenero().equals("f") || suino.getGenero().equals("F")? "Feminino": "Masculino") + "\n");
					System.out.println("////////////////////////////////////////\n");
				}
			}
		}
		if(vendasBoi.size() != 0) {
			System.out.println("//////////////////// REGISTRO DE VENDAS DE BOVINOS ////////////////////\n\n");
			for (Venda venda : vendasBoi) {
				System.out.println("Data da venda: " + venda.getDataVenda());
				System.out.println("Valor total da venda: " + venda.getValorTotalArroba() + "\n");
				System.out.println("Valor total da venda em KG: " + venda.getValorTotalQuilo() + "\n");
				System.out.println("Total de animais vendidos: " + vendasBoi.size() + "\n");
				System.out.println("### Lista de Animais Vendidos ###\n");
				for (Bovino bovino : venda.getBovinos()) {
					System.out.println("////////////////////////////////////////\n");
					System.out.println("Registro único: " + bovino.getRegistroUnico() + "\n");
					System.out.println("Peso do animal: " + bovino.getPeso() + " Arrobas \n");
					System.out.println("Preço do animal em Arroba: " + bovino.getPeso() * precoArroba.getPreco() + "\n");
					System.out.println("Preço do animal em KG: " + (bovino.getPeso()*15) * precoQuilo.getPreco() + "\n");
					System.out.println("Raça do animal: " + bovino.getRaca() + "\n");
					System.out.println("Gênero do animal: " + (bovino.getGenero().equals("f") || bovino.getGenero().equals("F")? "Feminino": "Masculino") + "\n");
					System.out.println("////////////////////////////////////////\n");
				}
			}
		}

	}
	
}
