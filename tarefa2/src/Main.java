import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Criar herói único do cenário
        Random rand = new Random();

        // Gera um valor aleatório entre 0.0 e 1.0
        float sorteAleatoria = rand.nextFloat();

        // Cria o herói com o último parâmetro aleatório
        Heroi heroi = new Dobrador_de_Ar(
            "Aang", 
            90, 
            20, 
            5, 
            0, 
            30, 
            new Planador(15, 2), 
            50, 
            sorteAleatoria
        );

        // Gerar 3 fases usando método estático (substitua ConstrutorDeCenario pelo nome da sua classe)
        List<Fase> fases = ConstrutorDeCenario.gerarFases(3);

        System.out.println("=== O HERÓI ENTRA NO DESAFIO DE SOBREVIVÊNCIA! ===");
        System.out.println("Um mestre da terra deve enfrentar todas as fases...\n");
        System.out.println("-- STATUS INICIAL DO HERÓI --");
        heroi.exibirStatus();

        // Loop por cada fase
        for (int faseIndex = 0; faseIndex < fases.size(); faseIndex++) {
            Fase faseAtual = fases.get(faseIndex);

            System.out.println("\n===== INÍCIO DA FASE " + faseAtual.getNivel() + " - " + faseAtual.getAmbiente() + " =====");
            System.out.println("O HERÓI ENTRA NA " + faseAtual.getAmbiente() + " PARA ENFRENTAR " + faseAtual.getMonstros().length + " MONSTROS!");
            heroi.exibirStatus();

            // Loop por cada monstro da fase
            for (Monstro monstro : faseAtual.getMonstros()) {
                System.out.println("\nSurge o inimigo: " + monstro.getNome());

                // Combate enquanto ambos estiverem vivos
                while (heroi.getPontosDeVida() > 0 && monstro.getPontosDeVida() > 0) {
                    // Herói ataca primeiro
                    heroi.atacar(monstro);

                    if (monstro.getPontosDeVida() <= 0) {
                        System.out.println(monstro.getNome() + " foi derrotado!");

                        heroi.ganharExperiencia(monstro.getXpConcedido());

                        // Testa a sorte do herói para largar/pegar arma
                        if ( heroi.getSorte() > 0.5 ) { // sorte maior que 50%
                            System.out.println("O herói encontrou uma arma largada pelo monstro!");
                            
                            heroi.equiparArma(monstro.largaArma());
                        }

                        break; // passa para o próximo monstro
                    } else {
                        // Monstro contra-ataca
                        monstro.atacar(heroi);
                    }

                    // Verifica se herói foi derrotado
                    if (heroi.getPontosDeVida() <= 0) {
                        System.out.println("\n*** GAME OVER: o herói tombou na fase " + faseAtual.getNivel() + ". ***");
                        return;
                    }
                }

                // Status após cada monstro
                System.out.println("\n-- STATUS AO FINAL DO COMBATE --");
                heroi.exibirStatus();
                monstro.exibirStatus();
            }

            System.out.println("===== FIM DA FASE " + faseAtual.getNivel() + " =====\n");
        }

        // Se sobreviveu a todas as fases
        System.out.println("\n*** VITÓRIA! O herói sobreviveu a todas as fases! ***");
    }
}