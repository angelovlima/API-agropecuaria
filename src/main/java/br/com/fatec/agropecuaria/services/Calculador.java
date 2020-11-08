package br.com.fatec.agropecuaria.services;

import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;

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
	
	public int calcularFemea(List<Bovino> bovinos, List<Suino> suinos) {
		int femeaTotal = 0;
		for (Suino suino : suinos) {
			if(suino.getGenero() == "F") {
				femeaTotal += 1;				
			}
			
		}
		
		for (Bovino bovino : bovinos) {
			if(bovino.getGenero() == "F") {
				femeaTotal += 1;				
			}
			
		}
		return femeaTotal;
	}
	
	public int calcularMacho(List<Bovino> bovinos, List<Suino> suinos) {
		int machoTotal = 0;
		for (Suino suino : suinos) {
			if(suino.getGenero() == "M") {
				machoTotal += 1;				
			}
			
		}
		
		for (Bovino bovino : bovinos) {
			if(bovino.getGenero() == "M") {
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
}
