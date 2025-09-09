class Fase {
    int nivel;
    String ambiante;
    Monstro[] monstros;

    public Fase(int nivel, String ambiente, Monstro[] monstros) {
        this.nivel = nivel;
        this.ambiante = ambiente;
        this.monstros = monstros;
    }
}