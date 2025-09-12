public class Planador extends Arma {

    public Planador(int dano, int minNivel) {
        super(dano, minNivel);
    }

    public void atacar() {
        // Implementação específica do ataque do Planador
        System.out.println("Planador ataca deslizando pelo ar!");
    }
}