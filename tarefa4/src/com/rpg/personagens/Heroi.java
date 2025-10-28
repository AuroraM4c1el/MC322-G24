package com.rpg.personagens;

import com.rpg.combates.AcaoDeCombate;
import com.rpg.combates.Combatente;
import com.rpg.exceptions.EquipaExepetion;
import com.rpg.exceptions.HabilidadeEspecialExeption;
import com.rpg.itens.Arma;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;
    public final List<AcaoDeCombate> acoes = new ArrayList<>();
    private final Random rng = new Random(42);

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia, Arma arma, int expProximoNivel, float sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    public void ganharExperiencia(int xp) {
        experiencia += xp;
        if (experiencia >= expProximoNivel) subirDeNivel();
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Simula escolha do jogador (sem input): alterna entre ações válidas
        return acoes.get(rng.nextInt(acoes.size()));
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + nivel);
        System.out.println("Experiência: " + experiencia);
        System.out.println("Arma: " + (arma != null ? arma.getNome() : "Nenhuma"));
    }

    public abstract void usarHabilidadeEspecial(Personagem[] Monstros) throws HabilidadeEspecialExeption;

    private void subirDeNivel() {
        nivel++;
        expProximoNivel = expProximoNivel * 2;
        System.out.println(getNome() + " subiu para o nível " + nivel + "!");

        // Aumenta a força do herói ao subir de nível
        int novaForca = getForca() + 5;
        updateForca(novaForca);

        // Restaura os pontos de vida ao subir de nível
        int novosPontosDeVida = getPontosDeVida() + 20;
        updatePontosDeVida(novosPontosDeVida);

    }

    float getSorte() {
        return sorte;
    }

    public void equiparArma(Arma novaArma) throws EquipaExepetion{
        if (novaArma.getMinNivel() > this.nivel) {
            throw new EquipaExepetion("Nível insuficiente para equipar " + novaArma.getNome() + ".");
        } else if (this.arma != null && novaArma.getDano() <= this.arma.getDano()) {
            throw new EquipaExepetion("A arma " + novaArma.getNome() + " é menos poderosa que a arma atual.");
            
        }
        arma = novaArma;
        System.out.println(getNome() + " obteve: " + novaArma.getNome());
        this.updateForca(getForca() + (novaArma.getDano() - (this.arma != null ? this.arma.getDano() : 0)));
    }
}
