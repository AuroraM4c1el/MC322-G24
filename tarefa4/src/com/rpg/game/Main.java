package com.rpg.game;


import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Fase;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.itens.Planador;
import com.rpg.personagens.Dobrador_de_Ar;
import com.rpg.personagens.Heroi;
import java.util.List;
import java.util.Random;



public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        float sorteAleatoria = rand.nextFloat();
        Heroi heroi = new Dobrador_de_Ar(
            "Aang", 
            90, 
            20, 
            5, 
            0, 
            30, 
            new Planador(15, 2), 
            50, 
            sorteAleatoria
        );

        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3);

        System.out.println("=== O HERÓI ENTRA NO DESAFIO DE SOBREVIVÊNCIA! ===");
        System.out.println("Um mestre do Ar deve enfrentar todas as fases...\n");

        // Loop por cada fase
        for (int faseIndex = 0; faseIndex < fases.size() && heroi.estaVivo(); faseIndex++) {
            FaseDeCombate faseAtual = (FaseDeCombate) fases.get(faseIndex);

            System.out.println("\n===== INÍCIO DA FASE " + faseAtual.getNivel() + " - " + faseAtual.getAmbiente() + " =====");
            System.out.println("O HERÓI ENTRA NA " + faseAtual.getAmbiente() + " PARA ENFRENTAR " + faseAtual.getMonstros().length + " MONSTROS!");
            System.out.println("-- STATUS DO HERÓI NO INÍCIO DA FASE " + faseAtual.getNivel() + " --");
            heroi.exibirStatus();

            faseAtual.iniciar(heroi);

            System.out.println("===== FIM DA FASE " + faseAtual.getNivel() + " =====\n");
        }

        // Se sobreviveu a todas as fases
        if (heroi.estaVivo()) System.out.println("\n*** VITÓRIA! O herói sobreviveu a todas as fases! ***");
    }
}