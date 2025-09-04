class OzaiSenhorDoFogo extends Monstro{
    public OzaiSenhorDoFogo(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano(10);
    }
}