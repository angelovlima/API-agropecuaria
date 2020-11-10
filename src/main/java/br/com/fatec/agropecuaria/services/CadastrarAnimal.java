package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Animal;
import br.com.fatec.agropecuaria.model.vacina.Vacina;

public class CadastrarAnimal {
	
	BaseDados baseDados = new BaseDados();

	public List<Vacina> cadastrarVacina(List<Vacina> vacinas) {
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Digite 'sim' para todas as vacinas que o animal já tomou.");
		for (Vacina vacina : vacinas) {
			System.out.println(vacina.getVacina());
			String vacinado = sc.nextLine();
			if (vacinado.equals("sim") || vacinado.equals("Sim")) {
				vacina.setVacinado(true);
			} else {
				vacina.setVacinado(false);
				System.out.println("Digite o dia do Agendamento: ");
				String agendamento = sc.nextLine();
				vacina.setAgendamento(agendamento);
			}
		}

		//sc.close();
		//scInt.close();

		return vacinas;

	}

	public Animal cadastrarBovino() {
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		System.out.println("Registro Unico: ");
		String registroUnico = sc.nextLine();
		System.out.println("Peso: ");
		Double peso = scInt.nextDouble();
		System.out.println("Raça: ");
		String raca = sc.nextLine();
		System.out.println("Genero: ");
		String genero = sc.nextLine();
		System.out.println("Data de Nascimento: ");
		String dataNascimento = sc.nextLine();

		Animal bovino = new Animal(registroUnico, peso, raca, genero, dataNascimento, null, "bovino");
		bovino.setVacinas(baseDados.popularListaVacinasBovino());
		
		List<Vacina> vacinas = new ArrayList<Vacina>();
		vacinas = cadastrarVacina(bovino.getVacinas());
		bovino.setVacinas(vacinas);
		
		//sc.close();
		//scInt.close();
		return bovino;
	}


	public Animal cadastrarSuino() {
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		System.out.println("Registro Unico: ");
		String registroUnico = sc.nextLine();
		System.out.println("Peso: ");
		Double peso = scInt.nextDouble();
		System.out.println("Raça: ");
		String raca = sc.nextLine();
		System.out.println("Genero: ");
		String genero = sc.nextLine();
		System.out.println("Data de Nascimento: ");
		String dataNascimento = sc.nextLine();	

		Animal suino = new Animal(registroUnico, peso, raca, genero, dataNascimento, null, "suino");
		suino.setVacinas(baseDados.popularListaVacinasSuino());
		
		List<Vacina> vacinas = new ArrayList<Vacina>();
		vacinas = cadastrarVacina(suino.getVacinas());
		suino.setVacinas(vacinas);
		
		//sc.close();
		//scInt.close();
		return suino;
	}

}
