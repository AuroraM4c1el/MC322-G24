import java.util.ArrayList;
import java.util.List;

public abstract class Monstro extends Personagem {
    private int xpConcedido;
    List<Arma> listaDeArmasParaLargar = new ArrayList<>();

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("XP Concedido: " + xpConcedido);
    }

    public int getXpConcedido() {
        return xpConcedido;
    }

    public Arma largaArma() {
        if (!listaDeArmasParaLargar.isEmpty()) {
            int idx = (int) (Math.random() * listaDeArmasParaLargar.size());
            return listaDeArmasParaLargar.get(idx);
        }
        return null;
    }
}

