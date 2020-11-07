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
}
