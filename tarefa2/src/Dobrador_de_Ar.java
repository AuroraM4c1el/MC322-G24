class Dobrador_de_Ar extends Heroi {

    private int liberdade;

    Dobrador_de_Ar(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int liberdade, Arma arma, int expProximoNivel, float sorte) {
        super(nome, pontosDeVida, forca, nivel, experiencia, arma, expProximoNivel, sorte);
        this.liberdade = liberdade;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] Monstros) {
        System.out.println(getNome() + " usou a habilidade especial: Furacão!");
        for (Personagem monstro : Monstros) {
            monstro.receberDano(calcularDano(true));
        }
    }

    private int calcularDano(boolean especial) {
        double dano_base = (Math.pow(getNivel(), 2.05) + getForca());
        if (especial) {
            dano_base = (1 + liberdade / 190.0);
        }
        int dano = (int) Math.round(dano_base);
        return dano;
    }

    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano(calcularDano(false));
    }

}
