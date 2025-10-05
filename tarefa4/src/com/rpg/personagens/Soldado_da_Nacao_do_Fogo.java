package com.rpg.personagens;

import com.rpg.combates.AtaqueFisico;
import com.rpg.itens.Arma;
import com.rpg.itens.Adaga_Carbonizada;
import com.rpg.itens.Item;

public class Soldado_da_Nacao_do_Fogo extends Monstro {

    public Soldado_da_Nacao_do_Fogo(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
        acoes.add(new AtaqueFisico());
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano((int) (getForca() * 0.7));
    }

    @Override
    public Item droparLoot() {
        return new Adaga_Carbonizada(15, 1);
    }

}