package br.com.fatec.agropecuaria;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.services.BaseDados;
import br.com.fatec.agropecuaria.services.Relatorios;
import br.com.fatec.agropecuario.model.vacina.Carterinha;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class App {
	public static void main(String[] args) {

		BaseDados baseDados = new BaseDados();

		ArrayList<Vacina> vacinasBoi = new ArrayList<Vacina>();
		vacinasBoi = baseDados.popularListaVacinasBovino();
		Carterinha carterinhaBovino = new Carterinha("bovino", vacinasBoi);

		ArrayList<Vacina> vacinasPorco = new ArrayList<Vacina>();
		vacinasPorco = baseDados.popularListaVacinasSuino();
		Carterinha carterinhaSuino = new Carterinha("suino", vacinasPorco);

//        CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
//        
//        Bovino bovino = cadastrarAnimal.cadastrarBovino(carterinhaBovino);
//        
//        System.out.println(bovino.getCarterinha().getTipo() + "\n"+
//        		bovino.getCarterinha().getCarterinha().get(0).getAgendamento());
//        
		// Desde aqui usa-se o BaseDados

		List<Bovino> bovinos = new ArrayList<Bovino>();
		bovinos = baseDados.popularListaBois(carterinhaBovino);

		List<Suino> suinos = new ArrayList<Suino>();
		suinos = baseDados.popularListaPorcos(carterinhaSuino);
//		for (Suino suino : suinos) {
//			Carterinha carteirinha = suino.getCarterinha();
//			ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
//			vacinas = carteirinha.getCarterinha();
//			for (Vacina vacina : vacinas) {
//				System.out.println(vacina.getVacina());
//			}
//		}
		Relatorios relatorios = new Relatorios();
		relatorios.quantidadeTotalAnimaisCadastrados(bovinos, suinos);
		relatorios.pesoDoRebanhoQuiloArroba(bovinos, suinos);
		relatorios.quantidadeFemeaMacho(bovinos, suinos);
	}
}
