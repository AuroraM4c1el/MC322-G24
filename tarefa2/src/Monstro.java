public abstract class Monstro extends Personagem {
    private int xpConcedido;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("XP Concedido: " + xpConcedido);
    }

    public int getXpConcedido() {
        return xpConcedido;
    }
}

