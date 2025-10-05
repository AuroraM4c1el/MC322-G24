package com.rpg.combates;

import com.rpg.personagens.Personagem;

public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = ((Personagem)usuario).getForca();
        System.out.println(usuario.getNome() + " desfere ataque físico em " + alvo.getNome() + " (" + dano + ").");
        alvo.receberDano(dano);
    }
}