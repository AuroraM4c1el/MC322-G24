package com.rpg.itens;

public class Mascara extends Arma {

    public Mascara(int dano, int minNivel) {
        super(dano, minNivel);
    }

    public void atacar() {
        // Implementação específica do ataque do Máscara de Koh
        System.out.println("Máscara de Koh carrega o poder dos espíritos!");
    }

    @Override
    public String getNome() {
        return "Máscara de Koh";
    }
}