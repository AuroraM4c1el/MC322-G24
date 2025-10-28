package com.rpg.game;

import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Fase;
import com.rpg.cenario.FaseDeCombate;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.itens.Adaga_Carbonizada;
import com.rpg.itens.Cetro;
import com.rpg.itens.Mascara;
import com.rpg.itens.Planador;
import com.rpg.personagens.Dobrador_de_Agua;
import com.rpg.personagens.Dobrador_de_Ar;
import com.rpg.personagens.Dobrador_de_Terra;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Koh_Ladrao_de_Rostos;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Ozai_Senhor_do_Fogo;
import com.rpg.personagens.Soldado_da_Nacao_do_Fogo;
import com.rpg.util.InputManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<Heroi> heroisDisponiveis = new ArrayList<>();
        heroisDisponiveis.add( new Dobrador_de_Ar(
            "Aang", 
            150, 
            20, 
            5, 
            0, 
            30, 
            new Planador(15, 2), 
            50, 
            rand.nextFloat()
        ));
        heroisDisponiveis.add( new Dobrador_de_Agua(
            "Katara", 
            110, 
            18, 
            5, 
            0, 
            50, 
            new Planador(15, 2), 
            40, 
            rand.nextFloat()
        ));
        heroisDisponiveis.add(new Dobrador_de_Terra("Toph", 90, 20, 5, 10, 30, new Planador(15,2), 40, rand.nextFloat()));
        
        Monstro[] lista = new Monstro[3];

        lista[0] = new Koh_Ladrao_de_Rostos("Koh, o Ladrão de Rostos", (int)((130 + 10)), (int)((12)), 20 + 5, new Mascara(10, 5));
        lista[1] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", (int)((140 + 10)), (int)((15 )), 25 + 5, new Adaga_Carbonizada(10, 5));
        lista[2] = new Ozai_Senhor_do_Fogo("Ozai", (int)((150 + 10)), (int)((18)), 35 + 5, new Cetro(10, 5));

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
                    jogo(escolherDificuldade(), heroisDisponiveis.get(0));
                    break;
                case 2:
                    for (Heroi heroi : heroisDisponiveis) {
                        heroi.exibirStatus();
                        System.out.println();
                    }
                    break;
                case 3:
                    for (Monstro elem : lista) {
                        elem.exibirStatus();
                        System.out.println();
                        
                    }
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

    public static void jogo(Dificuldade dificuldade, Heroi heroi) {
        

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