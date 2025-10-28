package com.rpg.cenario;


import com.rpg.combates.AcaoDeCombate;
import com.rpg.exceptions.EquipaExepetion;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.util.InputManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FaseDeCombate implements Fase {
    private int nivel;
    private TipoCenario ambiente;
    private Monstro[] monstros;
    private boolean concluida;

    public FaseDeCombate(int nivel, TipoCenario ambiente, Monstro[] monstros) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = monstros;
        this.concluida = false;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Iniciando fase de combate: " + getAmbiente() + " (Nível " + nivel + ")");
        System.out.println("\n=== " + ambiente + " - " + ambiente.getDescricao() + " ===");
        ambiente.aplicarEfeitos(heroi);
        ArrayList<Item> loot = new ArrayList<>();
        Iterator<Monstro> iterator = Arrays.asList(monstros).iterator();
        while (iterator.hasNext() && heroi.estaVivo()) {
            Monstro monstro = iterator.next();
            if (monstro == null) continue;
            System.out.println("Um " + monstro.getNome() + " aparece!");
            
            while (heroi.estaVivo() && monstro.estaVivo()) {
                AcaoDeCombate acaoHeroi = heroi.escolherAcao(monstro);
                acaoHeroi.executar(heroi, monstro);
                if (!monstro.estaVivo()) break;

                AcaoDeCombate acaoMonstro = monstro.escolherAcao(heroi);
                acaoMonstro.executar(monstro, heroi);
            }

            if (!heroi.estaVivo()) {
                System.out.println("O herói foi derrotado! Fim de jogo.");
                this.concluida = false;
                return;
            } else {
                heroi.ganharExperiencia(monstro.getXpConcedido());
                loot.add(monstro.droparLoot());
                
            }
        }

        this.concluida = true;
        System.out.println("Fase concluída! O herói sobreviveu.");
        //menu interno
            String menuInterno = "1. Interagir com o Loot (se houver)\n2. Ver Informacoes do Personagem\n3. Desistir do Jogo\n";
            int entradaInterna = 0;
            while((entradaInterna != 2) && (entradaInterna != 1) && (entradaInterna != 3)){
                entradaInterna = InputManager.lerInteiro(menuInterno, 1, 3);
                switch(entradaInterna){
                    case 1:
                        int i = 0;
                        String mensagem = "Escolha o indice do item que deseja equipar:\n";
                        for(i=0; i< loot.size(); i++){
                            mensagem += "[" + i + "] " + loot.get(i).getNome() + "\n";
                        }
                        mensagem += "[" + i + "] Nenhum Loot\n";
                        mensagem += "Escolha o indice do item que deseja equipar: ";
                        int escolhaLoot = InputManager.lerInteiro(mensagem, 0, i);
                        if(escolhaLoot == i){
                            System.out.println("Nenhum loot foi equipado.");
                        } else {
                            System.out.println("Equipando loot...");
                            try {
                                heroi.equiparArma((Arma) loot.get(escolhaLoot));
                            } catch (EquipaExepetion e) {
                                System.out.println("Arma não equipada pois " + e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        heroi.exibirStatus();
                        break;
                    case 3:
                        System.out.println("Desistiu do jogo. Ate a proxima!");
                        heroi.updatePontosDeVida(0);
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                        break;
                }
                InputManager.esperarEnter("Pressione Enter para continuar...\n");
            }
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return ambiente;
    }

    public int getNivel() {
        return nivel;
    }

    public String getAmbiente() {
        return ambiente.toString();
    }

    public Monstro[] getMonstros() {
        return monstros;
    }    
}
