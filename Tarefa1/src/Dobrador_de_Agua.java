public class Dobrador_de_Agua extends Heroi {

    private int calma;

    public Dobrador_de_Agua(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int calma) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
        this.calma = calma;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem[] Monstros) {
        System.out.println(getNome() + " usou a habilidade especial: Onda Devastadora!");
        for (Personagem monstro : Monstros) {
            monstro.receberDano(calcularDano(true));
        }
    }

    private int calcularDano(boolean especial) {
        double dano_base = (Math.pow(getNivel(), 2) + getForca());
        if (especial) {
            dano_base = dano_base*(1 + calma / 120.0) + 0.1* Math.sqrt(getForca() * calma);
        }
        int dano = (int) Math.round(dano_base);
        return dano;
    }

    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " atacou " + alvo.getNome() + "!");
        alvo.receberDano(calcularDano(false));
    }

}
