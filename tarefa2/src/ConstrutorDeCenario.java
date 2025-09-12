import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenario {

    /**
     * Cria nFases com dificuldade crescente
     * Cada fase recebe um ambiente e monstros diferentes
     */
    public static List<Fase> gerarFases(int nFases) {
        List<Fase> fases = new ArrayList<>();

        // Ambientes de exemplo (cíclico)
        String[] ambientes = {
            "Templo do Ar do Sul",          // Região do povo do ar
            "Vila da Água do Norte",        // Tribo da água
            "Templo do Fogo",               // Nação do fogo
            "Montanhas do Reino da Terra",  // Reino da Terra
            "Ba Sing Se"                    // Cidade icônica do Reino da Terra
        };

        for (int i = 1; i <= nFases; i++) {
            // Determina o ambiente de forma cíclica
            String ambiente = ambientes[(i - 1) % ambientes.length];

            // Cria monstros para cada fase (ajuste os valores conforme seu balanceamento)
            Monstro[] monstros;
            switch (i) {
                case 1:
                    monstros = new Monstro[] {
                        new KohLadraoDeRostos("Koh, o Ladrão de Rostos", 100, 10, 15),
                        new Zuko("Zuko", 150, 15, 20)
                    };
                    break;
                case 2:
                    monstros = new Monstro[] {
                        new Zuko("Zuko", 150, 15, 25),
                        new OzaiSenhorDoFogo("Ozai", 200, 20, 30)
                    };
                    break;
                default:
                    monstros = new Monstro[] {
                        new KohLadraoDeRostos("Koh, o Ladrão de Rostos", 120 + i*10, 12 + i, 20 + i*5),
                        new Zuko("Zuko", 170 + i*10, 18 + i, 25 + i*5),
                        new OzaiSenhorDoFogo("Ozai", 220 + i*10, 22 + i, 35 + i*5)
                    };
                    break;
            }

            // Cria a fase e adiciona à lista
            Fase fase = new Fase(i, ambiente, monstros);
            fases.add(fase);
        }

        return fases;
    }
}