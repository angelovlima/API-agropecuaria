package br.com.fatec.agropecuaria;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.services.BaseDados;
import br.com.fatec.agropecuaria.services.CadastrarAnimal;
import br.com.fatec.agropecuaria.services.Menu;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class App {
	public static void main(String[] args) {

		BaseDados baseDados = new BaseDados();
		CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();

		ArrayList<Vacina> vacinasBoi = new ArrayList<Vacina>();
		vacinasBoi = baseDados.popularListaVacinasBovino();

		ArrayList<Vacina> vacinasPorco = new ArrayList<Vacina>();
		vacinasPorco = baseDados.popularListaVacinasSuino();
		
		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois();

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos();
		
		Menu menu = new Menu();
		menu.menu();
		
	}
}
