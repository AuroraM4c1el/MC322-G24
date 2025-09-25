public class Cetro extends Arma {

    public Cetro(int dano, int minNivel) {
        super(dano, minNivel);
    }

    public void atacar() {
        // Implementação específica do ataque do Cetro
        System.out.println("Cetro queima com o poder da Nação do Fogo!");
    }

    @Override
    public String getNome() {
        return "Cetro de Ozai";
    }
}
