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
}
