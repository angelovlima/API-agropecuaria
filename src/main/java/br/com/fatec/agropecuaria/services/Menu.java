package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.model.precos.Arroba;
import br.com.fatec.agropecuaria.model.precos.Quilo;
import br.com.fatec.agropecuaria.model.vendas.Venda;

public class Menu {

	public void menu() {

		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		BaseDados baseDados = new BaseDados();

		Arroba precoArroba = baseDados.definirPrecoArroba();
		Quilo precoQuilo = baseDados.definirPrecoQuilo();

		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();

		List<Bovino> bovinosVendidos = new ArrayList<Bovino>();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();

		List<Suino> suinosVendidos = new ArrayList<Suino>();

		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Relatorios relatorios = new Relatorios();

		Calculador calcular = new Calculador();

		List<Venda> vendasPorco = new ArrayList<Venda>();
		List<Venda> vendasBoi = new ArrayList<Venda>();

		int menu = 100;
		int menu2 = 100;
		int menu3 = 100;
		int menu4 = 100;
		while (menu != 0) {
			System.out.println("\n+++++++++++++++++++++++MENU+++++++++++++++++++++++ \n" + "0: Sair \n"
					+ "1: Cadastrar Bovino \n" + "2: Cadastrar Suino \n" + "3: Checar preço de algum Animal \n"
					+ "4: Checar a quantidade de Animais Cadastrados \n" + "5: Checar preço total do Rebanho \n"
					+ "6: Checar o peso total do Rebanho \n" + "7: Checar animais por Gênero \n"
					+ "8: Checar a Porcentagem do rebanho Vacinado e quantos Faltam Vacinar \n"
					+ "9: Vender Animal \n");

			menu = scInt.nextInt();
			switch (menu) {

			case 1:
				bovinos.add(cadastrarAnimal.cadastrarBovino());
				break;

			case 2:
				suinos.add(cadastrarAnimal.cadastrarSuino());
				break;

			case 3:
				double totalPrecoArroba = 0;
				double totalPrecoQuilo = 0;
				while (menu2 != 0) {
					System.out.println("\nESCOLHA UM TIPO DE ANIMAL\n" + "0: Sair \n" + "1: Bovino \n" + "2: Suino \n");

					menu2 = scInt.nextInt();
					String identificador;

					switch (menu2) {
					case 1:
						relatorios.registroUnicoBovino(bovinos);
						System.out.println("Digite o identificador do bovino: ");
						identificador = sc.nextLine();

						double bovinoArroba = calcular.calcularPrecoBovinoArroba(identificador, bovinos, precoArroba);
						double bovinoQuilo = calcular.calcularPrecoBovinoQuilo(identificador, bovinos, precoQuilo);
						totalPrecoArroba += bovinoArroba;
						totalPrecoQuilo += bovinoQuilo;

						System.out.println("Preço do Animal por Arroba: " + bovinoArroba);
						System.out.println("Preço do Animal por Quilo: " + bovinoQuilo);
						break;

					case 2:
						relatorios.registroUnicoSuino(suinos);
						System.out.println("Digite o identificador do suíno: ");
						identificador = sc.nextLine();

						double suinoArroba = calcular.calcularPrecoSuinoArroba(identificador, suinos, precoArroba);
						double suinoQuilo = calcular.calcularPrecoSuinoQuilo(identificador, suinos, precoQuilo);
						totalPrecoArroba += suinoArroba;
						totalPrecoQuilo += suinoQuilo;

						System.out.println("Preço do Animal por Arroba: " + suinoArroba);
						System.out.println("Preço do Animal por Quilo: " + suinoQuilo);
						break;

					default:
						break;
					}

					System.out.println("\nPreço total em Arroba:" + totalPrecoArroba);
					System.out.println("Preço total em Quilo: " + totalPrecoQuilo);
				}

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
				break;
			case 9:
				menu3 = 1;
				while (menu3 != 0) {
					System.out.println("\nESCOLHA UM TIPO DE ANIMAL\n" + "0: Sair \n" + "1: Bovino \n" + "2: Suino \n"
							+ "3: Registro de Venda \n");

					menu3 = scInt.nextInt();
					
					switch (menu3) {
					case 1:
						break;

					case 2:
						///////////////////////// FUTURA FUNCAO////////////////////////
						String identificador = "0";
						String dataVenda = null;
						double valorTotalVenda = 0;
						System.out.println("Entre com a data da venda");
						dataVenda = sc.nextLine();
						Venda venda = new Venda(dataVenda);
						List<Suino> suinosVenda = new ArrayList<Suino>();
						///////////////////////// FUTURA FUNCAO////////////////////////
						menu4 = 100;
						while (menu4 != 0) {
							int check = 0;
							Suino suinoRemovido = null;
							System.out.println("Digite o identificador do suíno: ");
							identificador = sc.nextLine();
							for (Suino suino : suinos) {
								if (suino.getRegistroUnico().equals(identificador)) {
									suinosVenda.add(suino);
									suinoRemovido = suino;
									valorTotalVenda = (valorTotalVenda + (suino.getPeso() * precoArroba.getPreco()));
									System.out.println(suino.getRegistroUnico());
									check = 1;
									venda.setValorTotal(valorTotalVenda);
									venda.setSuinos(suinosVenda);
									vendasPorco.add(venda);
								}
							}
							System.out.println(check);
							if (check == 0) {
								System.out.println("Este animal não existe nos registros");
							} else {
								suinos.remove(suinoRemovido);
							}
							String continuarVenda = "nao";
							System.out.println("Deseja continuar? (Digite 'sim' para continuar)");
							continuarVenda = sc.nextLine();
							if(!continuarVenda.equals("sim")) {
								menu4 = 0;
							}
							/////////////////////////////////////////////////////////////
						}
					
						break;

					case 3:
						relatorios.registroVendas(vendasBoi, vendasPorco, precoArroba);
						break;

					default:
						break;
					}
				}

			default:
				break;
			}

		}

	}

}
