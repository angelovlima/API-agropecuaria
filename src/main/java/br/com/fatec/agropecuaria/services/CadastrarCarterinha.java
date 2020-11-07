package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.fatec.agropecuario.model.vacina.Carterinha;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class CadastrarCarterinha {
	public Carterinha cadastrarCarterinha() {
		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		String tipo = sc.nextLine();
		int quantidadeVacinas = scInt.nextInt();
		
		
		
		for(int i = quantidadeVacinas; i>0; i--) {
			String vacina = sc.nextLine();
			Vacina v = new Vacina(vacina);
			vacinas.add(v);
		}
		sc.close();
		scInt.close();
		
		Carterinha carterinha = new Carterinha(tipo,vacinas);
		
		return carterinha;
	}
}
