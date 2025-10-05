package com.rpg.cenario;

import com.rpg.personagens.Heroi;

public enum TipoCenario {
    TRIBO_DA_AGUA("As tribos do Polo Norte e Sul, moldadas pelo gelo e pela maré.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            // Ambientes frios revigoram dobradores de água
            heroi.receberCura(5);
            System.out.println("A maré fortalece o espírito do herói!");
        }
    },
    REINO_DA_TERRA("Territórios vastos e estáveis, sustentados pela firmeza da terra.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            // Resistência extra simbolizando a solidez do solo
            heroi.receberCura(3);
            System.out.println("A solidez da terra dá determinação ao herói!");
        }
    },
    NACAO_DO_FOGO("Campos ardentes e vulcões ativos, onde a chama nunca se apaga.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O calor intenso da Nação do Fogo pressiona o herói!");
        }
    },
    NOMADES_DO_AR("Templos suspensos nas montanhas, banhados pelo vento da liberdade.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            // O ar leve recupera um pouco da energia
            heroi.receberCura(2);
            System.out.println("A leveza do ar inspira movimentos mais ágeis!");
        }
    };

    private final String descricao;
    TipoCenario(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
    public abstract void aplicarEfeitos(Heroi heroi);
    @Override
    public String toString() {
        return this.name().replace('_', ' ');
    }
}