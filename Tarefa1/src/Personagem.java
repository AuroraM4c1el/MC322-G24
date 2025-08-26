abstract class Personagem{
    String nome;
    int pontosDeVida;
    int forca;

    public Personagem(String nome, int forca, int pontosDeVida){
        super();
        this.nome = nome;
        this.forca = forca;
        this.pontosDeVida = pontosDeVida;

    }

    void receberDano() {
        this.pontosDeVida -= 10;
    }

    void exibirStatus() {
        System.out.println(this.pontosDeVida);
    }

    public abstract void atacar(Personagem alvo);
}