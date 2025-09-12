
public class Fase {
    private int nivel;
    private String ambiante;
    private Monstro[] monstros;

    public Fase(int nivel, String ambiente, Monstro[] monstros) {
        this.nivel = nivel;
        this.ambiante = ambiente;
        this.monstros = monstros;
    }

    public Monstro[] getMonstros() {
        return monstros;
    }

    public int getNivel() {
        return nivel;
    }
    
    public String getAmbiente() {
        return ambiante;
    }
}