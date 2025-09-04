public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
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
}
