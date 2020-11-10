package br.com.fatec.agropecuaria.services;

import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Animal;
import br.com.fatec.agropecuaria.model.precos.Preco;
import br.com.fatec.agropecuaria.model.vendas.Venda;


public class Calculador {

	public int calcularTotalAnimais(List<Animal> animais) {
		return (animais.size());
	}
	
	public double calcularPesoArroba(List<Animal> animais) {
		double pesoTotal = 0;
		for (Animal suino : animais) {
			pesoTotal = pesoTotal + suino.getPeso();
		}
		return pesoTotal;
	}
	
	public double calcularPesoQuilo(List<Animal> animais) {
		double pesoTotal = 0;
		for (Animal suino : animais) {
			pesoTotal = pesoTotal + (suino.getPeso()*15);
		}
		return pesoTotal;
	}
	
	public double calcularPrecoArroba(List<Animal> animais, Preco preco) {
		double precoTotal = 0;
		
		for (Animal suino : animais) {
			precoTotal = precoTotal + preco.getPreco() * suino.getPeso();
		}
		return precoTotal;
	}
	
	public double calcularPrecoQuilo(List<Animal> animais, Preco preco) {
		double precoTotal = 0;
		
		for (Animal suino : animais) {
			precoTotal = precoTotal + preco.getPreco() * (suino.getPeso() * 15);
		}
		return precoTotal;
	}
	
	public int calcularFemea(List<Animal> animais) {
		int femeaTotal = 0;
		for (Animal suino : animais) {
			if(suino.getGenero().equals("F") || suino.getGenero().equals("f")) {
				femeaTotal += 1;				
			}
			
		}
		return femeaTotal;
	}
	
	public int calcularMacho(List<Animal> animais) {
		int machoTotal = 0;
		for (Animal suino : animais) {
			if(suino.getGenero().equals("M") || suino.getGenero().equals("m")) {
				machoTotal += 1;				
			}
			
		}
		
		return machoTotal;
	}
	
	public double calcularPorcentagem(List<Animal> animais) {
		double porcentoTotal = 0;
		int contVacina = 0;
		int contAnimal = 0;
		for(Animal suino: animais) {
			for (int i = 0; i < suino.getVacinas().size(); i++)
				if(suino.getVacinas().get(i).isVacinado() == true) {
					contVacina += 1;
				}
			if(contVacina == suino.getVacinas().size()) {
				contAnimal += 1;
				contVacina = 0;
			}else {
				contVacina = 0;
			}
				
				
		}
		
		porcentoTotal = (contAnimal*100)/(animais.size()+animais.size());
		return porcentoTotal;
	}
	
	public int faltamVacinar(List<Animal> animais) {
		int semVacinar = 0;
		int contVacina = 0;
		int contAnimal = 0;
		for(Animal suino: animais) {
			for (int i = 0; i < suino.getVacinas().size(); i++)
				if(suino.getVacinas().get(i).isVacinado() == true) {
					contVacina += 1;
				}
			if(contVacina == suino.getVacinas().size()) {
				contAnimal += 1;
				contVacina = 0;
			}else {
				contVacina = 0;
			}
				
				
		}
		
		semVacinar = (animais.size()) - contAnimal;
		return semVacinar;
	}
	
	public double calcularPrecoSuinoArroba(String identificador, List<Animal> suinos, Preco preco) {
		double precoSuino = 0;
		for(Animal suino: suinos) {
			if(suino.getRegistroUnico().equals(identificador)) {
				precoSuino += suino.getPeso() * preco.getPreco();
				
			}
		}
		
		return precoSuino;
	}
	
	public double calcularPrecoBovinoArroba(String identificador, List<Animal> bovinos, Preco preco) {
		double precoBovino = 0;
		for(Animal bovino: bovinos) {
			if(bovino.getRegistroUnico().equals(identificador)) {
				precoBovino += bovino.getPeso() * preco.getPreco();
				
			}
		}
		
		return precoBovino;
	}
	
	public double calcularPrecoBovinoQuilo(String identificador, List<Animal> bovinos, Preco preco) {
		double precoBovino = 0;
		for(Animal bovino: bovinos) {
			if(bovino.getRegistroUnico().equals(identificador)) {
				precoBovino += (bovino.getPeso() * 15) * preco.getPreco();
				
			}	
		}
		
		return precoBovino;
	}
	
	public double calcularPrecoSuinoQuilo(String identificador, List<Animal> suinos, Preco preco) {
		double precoSuino = 0;
		for(Animal suino: suinos) {
			if(suino.getRegistroUnico().equals(identificador)) {
				precoSuino += (suino.getPeso() * 15) * preco.getPreco();
				
			}	
		}
	
		return precoSuino;
	}
	
	public void calcularVendaSuino(String identificador, Scanner sc, List<Animal> suinos, Double valorTotalArroba, Double valorTotalQuilo, List<Animal> suinosVenda, Preco precoArroba, Preco precoQuilo, Venda venda, List<Venda> vendasPorco) {
		int check = 0;
		Animal suinoRemovido = null;
		System.out.println("Digite o identificador do suíno: ");
		identificador = sc.nextLine();
		for (Animal suino : suinos) {
			if (suino.getRegistroUnico().equals(identificador) && suino.getTipo().equals("suino")) {
				suinosVenda.add(suino);
				suinoRemovido = suino;
				valorTotalArroba = (valorTotalArroba + (suino.getPeso() * precoArroba.getPreco()));
				valorTotalQuilo += (suino.getPeso()*15) * precoQuilo.getPreco();
				System.out.println(suino.getRegistroUnico());
				check = 1;
				venda.setValorTotalArroba(valorTotalArroba);
				venda.setValorTotalQuilo(valorTotalQuilo);
				venda.setAnimais(suinosVenda);
				vendasPorco.add(venda);
			}
		}
		System.out.println(check);
		if (check == 0) {
			System.out.println("Este animal não existe nos registros");
		} else {
			suinos.remove(suinoRemovido);
		}

	}
	
	public void calcularVendaBovino(String identificador, Scanner sc, List<Animal> bovinos, Double valorTotalArroba, Double valorTotalQuilo, List<Animal> bovinosVenda, Preco precoArroba, Preco precoQuilo, Venda venda, List<Venda> vendasBoi) {
		int check = 0;
		Animal bovinoRemovido = null;
		System.out.println("Digite o identificador do suíno: ");
		identificador = sc.nextLine();
		for (Animal bovino : bovinos) {
			if (bovino.getRegistroUnico().equals(identificador) && bovino.getTipo().equals("bovino")) {
				bovinosVenda.add(bovino);
				bovinoRemovido = bovino;
				valorTotalArroba = (valorTotalArroba + (bovino.getPeso() * precoArroba.getPreco()));
				valorTotalQuilo += (bovino.getPeso()*15) * precoQuilo.getPreco();
				System.out.println(bovino.getRegistroUnico());
				check = 1;
				venda.setValorTotalArroba(valorTotalArroba);
				venda.setValorTotalQuilo(valorTotalQuilo);
				venda.setAnimais(bovinosVenda);
				vendasBoi.add(venda);
			}
		}
		System.out.println(check);
		if (check == 0) {
			System.out.println("Este animal não existe nos registros");
		} else {
			bovinos.remove(bovinoRemovido);
		}
	
	}
	
}
