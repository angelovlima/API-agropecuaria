package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;

public class Menu {
	
	public void menu(){
		
		Scanner scInt = new Scanner(System.in);
		
		
		
		BaseDados baseDados = new BaseDados();
		
		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();
		
		List<Bovino> bovinosVendidos = new ArrayList<Bovino>();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();
		
		List<Suino> suinosVendidos = new ArrayList<Suino>();
		
		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Relatorios relatorios = new Relatorios();
		
		int menu = 10;
		
		while(menu != 0) {
			System.out.println(bovinos.size());
			
			System.out.println("\n+++++++++++++++++++++++MENU+++++++++++++++++++++++ \n"
					+ "1: Cadastrar Bovino \n"
					+ "2: Cadastrar Suino \n"
					+ "3: Checar preço de algum Animal \n"
					+ "4: Checar o preço total de Animais \n"
					+ "5: Checar a quantidade de Animais Cadastrados \n"
					+ "6: Checar preço total do Rebanho \n"//e a quantidade do rebanho tbm
					+ "7: Checar o peso total do Rebanho \n"//aqui tbm precisa da quantidade do rebanho
					+ "8: Checar animais por Gênero \n"
					+ "9: Checar a Porcentagem do rebanho Vacinado e quantos Faltam Vacinar \n");
			
			menu = scInt.nextInt();
			switch (menu) {
			
			case 1:
				Bovino bovino = cadastrarAnimal.cadastrarBovino();
				bovinos.add(bovino);
				break;
				
			case 2:
				suinos.add(cadastrarAnimal.cadastrarSuino());
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

}
