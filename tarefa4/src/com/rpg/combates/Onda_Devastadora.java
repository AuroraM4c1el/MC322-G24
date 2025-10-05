package com.rpg.combates;

import com.rpg.personagens.Dobrador_de_Agua;


public class Onda_Devastadora implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoCausado = calcularDano((Dobrador_de_Agua) usuario);
        System.out.println(usuario.getNome() + " usa Onda Devastadora em " + alvo.getNome() + " causando " + danoCausado + " de dano!");
        alvo.receberDano(danoCausado);
    }
    
    private int calcularDano(Dobrador_de_Agua heroi) {
        double dano_base = (Math.pow(heroi.getNivel(), 2) + heroi.getForca());
        dano_base = dano_base*(1 + heroi.getCalma() / 120.0) + 0.1* Math.sqrt(heroi.getForca() * heroi.getCalma());
        int dano = (int) Math.round(dano_base);
        return dano;
    }
}




