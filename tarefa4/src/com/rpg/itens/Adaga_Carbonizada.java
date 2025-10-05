package com.rpg.itens;

public class Adaga_Carbonizada extends Arma {

    public Adaga_Carbonizada(int dano, int minNivel) {
        super(dano, minNivel);
    }

    public void atacar() {
        // Implementação específica do ataque do Adaga Carbonizada
        System.out.println("Adaga Carbonizada queima com o toque!");
    }

    @Override
    public String getNome() {
        return "Adaga Carbonizada";
    }
}