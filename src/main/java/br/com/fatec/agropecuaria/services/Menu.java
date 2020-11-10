package br.com.fatec.agropecuaria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fatec.agropecuaria.model.animais.Animal;
import br.com.fatec.agropecuaria.model.precos.Preco;
import br.com.fatec.agropecuaria.model.vendas.Venda;

public class Menu {

	@SuppressWarnings("resource")
	public void menu() {

		Scanner sc = new Scanner(System.in);

		Scanner scInt = new Scanner(System.in);

		BaseDados baseDados = new BaseDados();

		Preco precoArroba = baseDados.definirPrecoArroba();
		Preco precoQuilo = baseDados.definirPrecoQuilo();

		List<Animal> animais = new ArrayList<Animal>();
		animais = baseDados.popularListaAnimais();

		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
		Relatorios relatorios = new Relatorios();

		Calculador calcular = new Calculador();

		List<Venda> vendasBoi = new ArrayList<Venda>();
		List<Venda> vendasPorco = new ArrayList<Venda>();

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
				animais.add(cadastrarAnimal.cadastrarBovino());
				break;

			case 2:
				animais.add(cadastrarAnimal.cadastrarSuino());
				break;

			case 3:
				double totalPrecoArroba = 0;
				double totalPrecoQuilo = 0;

				String identificador;

				relatorios.registroUnicoBovino(animais);
				System.out.println("Digite o identificador do bovino: ");
				identificador = sc.nextLine();

				totalPrecoArroba = relatorios.precoUnicoBovinoArroba(identificador, animais, precoArroba,
						totalPrecoArroba);
				totalPrecoQuilo = relatorios.precoUnicoBovinoQuilo(identificador, animais, precoQuilo, totalPrecoQuilo);

				relatorios.precoTotalArroba(totalPrecoArroba);
				relatorios.precoTotalQuilo(totalPrecoQuilo);

				break;

			case 4:
				relatorios.quantidadeTotalAnimaisCadastrados(animais);
				break;

			case 5:
				relatorios.precoDoRebanho(animais, precoArroba, precoQuilo);
				break;

			case 6:
				relatorios.pesoDoRebanhoQuiloArroba(animais);
				break;

			case 7:
				relatorios.quantidadeFemeaMacho(animais);
				break;

			case 8:
				relatorios.dadosVacina(animais);
				break;
			case 9:
				menu3 = 1;
				while (menu3 != 0) {
					System.out.println("\nESCOLHA UM TIPO DE ANIMAL\n" + "0: Sair \n" + "1: Bovino \n" + "2: Suino \n"
							+ "3: Registro de Venda \n");

					menu3 = scInt.nextInt();

					switch (menu3) {
					case 1:
						///////////////////////// FUTURA FUNCAO////////////////////////

						String identificadorBovino = "0";
						String dataVenda = null;
						double valorTotalQuilo = 0;
						double valorTotalArroba = 0;
						System.out.println("Entre com a data da venda");
						dataVenda = sc.nextLine();
						Venda venda = new Venda(dataVenda);
						List<Animal> bovinosVenda = new ArrayList<Animal>();
						relatorios.registroUnicoBovino(animais);
						///////////////////////// FUTURA FUNCAO////////////////////////
						menu4 = 100;
						while (menu4 != 0) {
							calcular.calcularVendaBovino(identificadorBovino, sc, animais, valorTotalArroba, valorTotalQuilo,
									bovinosVenda, precoArroba, precoQuilo, venda, vendasBoi);
							String continuarVenda = "nao";
							System.out.println("Deseja continuar? (Digite 'sim' para continuar)");
							continuarVenda = sc.nextLine();
							if (!continuarVenda.equals("sim")) {
								menu4 = 0;
							}
							/////////////////////////////////////////////////////////////
						}
						break;

					case 2:
						///////////////////////// FUTURA FUNCAO////////////////////////

						String identificador1 = "0";
						String dataVenda1 = null;
						double valorTotalArroba1 = 0;
						double valorTotalQuilo1 = 0;
						System.out.println("Entre com a data da venda");
						dataVenda1 = sc.nextLine();
						Venda venda1 = new Venda(dataVenda1);
						List<Animal> suinosVenda = new ArrayList<Animal>();
						relatorios.registroUnicoSuino(animais);
						///////////////////////// FUTURA FUNCAO////////////////////////
						menu4 = 100;
						while (menu4 != 0) {
							calcular.calcularVendaSuino(identificador1, sc, animais, valorTotalArroba1, valorTotalQuilo1,
									suinosVenda, precoArroba, precoQuilo, venda1, vendasPorco);
							String continuarVenda = "nao";
							System.out.println("Deseja continuar? (Digite 'sim' para continuar)");
							continuarVenda = sc.nextLine();
							if (!continuarVenda.equals("sim")) {
								menu4 = 0;
							}
							/////////////////////////////////////////////////////////////
						}

						break;

					case 3:
						relatorios.registroVendas(vendasBoi, vendasPorco, precoArroba, precoQuilo);
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
