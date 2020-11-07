package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuario.model.vacina.Carterinha;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class BaseDados {

	public List<Bovino> popularListaBois(Carterinha carterinhaBovino) {
		Random gerador = new Random();
		List<Bovino> bovinos = new ArrayList<Bovino>();
		for (int i = 1; i <= 10; i++) {
			
			if(i <= 2) {
				for (Vacina vacina : carterinhaBovino.getCarterinha()) {
						vacina.setVacinado(true);
				}
			} else {
				for (Vacina vacina : carterinhaBovino.getCarterinha()) {
					int numeroAleatorio = (gerador.nextInt(2)+1);
					System.out.println(numeroAleatorio);
					if(numeroAleatorio == 1) {
						vacina.setVacinado(true);
					} else {
						vacina.setVacinado(false);
						//System.out.println((gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2019 + gerador.nextInt(1)));
						vacina.setAgendamento("20/20/2020");
					}
				}
			}
		
			Bovino boi = new Bovino(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(1000)/15), 
					"boi"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					carterinhaBovino);
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
	
	public List<Suino> popularListaPorcos(Carterinha carterinhaSuino) {
		Random gerador = new Random();
		List<Suino> suinos = new ArrayList<Suino>();
		for (int i = 1; i <= 7; i++) {
			ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
			vacinas = carterinhaSuino.getCarterinha();
			if(i <= 2) {
				for (Vacina vacina : vacinas) {
						vacina.setVacinadoTeste(true);
				}
				
			} else {
				for (Vacina vacina : vacinas) {
					int numeroAleatorio = (gerador.nextInt(2)+1);
					if(numeroAleatorio == 1) {
						vacina.setVacinadoTeste(true);
					} else {
						vacina.setVacinadoTeste(false);
					}
				}
			}
			Carterinha vacinasCarteirinha = new Carterinha("suino", vacinas);
			Suino porco = new Suino(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(500)/15), 
					"porco"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					vacinasCarteirinha);
			suinos.add(porco);
		}
		for (Suino suino : suinos) {
			System.out.println("--------------------------");
			System.out.println(suino.getRegistroUnico());
			System.out.println(suino.getPeso());
			System.out.println(suino.getRaca());
			System.out.println(suino.getGenero());
			System.out.println(suino.getDataNascimento());
			for (Vacina vacina : suino.getCarterinha().getCarterinha()) {
				System.out.println(vacina.getVacina());
				System.out.println(vacina.getAgendamento());
				System.out.println(vacina.getVacinado());
			}
			System.out.println("--------------------------");
		}
		return suinos;
	}
	
	public ArrayList<Vacina> popularListaVacinasBovino() { 
		
		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();

		Vacina v1 = new Vacina("Febre Aftosa");
		vacinas.add(v1);
		Vacina v2 = new Vacina("Brucelose");
		vacinas.add(v2);
		Vacina v3 = new Vacina("Clostridioses");
		vacinas.add(v3);
		Vacina v4 = new Vacina("Botulismo");
		vacinas.add(v4);
		Vacina v5 = new Vacina("Leptospirose");
		vacinas.add(v5);
		Vacina v6 = new Vacina("Raiva bovina");
		vacinas.add(v6);
		Vacina v7 = new Vacina("IBR, BVD");
		vacinas.add(v7);
		
		return vacinas;
	
	}
	
	public ArrayList<Vacina> popularListaVacinasSuino() { 
		
		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();

		Vacina v1 = new Vacina("Circovirose suína");
		vacinas.add(v1);
		Vacina v2 = new Vacina("Pneumonia enzoótica");
		vacinas.add(v2);
		Vacina v3 = new Vacina("Doença de Glasser");
		vacinas.add(v3);
		Vacina v4 = new Vacina("Streptococcus");
		vacinas.add(v4);
		Vacina v5 = new Vacina("Rotavírus");
		vacinas.add(v5);
		Vacina v6 = new Vacina("Doenças Respiratórias");
		vacinas.add(v6);
		Vacina v7 = new Vacina("Rinite Atrófica");
		vacinas.add(v7);
		Vacina v8 = new Vacina("Enterotoxicose");
		vacinas.add(v8);
		Vacina v9 = new Vacina("Parvovirose e Leptospirose");
		vacinas.add(v9);
		
		return vacinas;
	
	}
	
}
