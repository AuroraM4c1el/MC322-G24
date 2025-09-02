abstract class Personagem{
    String nome;
    int pontosDeVida;
    int forca;

    Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    String getNome() {
        return nome;
    }

    int getForca() {
        return forca;
    }

    void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Força: " + forca);
    }

    abstract void atacar(Personagem alvo);
}