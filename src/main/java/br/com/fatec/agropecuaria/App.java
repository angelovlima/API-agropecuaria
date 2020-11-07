package br.com.fatec.agropecuaria;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.agropecuaria.model.animais.Bovino;
import br.com.fatec.agropecuaria.model.animais.Suino;
import br.com.fatec.agropecuaria.services.BaseDados;
import br.com.fatec.agropecuaria.services.Relatorios;

public class App 
{
    public static void main( String[] args )
    {       
        BaseDados baseDados = new BaseDados();
        
        List<Bovino> bovinos = new ArrayList<Bovino>();
        bovinos = baseDados.popularListaBois();

        List<Suino> suinos = new ArrayList<Suino>();
        suinos = baseDados.popularListaPorcos();
        
        Relatorios relatorios = new Relatorios();
        relatorios.quantidadeTotalAnimaisCadastrados(bovinos, suinos);
        relatorios.pesoDoRebanhoQuiloArroba(bovinos, suinos);
        relatorios.quantidadeFemeaMacho(bovinos, suinos);

//        ArrayList<Vacina> vacinas = new ArrayList<Vacina>();
//        Vacina v1 = new Vacina("Febre Aftosa");
//        vacinas.add(v1);
//        Vacina v2 = new Vacina("Brucelose");
//        vacinas.add(v2);
//        Vacina v3 = new Vacina("Clostridioses");
//        vacinas.add(v3);
//        Vacina v4 = new Vacina("Botulismo");
//        vacinas.add(v4);
//        Vacina v5 = new Vacina("Leptospirose");
//        vacinas.add(v5);
//        Vacina v6 = new Vacina("Raiva bovina");
//        vacinas.add(v6);
//        Vacina v7 = new Vacina("IBR, BVD");
//        vacinas.add(v7);
//        
//        Carterinha carterinhaBovino = new Carterinha(vacinas);
    }
}
