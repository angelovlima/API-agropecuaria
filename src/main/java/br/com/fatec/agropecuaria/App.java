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
        System.out.println("Nome: " + boizinho.getNome());
        System.out.println("Peso: " + boizinho.getPeso());
        System.out.println("Tomou Vacina: " + boizinho.getTomouVacina() != null ? "Seu boizinho é vacinado e feliz" : "Falta vacina");
        //Tábatha testando 
        //Teste do Fork jkhjhk
    }
}
