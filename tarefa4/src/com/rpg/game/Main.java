package com.rpg.game;

import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Fase;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.itens.Planador;
import com.rpg.personagens.Dobrador_de_Ar;
import com.rpg.personagens.Heroi;
import com.rpg.util.InputManager;
import java.util.List;
import java.util.Random;



public class Main {

    public static void main(String[] args) {
        int entrada = 0;
        String menu = """
            TERRAS SOMBRIAS - RPG
            ==================================================
            [1] Iniciar Novo Jogo
            [2] Ver Informacoes das Classes de Her ́ois
            [3] Ver Informacoes das Classes de Monstros
            [4] Sair do Jogo
            ==================================================
            Digite sua opcao >
            """;
        entrada = InputManager.lerInteiro(menu, 1, 4);
        while(entrada != 4){
            switch(entrada){
                case 1:

                    jogo(escolherDificuldade());
                    // Jogo novoJogo = new Jogo();
                    // novoJogo.iniciar();
                    String menuInterno = "1. Interagir com o Loot (se houver)\n2. Ver Informa ̧c ̃oes do Personagem\n3. Desistir do Jogo\n";
                    int entradaInterna = 0;
                    while((entradaInterna != 2) && (entradaInterna != 1) && (entradaInterna != 3)){
                        entradaInterna = InputManager.lerInteiro(menuInterno, 1, 3);
                        switch(entradaInterna){
                            case 1:
                                // novoJogo.interagirComLoot(); 
                                break;
                            case 2:
                                // novoJogo.exibirInfoHeroi();
                                break;
                            case 3:
                                System.out.println("Desistiu do jogo. Ate a proxima!");
                                break;
                            default:
                                System.out.println("Opcao invalida! Tente novamente.");
                                break;
                        }
                    }
                    break;
                case 2:
                    // Jogo.exibirInfoHerois();
                    break;
                case 3:
                    // Jogo.exibirInfoMonstros();
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
            }
            entrada = InputManager.lerInteiro(menu, 1, 4);
        }
    }

    public static Dificuldade escolherDificuldade() {
        String menuDificuldade = """
            Escolha a Dificuldade:
            [1] Fácil
            [2] Normal
            [3] Difícil
            Digite sua opção >
            """;
        
        int escolha = 0;
        while (true) {
            escolha = InputManager.lerInteiro(menuDificuldade, 1, 3);
            switch (escolha) {
                case 1 -> {
                    return Dificuldade.FACIL;
                }
                case 2 -> {
                    return Dificuldade.NORMAL;
                }
                case 3 -> {
                    return Dificuldade.DIFICIL;
                }
                default -> System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }

    public static void jogo(Dificuldade dificuldade) {
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
        List<Fase> fases = gerador.gerar(3, dificuldade);

        

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