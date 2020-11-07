package br.com.fatec.agropecuaria;

import java.util.ArrayList;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.services.CadastrarAnimal;
import br.com.fatec.agropecuario.model.vacina.Carterinha;
import br.com.fatec.agropecuario.model.vacina.Vacina;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        
        ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
        Vacina v1 = new Vacina("Febre Aftosa");
        vacinas.add(v1);
        Vacina v2 = new Vacina("Brucelose");
        vacinas.add(v2);
        Vacina v3 = new Vacina("Clostridioses");
        vacinas.add(v3);
        Vacina v4 = new Vacina("Botulismo");
        vacinas.add(v4);
        Vacina v5 = new Vacina("Leptospirose");
        vacinas.add(v5);
        Vacina v6 = new Vacina("Raiva bovina");
        vacinas.add(v6);
        Vacina v7 = new Vacina("IBR, BVD");
        vacinas.add(v7);
        
        Carterinha carterinhaBovino = new Carterinha("bovino",vacinas);
        
        CadastrarAnimal cadastrarAnimal = new CadastrarAnimal();
        
        Bovino bovino = cadastrarAnimal.cadastrarBovino(carterinhaBovino);
        
        System.out.println(bovino.getDataNascimento() + "\n"+
        		bovino.getGenero());
    }
}






















