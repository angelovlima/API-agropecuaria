package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fatec.agropecuaria.model.animais.Bovino;

public class BaseDados {

	public List<Bovino> popularListaBois() {
		Random gerador = new Random();
		List<Bovino> bovinos = new ArrayList<Bovino>();
		for (int i = 1; i <= 10; i++) {
			Bovino boi = new Bovino(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) gerador.nextInt(1000), 
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
	
}
