abstract class Monstro extends Personagem {
    private int xpConcedido;

    Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    @Override
    void exibirStatus() {
        super.exibirStatus();
        System.out.println("XP Concedido: " + xpConcedido);
    }
}

