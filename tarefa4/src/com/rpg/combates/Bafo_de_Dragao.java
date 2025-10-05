package com.rpg.combates;

import com.rpg.personagens.Dobrador_de_Fogo;

public class Bafo_de_Dragao implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoCausado = calcularDano((Dobrador_de_Fogo) usuario);
        System.out.println(usuario.getNome() + " usa Bafo de Dragão em " + alvo.getNome() + " causando " + danoCausado + " de dano!");
        alvo.receberDano(danoCausado);
    }

    private int calcularDano(Dobrador_de_Fogo heroi) {
        double dano_base = (Math.pow(heroi.getNivel(), 2) + heroi.getForca());
        dano_base = dano_base * (1 + Math.pow(heroi.getFervor() / 100.0, 0.8));
        int dano = (int) Math.round(dano_base);
        return dano;
    }
}