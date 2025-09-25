import java.util.Iterator;
import java.util.Arrays;

public class FaseDeCombate implements Fase {
    private int nivel;
    private TipoCenario ambiente;
    private Monstro[] monstros;
    private boolean concluida;

    public FaseDeCombate(int nivel, TipoCenario ambiente, Monstro[] monstros) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = monstros;
        this.concluida = false;
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Iniciando fase de combate: " + getAmbiente() + " (Nível " + nivel + ")");
        System.out.println("\n=== " + ambiente + " - " + ambiente.getDescricao() + " ===");
        ambiente.aplicarEfeitos(heroi);

        Iterator<Monstro> iterator = Arrays.asList(monstros).iterator();
        while (iterator.hasNext() && heroi.estaVivo()) {
            Monstro monstro = iterator.next();
            if (monstro == null) continue;
            System.out.println("Um " + monstro.getNome() + " aparece!");
            
            while (heroi.estaVivo() && monstro.estaVivo()) {
                AcaoDeCombate acaoHeroi = heroi.escolherAcao(monstro);
                acaoHeroi.executar(heroi, monstro);
                if (!monstro.estaVivo()) break;

                AcaoDeCombate acaoMonstro = monstro.escolherAcao(heroi);
                acaoMonstro.executar(monstro, heroi);
            }

            if (!heroi.estaVivo()) {
                System.out.println("O herói foi derrotado! Fim de jogo.");
                this.concluida = false;
                return;
            } else {
                heroi.ganharExperiencia(monstro.getXpConcedido());
                Item loot = monstro.droparLoot();
                System.out.println(heroi.getNome() + " obteve: " + loot.getNome());
                heroi.equiparArma((Arma) loot);
            }
        }

        this.concluida = true;
        System.out.println("Fase concluída! O herói sobreviveu.");
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return ambiente;
    }

    public int getNivel() {
        return nivel;
    }

    public String getAmbiente() {
        return ambiente.toString();
    }

    public Monstro[] getMonstros() {
        return monstros;
    }    
}
