abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;

    Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    void ganharExperiencia(int xp) {
        experiencia += xp;
    }

    @Override
    void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + nivel);
        System.out.println("Experiência: " + experiencia);
    }

    abstract void usarHabilidadeEspecial();
}
