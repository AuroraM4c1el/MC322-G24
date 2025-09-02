abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;

    public Heroi(int nivel, int experiencia) {
        super();
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void ganharExperiencia(int xp) {
        experiencia += xp;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + nivel);
        System.out.println("Experiência: " + experiencia);
    }

    public abstract void usarHabilidadeEspecial();
}
