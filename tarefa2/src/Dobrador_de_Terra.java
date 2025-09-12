public class Dobrador_de_Terra extends Heroi {

    private int determinacao;

    public Dobrador_de_Terra(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int determinacao,  Arma arma, int expProximoNivel, float sorte) {
        super(nome, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.determinacao = determinacao;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] Monstros) {
        System.out.println(getNome() + " usou a habilidade especial: Terremoto!");
        for (Personagem monstro : Monstros) {
            monstro.receberDano(calcularDano(true));
        }
    }

    private int calcularDano(boolean especial) {
        double dano_base = (Math.pow(getNivel(), 2) + getForca());
        if (especial) {
            dano_base = dano_base + 0.65 * determinacao + 0.03 * getNivel() * determinacao;
        }
        int dano = (int) Math.round(dano_base);
        return dano;
    }

    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano(calcularDano(false));
    }

}
