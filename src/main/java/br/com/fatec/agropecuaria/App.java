package br.com.fatec.agropecuaria;

import br.com.fatec.agropecuaria.model.boizinho.Boizinho;
import br.com.fatec.agropecuaria.services.BoizinhoService;

public class App 
{
    public static void main( String[] args )
    {
        BoizinhoService boizinhoService = new BoizinhoService();
        
        Boizinho boizinho = boizinhoService.cadastrarBoi("Brutus", 1500.00, true);
        
        System.out.println("Aqui está seu gado");
        System.out.println(boizinho.getNome());
        System.out.println(boizinho.getPeso());
        System.out.println(boizinho.getTomouVacina() ? "Seu boizinho é vacinado e feliz" : "Falta vacina");
        //Teste do Fork 2
    }
}
