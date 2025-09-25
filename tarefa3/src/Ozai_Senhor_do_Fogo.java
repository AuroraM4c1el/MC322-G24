

class Ozai_Senhor_do_Fogo extends Monstro{
    public Ozai_Senhor_do_Fogo(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
        acoes.add(new AtaqueFisico());
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano((int) (getForca() * 0.8));
    }

    @Override
    public Item droparLoot() {
        return new Cetro(70, 10);
    }

    
}