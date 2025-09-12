public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    int expProximoNivel;
    float sorte;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia, Arma arma, int expProximoNivel, float sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    public void ganharExperiencia(int xp) {
        experiencia += xp;
        if (experiencia >= Math.pow(2, nivel)) {
            nivel++;
            System.out.println(getNome() + " subiu para o nível " + nivel + "!");
        }
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + nivel);
        System.out.println("Experiência: " + experiencia);
    }

    public abstract void usarHabilidadeEspecial(Personagem[] Monstros);

    private void subirDeNivel() {
        nivel++;
        expProximoNivel = expProximoNivel * 2;
        System.out.println(getNome() + " subiu para o nível " + nivel + "!");

        // Aumenta a força do herói ao subir de nível
        int novaForca = getForca() + 5;
        updateForca(novaForca);

        // Restaura os pontos de vida ao subir de nível
        int novosPontosDeVida = getPontosDeVida() + 10;
        updatePontosDeVida(novosPontosDeVida);

    }

    float getSorte() {
        return sorte;
    }

    public void equiparArma(Arma novaArma) {
        arma = novaArma;
    }
}
