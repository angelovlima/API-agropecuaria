package br.com.fatec.agropecuaria;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.services.BaseDados;
import br.com.fatec.agropecuaria.services.CadastrarAnimal;
import br.com.fatec.agropecuaria.services.Relatorios;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class App {
	public static void main(String[] args) {

		BaseDados baseDados = new BaseDados();
		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();

		ArrayList<Vacina> vacinasBoi = new ArrayList<Vacina>();
		vacinasBoi = baseDados.popularListaVacinasBovino();

		ArrayList<Vacina> vacinasPorco = new ArrayList<Vacina>();
		vacinasPorco = baseDados.popularListaVacinasSuino();
		
//        CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
//        
//        Bovino bovino = cadastrarAnimal.cadastrarBovino(carterinhaBovino);
//        
//        System.out.println(bovino.getCarterinha().getTipo() + "\n"+
//        		bovino.getCarterinha().getCarterinha().get(0).getAgendamento());
//        
		// Desde aqui usa-se o BaseDados

		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();
		
		
		Relatorios relatorios = new Relatorios();
		relatorios.quantidadeTotalAnimaisCadastrados(bovinos, suinos);
		relatorios.pesoDoRebanhoQuiloArroba(bovinos, suinos);
		relatorios.quantidadeFemeaMacho(bovinos, suinos);
		
		suinos.add(cadastrarAnimal.cadastrarSuino());
		for (Suino suino : suinos) {
			System.out.println("--------------------------");
			System.out.println(suino.getRegistroUnico());
			System.out.println(suino.getPeso());
			System.out.println(suino.getRaca());
			System.out.println(suino.getGenero());
			System.out.println(suino.getDataNascimento());
			for (Vacina vacina : suino.getVacinas()) {
				System.out.println(vacina.getAgendamento());
				System.out.println(vacina.getVacina());
				System.out.println(vacina.getVacinado());
			}
		}
	}
}
