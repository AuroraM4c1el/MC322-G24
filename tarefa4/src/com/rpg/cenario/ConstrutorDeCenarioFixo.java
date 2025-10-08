package com.rpg.cenario;

import com.rpg.itens.Adaga_Carbonizada;
import com.rpg.itens.Cetro;
import com.rpg.itens.Mascara;
import com.rpg.personagens.Koh_Ladrao_de_Rostos;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Ozai_Senhor_do_Fogo;
import com.rpg.personagens.Soldado_da_Nacao_do_Fogo;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {
    
    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        TipoCenario[] tipos = {TipoCenario.TRIBO_DA_AGUA, TipoCenario.NOMADES_DO_AR, TipoCenario.REINO_DA_TERRA};

        for (int i = 0; i < quantidadeDeFases; i++) {
            Monstro[] monstros = criarMonstrosParaFase(fases.size() + 1, dificuldade);
            FaseDeCombate fase = new FaseDeCombate(i + 1, tipos[fases.size()], monstros);
            fases.add(fase);
        }
        
        return fases;
    }

    private Monstro[] criarMonstrosParaFase(int nivel, Dificuldade dificuldade) {
        Monstro[] lista = new Monstro[3];
        double vidaMultiplicada = dificuldade.getMultiplicadorVida();
        double forcaMultiplicada = dificuldade.getMultiplicadorForca();
        switch (nivel) {
            case 1:
            lista[0] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", (int)(150 * vidaMultiplicada), (int)(15 * forcaMultiplicada), 20, new Adaga_Carbonizada(10, 5));
            lista[1] = new Koh_Ladrao_de_Rostos("Koh, o Ladrão de Rostos", (int)(100 * vidaMultiplicada), (int)(10 * forcaMultiplicada), 30, new Mascara(10, 5));
            break;
            case 2:
            lista[0] = new Ozai_Senhor_do_Fogo("Ozai", (int)(200 * vidaMultiplicada), (int)(20 * forcaMultiplicada), 30, new Cetro(10, 5));
            lista[1] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", (int)(150 * vidaMultiplicada), (int)(15 * forcaMultiplicada), 25, new Adaga_Carbonizada(10, 5));
            break;
            default:
            lista[0] = new Koh_Ladrao_de_Rostos("Koh, o Ladrão de Rostos", (int)((120 + nivel * 10) * vidaMultiplicada), (int)((12 + nivel) * forcaMultiplicada), 20 + nivel * 5, new Mascara(10, 5));
            lista[1] = new Soldado_da_Nacao_do_Fogo("Soldado da Nacao do Fogo", (int)((170 + nivel * 10) * vidaMultiplicada), (int)((18 + nivel) * forcaMultiplicada), 25 + nivel * 5, new Adaga_Carbonizada(10, 5));
            lista[2] = new Ozai_Senhor_do_Fogo("Ozai", (int)((220 + nivel * 10) * vidaMultiplicada), (int)((22 + nivel) * forcaMultiplicada), 35 + nivel * 5, new Cetro(10, 5));
            break;
        }
        return lista;

    }
    
}
