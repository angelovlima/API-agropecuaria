package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.fatec.agropecuaria.model.animais.Animal;
import br.com.fatec.agropecuaria.model.precos.Preco;
import br.com.fatec.agropecuaria.model.vacina.Vacina;

public class BaseDados {

	public List<Animal> popularListaAnimais() {
		Random gerador = new Random();
		List<Animal> animais = new ArrayList<Animal>();
		for (int i = 1; i <= 10; i++) {			
		
			Animal boi = new Animal(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(1000)/15), 
					"boi"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					null,
					"bovino");
			animais.add(boi);
			
			boi.setVacinas(popularListaVacinasBovino());
			for (Vacina vacina : boi.getVacinas()) {
				int numeroAleatorio = (gerador.nextInt(2)+1);
				if(numeroAleatorio == 1) {
					vacina.setVacinado(false);
				} else {
					vacina.setVacinado(false);
					vacina.setAgendamento("20/20/2020");
				}
			}
		}
		for (int i = 1; i <= 10; i++) {
			
			Animal porco = new Animal(gerador.nextInt(100) +"00" + gerador.nextInt(100), 
					(double) (gerador.nextInt(500)/15), 
					"porco"+i, 
					(i % 2 == 0)?"M":"F", 
					(gerador.nextInt(20)+10)+"/0"+(gerador.nextInt(8)+1)+"/"+(2000 + gerador.nextInt(20)), 
					null,
					"suino");
			animais.add(porco);
			if(i == 1) {
				porco.setRegistroUnico("900");
			}
			if(i == 2) {
				porco.setRegistroUnico("9000");
			}
			if(i <= 2) {
				porco.setVacinas(popularListaVacinasSuino());
				for (Vacina vacina : porco.getVacinas()) {
						vacina.setVacinado(true);
						vacina.setAgendamento(null);
				}
			} else {
				porco.setVacinas(popularListaVacinasSuino());
				for (Vacina vacina : porco.getVacinas()) {
					int numeroAleatorio = (gerador.nextInt(2)+1);
					if(numeroAleatorio == 1) {
						vacina.setVacinado(true);
						vacina.setAgendamento(null);
					} else {
						vacina.setVacinado(false);
						vacina.setAgendamento("20/20/2020");
					}
				}
			}

		}
		return animais;
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
	
	public Preco definirPrecoQuilo() {
		Preco precoQuilo = new Preco(25.00);
		return precoQuilo;
	}
	
	public Preco definirPrecoArroba() {
		Preco precoArroba = new Preco(167.00);
		return precoArroba;
	}
}
