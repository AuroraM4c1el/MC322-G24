package com.rpg.cenario;

public enum Dificuldade {
    FACIL(0.8, 0.8),
    NORMAL(1.0, 1.0),
    DIFICIL(1.5, 1.3);

    private final double multiplicadorVida;
    private final double multiplicadorForca;

    Dificuldade(double multiplicadorVida, double multiplicadorForca) {
        this.multiplicadorVida = multiplicadorVida;
        this.multiplicadorForca = multiplicadorForca;
    }

    public double getMultiplicadorVida() {
        return multiplicadorVida;
    }

    public double getMultiplicadorForca() {
        return multiplicadorForca;
    }
}