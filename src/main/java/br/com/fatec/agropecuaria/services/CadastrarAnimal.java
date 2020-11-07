package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuario.model.vacina.Carterinha;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class CadastrarAnimal {

	public Carterinha cadastrarVacina(Carterinha carterinha) {
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
		vacinas = carterinha.getCarterinha();

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

		sc.close();
		scInt.close();

		return carterinha;

	}

	public Bovino cadastrarBovino(Carterinha carterinha) {
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
		

		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Carterinha carterinhaAtualizada = cadastrarAnimal.cadastrarVacina(carterinha);
		
		sc.close();
		scInt.close();

		Bovino bovino = new Bovino(registroUnico, peso, raca, genero, dataNascimento, carterinhaAtualizada);
		return bovino;
	}

}
