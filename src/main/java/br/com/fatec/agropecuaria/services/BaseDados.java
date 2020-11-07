package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;

public class BaseDados {

	public List<Bovino> popularListaBois() {
		Random gerador = new Random();
		List<Bovino> bovinos = new ArrayList<Bovino>();
		for (int i = 1; i <= 10; i++) {
			Bovino boi = new Bovino(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(1000)/15), 
					"boi"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					null);
			bovinos.add(boi);
		}
		for (Bovino bovino : bovinos) {
			System.out.println("--------------------------");
			System.out.println(bovino.getRegistroUnico());
			System.out.println(bovino.getPeso());
			System.out.println(bovino.getRaca());
			System.out.println(bovino.getGenero());
			System.out.println(bovino.getDataNascimento());
			System.out.println("--------------------------");
		}
		return bovinos;
	}
	
	public List<Suino> popularListaPorcos() {
		Random gerador = new Random();
		List<Suino> suinos = new ArrayList<Suino>();
		for (int i = 1; i <= 7; i++) {
			Suino porco = new Suino(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(500)/15), 
					"porco"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					null);
			suinos.add(porco);
		}
		for (Suino suino : suinos) {
			System.out.println("--------------------------");
			System.out.println(suino.getRegistroUnico());
			System.out.println(suino.getPeso());
			System.out.println(suino.getRaca());
			System.out.println(suino.getGenero());
			System.out.println(suino.getDataNascimento());
			System.out.println("--------------------------");
		}
		return suinos;
	}
	
}
