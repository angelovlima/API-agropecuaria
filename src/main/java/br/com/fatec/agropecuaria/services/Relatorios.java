package br.com.fatec.agropecuaria.services;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Animal;
import br.com.fatec.agropecuaria.model.precos.Preco;
import br.com.fatec.agropecuaria.model.vendas.Venda;

public class Relatorios {

	Calculador calculador = new Calculador();
	public void quantidadeTotalAnimaisCadastrados(List<Animal> animais) {
		System.out.println("Quantidade total de animais cadastrados:" + calculador.calcularTotalAnimais(animais));
	}
	
	public void precoDoRebanho(List<Animal> animais, Preco precoArroba, Preco precoQuilo) {
		System.out.println("Preço total do rebanho em quilo: " +
				calculador.calcularPrecoQuilo( animais, precoQuilo));
		System.out.println("Preço total do rebanho em arroba: " + 
				calculador.calcularPrecoArroba(animais, precoArroba));
	}
	
	public void pesoDoRebanhoQuiloArroba(List<Animal> animais) {
		System.out.println("Peso total quilo:" + calculador.calcularPesoQuilo(animais));
		System.out.println("Peso total arroba:" + calculador.calcularPesoArroba(animais));
	}
	
	public void quantidadeFemeaMacho(List<Animal> animais) {
		System.out.println("Quantidade Femeas:" +calculador.calcularFemea(animais));
		System.out.println("Quantidade Machos:" + calculador.calcularMacho(animais));
	}
	
	public void dadosVacina(List<Animal> animais) {
		System.out.println("Porcentagem do rebanho vacinada: "+calculador.calcularPorcentagem(animais)+"%");
		System.out.println("Quantos faltam vacinar: "+calculador.faltamVacinar(animais));
	}
	
	public void registroUnicoBovino(List<Animal> bovinos) {
		for (Animal bovino: bovinos) {
			if(bovino.getTipo().equals("bovino")) {
				System.out.println("Registro: "+bovino.getRegistroUnico());
			}
		}
	}
	
	public void registroUnicoSuino(List<Animal> suinos) {
		for (Animal suino: suinos) {
			if(suino.getTipo().equals("suino"))
			System.out.println("Registro: "+suino.getRegistroUnico());
		}
	}
	
	public double precoUnicoBovinoArroba(String identificador, List<Animal> bovinos, Preco precoArroba, double totalPrecoArroba) {
		double bovinoArroba = calculador.calcularPrecoBovinoArroba(identificador, bovinos, precoArroba);
		if(bovinoArroba > 0) {
			System.out.println("Preço do Bovino por Arroba: " + bovinoArroba);
		}else {
			System.out.println("Não exite este animal nos registro");
		}
		
		totalPrecoArroba += bovinoArroba;
		return totalPrecoArroba;
	}
	
	public double precoUnicoBovinoQuilo(String identificador, List<Animal> bovinos, Preco precoQuilo, double totalPrecoQuilo) {
		double bovinoQuilo = calculador.calcularPrecoBovinoQuilo(identificador, bovinos, precoQuilo);
		if(bovinoQuilo > 0) {
			System.out.println("Preço do Bovino por Quilo: " + bovinoQuilo);
		}
		totalPrecoQuilo += bovinoQuilo;
		return totalPrecoQuilo;
	}
	
	public double precoUnicoSuinoArroba(String identificador, List<Animal> suinos, Preco precoArroba, double totalPrecoArroba) {
		double suinoArroba = calculador.calcularPrecoSuinoArroba(identificador, suinos, precoArroba);
		
		if(suinoArroba > 0) {
			System.out.println("Preço do Suíno por Arroba: " + suinoArroba);
		}else {
			System.out.println("Não exite este animal nos registro");
		}	
		totalPrecoArroba += suinoArroba;
		return totalPrecoArroba;
	}
	
	public double precoUnicoSuinoQuilo(String identificador, List<Animal> suinos, Preco precoQuilo, double totalPrecoQuilo) {
		double suinoQuilo = calculador.calcularPrecoSuinoQuilo(identificador, suinos, precoQuilo);
		
		if(suinoQuilo > 0) {
			System.out.println("Preço do Suíno por Quilo: " + suinoQuilo);
		}
		
		totalPrecoQuilo += suinoQuilo;
		return totalPrecoQuilo;
	}
	
	public void precoTotalArroba(double totalPrecoArroba) {
		if(totalPrecoArroba > 0) {
			System.out.println("Preço total em Arroba: " + totalPrecoArroba);
		}
		
	}
	
	public void precoTotalQuilo(double totalPrecoQuilo) {
		if(totalPrecoQuilo > 0) {
			System.out.println("Preço total em Quilo: " + totalPrecoQuilo);
		}
		
	}
	
	public void registroVendas(List<Venda> vendasBoi, List<Venda> vendasPorco, Preco precoArroba, Preco precoQuilo) {
		if(vendasPorco.size() != 0) {
			System.out.println("//////////////////// REGISTRO DE VENDAS DE SUINOS ////////////////////\n\n");
			for (Venda venda : vendasPorco) {
				System.out.println("Data da venda: " + venda.getDataVenda());
				System.out.println("Valor total da venda em Arroba: " + venda.getValorTotalArroba() + "\n");
				System.out.println("Valor total da venda em KG: " + venda.getValorTotalQuilo() + "\n");
				System.out.println("Total de animais vendidos: " + vendasPorco.size() + "\n");
				System.out.println("### Lista de Animais Vendidos ###\n");
				for (Animal suino : venda.getAnimais()) {
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
				for (Animal bovino : venda.getAnimais()) {
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
