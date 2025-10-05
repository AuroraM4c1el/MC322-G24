package com.rpg.personagens;

import com.rpg.combates.AtaqueFisico;
import com.rpg.combates.Bafo_de_Dragao;
import com.rpg.itens.Arma;


public class Dobrador_de_Fogo extends Heroi {

    private int fervor;

    public Dobrador_de_Fogo(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int fervor, Arma arma, int expProximoNivel, float sorte) {
        super(nome, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.fervor = fervor;
        acoes.add(new Bafo_de_Dragao());
        acoes.add(new AtaqueFisico());
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] Monstros) {
        System.out.println(getNome() + " usou a habilidade especial: Bafo de Dragão!");
        for (Personagem monstro : Monstros) {
            monstro.receberDano(calcularDano(true));
        }
    }

    private int calcularDano(boolean especial) {
        double dano_base = (Math.pow(getNivel(), 2) + getForca());
        if (especial) {
            dano_base = dano_base * (1 + Math.pow(fervor / 100.0, 0.8));
        }
        int dano = (int) Math.round(dano_base);
        return dano;
    }

    
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano(calcularDano(false));
    }

    public int getFervor() {
        return fervor;
    }

}
