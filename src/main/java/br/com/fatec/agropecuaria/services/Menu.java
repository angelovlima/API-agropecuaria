package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.model.precos.Arroba;
import br.com.fatec.agropecuaria.model.precos.Quilo;

public class Menu {
	
	public void menu(){
		
		Scanner scInt = new Scanner(System.in);
		
		
		
		BaseDados baseDados = new BaseDados();
		
		Arroba precoArroba = baseDados.definirPrecoArroba();
		Quilo precoQuilo = baseDados.definirPrecoQuilo();
		
		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();
		
		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Relatorios relatorios = new Relatorios();
		
		int menu = 10;
		
		while(menu != 0) {			
			System.out.println("\n+++++++++++++++++++++++MENU+++++++++++++++++++++++ \n"
					+ "1: Cadastrar Bovino \n"
					+ "2: Cadastrar Suino \n"
					+ "3: Checar preço de algum Animal \n"
					+ "4: Checar a quantidade de Animais Cadastrados \n"
					+ "5: Checar preço total do Rebanho \n"
					+ "6: Checar o peso total do Rebanho \n"
					+ "7: Checar animais por Gênero \n"
					+ "8: Checar a Porcentagem do rebanho Vacinado e quantos Faltam Vacinar \n");
			
			menu = scInt.nextInt();
			switch (menu) {
			
			case 1:
				bovinos.add(cadastrarAnimal.cadastrarBovino());
				break;
				
			case 2:
				suinos.add(cadastrarAnimal.cadastrarSuino());
				break;

			case 4:
				relatorios.quantidadeTotalAnimaisCadastrados(bovinos, suinos);
				break;
				
			case 5:
				relatorios.precoDoRebanho(bovinos, suinos, precoArroba, precoQuilo);
				break;
				
			case 6:
				relatorios.pesoDoRebanhoQuiloArroba(bovinos, suinos);
				break;
				
			case 7:
				relatorios.quantidadeFemeaMacho(bovinos, suinos);
				break;
				
			case 8:
				relatorios.dadosVacina(bovinos, suinos);
				
			default:
				break;
			}
			
		}
		
	}

}
