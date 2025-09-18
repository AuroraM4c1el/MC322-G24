class Zuko extends Monstro {


    public Zuko(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano((int) (getForca() * 0.7));
    }

}