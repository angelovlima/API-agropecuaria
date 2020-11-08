package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class Menu {
	
	public void menu(){
		
		Scanner scInt = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++MENU+++++++++++++++++++++++"
				+ "1: Cadastrar Bovino"
				+ "2: Cadastrar Suino"
				+ "3: Checar preço de algum Animal"
				+ "4: Checar o preço total de Animais"
				+ "5: Checar a quantidade de Animais Cadastrados"
				+ "6: Checar preço total do Rebanho"//e a quantidade do rebanho tbm
				+ "7: Checar o peso total do Rebanho"//aqui tbm precisa da quantidade do rebanho
				+ "8: Checar animais por Gênero"
				+ "9: Checar a Porcentagem do rebanho Vacinado e quantos Faltam Vacinar");
		int menu = scInt.nextInt();
		
		BaseDados baseDados = new BaseDados();

		ArrayList<Vacina> vacinasBoi = new ArrayList<Vacina>();
		vacinasBoi = baseDados.popularListaVacinasBovino();

		ArrayList<Vacina> vacinasPorco = new ArrayList<Vacina>();
		vacinasPorco = baseDados.popularListaVacinasSuino();
		
		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();
		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Relatorios relatorios = new Relatorios();
		switch (menu) {
		
				
		case 1:
			cadastrarAnimal.cadastrarBovino(null);
			break;
			
		case 2:
			cadastrarAnimal.cadastrarSuino(null);
			break;

		case 5:
			relatorios.quantidadeTotalAnimaisCadastrados(bovinos, suinos);
			break;
			
		case 7:
			relatorios.pesoDoRebanhoQuiloArroba(bovinos, suinos);
			break;
			
		case 8:
			relatorios.quantidadeFemeaMacho(bovinos, suinos);
			break;
			
		default:
			break;
		}
	}

}
