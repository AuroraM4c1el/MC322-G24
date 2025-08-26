public class Monstro extends Personagem {
    int xpConcedido;

    public Monstro(String nome, int forca, int pontosDeVida, int xpConcedido) {
        super(nome, forca, pontosDeVida);
        this.xpConcedido = xpConcedido;
    }

    @Override
    void receberDano() {
        super.receberDano();
        // fazer lógica
    }

    @Override
    void exibirStatus() {
        super.exibirStatus();
    }

    

    

}