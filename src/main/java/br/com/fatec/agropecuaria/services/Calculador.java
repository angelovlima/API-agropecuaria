package br.com.fatec.agropecuaria.services;

import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.model.precos.Arroba;
import br.com.fatec.agropecuaria.model.precos.Quilo;
import br.com.fatec.agropecuaria.model.vendas.Venda;


public class Calculador {

	public int calcularTotalAnimais(List<Bovino> bovinos, List<Suino> suinos) {
		return (bovinos.size() + suinos.size());
	}
	
	public double calcularPesoArroba(List<Bovino> bovinos, List<Suino> suinos) {
		double pesoTotal = 0;
		for (Suino suino : suinos) {
			pesoTotal = pesoTotal + suino.getPeso();
		}
		for (Bovino bovino : bovinos) {
			pesoTotal = pesoTotal + bovino.getPeso();
		}
		return pesoTotal;
	}
	
	public double calcularPesoQuilo(List<Bovino> bovinos, List<Suino> suinos) {
		double pesoTotal = 0;
		for (Suino suino : suinos) {
			pesoTotal = pesoTotal + (suino.getPeso()*15);
		}
		for (Bovino bovino : bovinos) {
			pesoTotal = pesoTotal + (bovino.getPeso()*15);
		}
		return pesoTotal;
	}
	
	public double calcularPrecoArroba(List<Bovino> bovinos, List<Suino> suinos, Arroba preco) {
		double precoTotal = 0;
		
		for (Suino suino : suinos) {
			precoTotal = precoTotal + preco.getPreco() * suino.getPeso();
		}
		for (Bovino bovino : bovinos) {
			precoTotal = precoTotal + preco.getPreco() * bovino.getPeso() ;
		}
		return precoTotal;
	}
	
	public double calcularPrecoQuilo(List<Bovino> bovinos, List<Suino> suinos, Quilo preco) {
		double precoTotal = 0;
		
		for (Suino suino : suinos) {
			System.out.println(preco.getPreco()+ "<-preço do porco\n" 
		+precoTotal );
			precoTotal = precoTotal + preco.getPreco() * suino.getPeso();
		}
		for (Bovino bovino : bovinos) {
			precoTotal = precoTotal + preco.getPreco() * bovino.getPeso() ;
		}
		return precoTotal * 15;
	}
	
	public int calcularFemea(List<Bovino> bovinos, List<Suino> suinos) {
		int femeaTotal = 0;
		for (Suino suino : suinos) {
			if(suino.getGenero().equals("F") || suino.getGenero().equals("f")) {
				femeaTotal += 1;				
			}
			
		}
		
		for (Bovino bovino : bovinos) {
			if(bovino.getGenero().equals("F") || bovino.getGenero().equals("f")) {
				femeaTotal += 1;				
			}
			
		}
		return femeaTotal;
	}
	
	public int calcularMacho(List<Bovino> bovinos, List<Suino> suinos) {
		int machoTotal = 0;
		for (Suino suino : suinos) {
			if(suino.getGenero().equals("M") || suino.getGenero().equals("m")) {
				machoTotal += 1;				
			}
			
		}
		
		for (Bovino bovino : bovinos) {
			if(bovino.getGenero().equals("M")|| bovino.getGenero().equals("m")) {
				machoTotal += 1;				
			}
			
		}
		return machoTotal;
	}
	
	public double calcularPorcentagem(List<Bovino> bovinos, List<Suino> suinos) {
		double porcentoTotal = 0;
		int contVacina = 0;
		int contAnimal = 0;
		for(Suino suino: suinos) {
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
		
		for(Bovino bovino: bovinos) {
			for (int i = 0; i < bovino.getVacinas().size(); i++)
				if(bovino.getVacinas().get(i).isVacinado() == true) {
					contVacina += 1;
					
				}
			if(contVacina == bovino.getVacinas().size()) {
				contAnimal += 1;
				contVacina = 0;
			}else {
				contVacina = 0;
			}
		}
		porcentoTotal = (contAnimal*100)/(bovinos.size()+suinos.size());
		return porcentoTotal;
	}
	
	public int faltamVacinar(List<Bovino> bovinos, List<Suino> suinos) {
		int semVacinar = 0;
		int contVacina = 0;
		int contAnimal = 0;
		for(Suino suino: suinos) {
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
		
		for(Bovino bovino: bovinos) {
			for (int i = 0; i < bovino.getVacinas().size(); i++)
				if(bovino.getVacinas().get(i).isVacinado() == true) {
					contVacina += 1;
					
				}
			if(contVacina == bovino.getVacinas().size()) {
				contAnimal += 1;
				contVacina = 0;
			}else {
				contVacina = 0;
			}
		}
		semVacinar = (bovinos.size()+suinos.size()) - contAnimal;
		return semVacinar;
	}
	
	public double calcularPrecoSuinoArroba(String identificador, List<Suino> suinos, Arroba preco) {
		double precoSuino = 0;
		for(Suino suino: suinos) {
			if(suino.getRegistroUnico().equals(identificador)) {
				precoSuino += suino.getPeso() * preco.getPreco();
				
			}	
		}
		
		return precoSuino;
	}
	
	public double calcularPrecoBovinoArroba(String identificador, List<Bovino> bovinos, Arroba preco) {
		double precoBovino = 0;
		for(Bovino bovino: bovinos) {
			if(bovino.getRegistroUnico().equals(identificador)) {
				precoBovino += bovino.getPeso() * preco.getPreco();
				
			}	
		}
		
		return precoBovino;
	}
	
	public double calcularPrecoBovinoQuilo(String identificador, List<Bovino> bovinos, Quilo preco) {
		double precoBovino = 0;
		for(Bovino bovino: bovinos) {
			if(bovino.getRegistroUnico().equals(identificador)) {
				precoBovino += (bovino.getPeso() * 15) * preco.getPreco();
				
			}	
		}
		
		return precoBovino;
	}
	
	public double calcularPrecoSuinoQuilo(String identificador, List<Suino> suinos, Quilo preco) {
		double precoSuino = 0;
		for(Suino suino: suinos) {
			if(suino.getRegistroUnico().equals(identificador)) {
				precoSuino += (suino.getPeso() * 15) * preco.getPreco();
				
			}	
		}
	
		return precoSuino;
	}
	
	public void vendaSuino(String identificador, Scanner sc, List<Suino> suinos, Double valorTotalVenda, List<Suino> suinosVenda, Arroba precoArroba, Venda venda, List<Venda> vendasPorco) {
		int check = 0;
		Suino suinoRemovido = null;
		System.out.println("Digite o identificador do suíno: ");
		identificador = sc.nextLine();
		for (Suino suino : suinos) {
			if (suino.getRegistroUnico().equals(identificador)) {
				suinosVenda.add(suino);
				suinoRemovido = suino;
				valorTotalVenda = (valorTotalVenda + (suino.getPeso() * precoArroba.getPreco()));
				System.out.println(suino.getRegistroUnico());
				check = 1;
				venda.setValorTotal(valorTotalVenda);
				venda.setSuinos(suinosVenda);
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
	
}
