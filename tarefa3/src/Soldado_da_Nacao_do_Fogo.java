class Soldado_da_Nacao_do_Fogo extends Monstro {


    public Soldado_da_Nacao_do_Fogo(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, xpConcedido, arma);
        acoes.add(new AtaqueFisico());
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano((int) (getForca() * 0.7));
    }

    @Override
    public Item droparLoot() {
        return new Adaga_Carbonizada(15, 1);
    }

}