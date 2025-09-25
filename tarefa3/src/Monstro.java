import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel {
    private int xpConcedido;
    List<Arma> listaDeArmasParaLargar = new ArrayList<>();
    public final List<AcaoDeCombate> acoes = new ArrayList<>();
    private final Random rng = new Random(7);

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

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // IA simples: escolhe aleatoriamente uma ação disponível
        return acoes.get(rng.nextInt(acoes.size()));
    }

    @Override
    public abstract Item droparLoot();
}

