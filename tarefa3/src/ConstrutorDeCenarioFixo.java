import java.util.List;
import java.util.ArrayList;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    @Override
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> fases = new ArrayList<>();
        TipoCenario[] tipos = {TipoCenario.TRIBO_DA_AGUA, TipoCenario.NOMADES_DO_AR, TipoCenario.REINO_DA_TERRA};

        for (int i = 0; i < quantidadeDeFases; i++) {
            Monstro[] monstros = criarMonstrosParaFase(fases.size() + 1);
            FaseDeCombate fase = new FaseDeCombate(i + 1, tipos[fases.size()], monstros);
            fases.add(fase);
        }
        
        return fases;
    }

    private Monstro[] criarMonstrosParaFase(int nivel) {
        Monstro[] lista = new Monstro[3];
        switch (nivel) {
            case 1:
                lista[0] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", 150, 15, 20, new Adaga_Carbonizada(10, 5));
                lista[1] = new Koh_Ladrao_de_Rostos("Koh, o Ladrão de Rostos", 100, 10, 30, new Mascara(10, 5));
                break;
            case 2:
                lista[0] = new Ozai_Senhor_do_Fogo("Ozai", 200, 20, 30, new Cetro(10, 5));
                lista[1] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", 150, 15, 25, new Adaga_Carbonizada(10, 5));
                break;
            default:
                lista[0] = new Koh_Ladrao_de_Rostos("Koh, o Ladrão de Rostos", 120 + nivel*10, 12 + nivel, 20 + nivel*5, new Mascara(10, 5));
                lista[1] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", 170 + nivel*10, 18 + nivel, 25 + nivel*5, new Adaga_Carbonizada(10, 5));
                lista[2] = new Ozai_Senhor_do_Fogo("Ozai", 220 + nivel*10, 22 + nivel, 35 + nivel*5, new Cetro(10, 5));
                break;
        }
        return lista;

    }
    
}
