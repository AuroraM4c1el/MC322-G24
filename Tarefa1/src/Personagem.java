public abstract class Personagem {
    private String nome;
    private int pontosDeVida;
    private int forca;

    public Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Força: " + forca);
    }

    public abstract void atacar(Personagem alvo);
}