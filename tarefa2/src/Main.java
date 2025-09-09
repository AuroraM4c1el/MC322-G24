public class Main {
    public static void main(String[] args) {
        // Herói único do cenário (use valores que façam sentido no seu balanceamento)
        Heroi heroi = new Dobrador_de_Terra("Toph", 90, 20, 5, 0, 30);

        // Três monstros diferentes (exemplos; ajuste aos nomes/classes do seu projeto)
        Monstro[] monstros = new Monstro[] {
            new KohLadraoDeRostos("Koh, o Ladrão de Rostos", 100, 10, 15),
            new Zuko("Zuko", 150, 15, 20),
            new OzaiSenhorDoFogo("Ozai", 200, 12, 30)
        };

        System.out.println("=== O HERÓI ENTRA NA MASMORRA PARA ENFRENTAR TRÊS DESAFIOS! ===");
        System.out.println("Um mestre da terra busca sobreviver a três encontros consecutivos...\n");
        System.out.println("-- STATUS INICIAL DO HERÓI --");
        heroi.exibirStatus();

        // Loop de 3 turnos (um por monstro)
        for (int turno = 0; turno < monstros.length; turno++) {
            Monstro atual = monstros[turno];
            System.out.println("\n===== INÍCIO DO TURNO " + (turno + 1) + " =====");
            System.out.println("Surge o inimigo: " + atual.getNome());

            while(atual.getPontosDeVida() > 0 && heroi.getPontosDeVida() > 0){

                // Herói ataca primeiro
                heroi.atacar(atual);

                // Se o monstro morreu, concede XP e segue
                if (atual.getPontosDeVida() <= 0) {
                    System.out.println(atual.getNome() + " foi derrotado!");
                    heroi.ganharExperiencia(atual.getXpConcedido());
                } else {
                    // Monstro contra-ataca
                    atual.atacar(heroi);
                }

                // Verifica sobrevivência do herói
                if (heroi.getPontosDeVida() <= 0) {
                    System.out.println("\n*** GAME OVER: o herói tombou no turno " + (turno + 1) + ". ***");
                    break;
                }
            }

            // Status ao final do turno
            System.out.println("\n-- STATUS AO FINAL DO TURNO " + (turno + 1) + " --");
            heroi.exibirStatus();
            atual.exibirStatus();
            System.out.println("===== FIM DO TURNO " + (turno + 1) + " =====");
        }

        // Vitória se ainda estiver vivo após os 3 turnos
        if (heroi.getPontosDeVida() > 0) {
            System.out.println("\n*** VITÓRIA! O herói sobreviveu aos três desafios. ***");
        }
    }
}
