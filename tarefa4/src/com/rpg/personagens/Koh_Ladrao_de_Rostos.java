package com.rpg.personagens;

import com.rpg.combates.AtaqueFisico;
import com.rpg.itens.Arma;
import com.rpg.itens.Item;
import com.rpg.itens.Mascara;

public class Koh_Ladrao_de_Rostos extends Monstro{

    public Koh_Ladrao_de_Rostos(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
        acoes.add(new AtaqueFisico());
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano((int) (getForca() * 0.4));
    }

    @Override
    public Item droparLoot() {
        return new Mascara(50, 5);
    }

}