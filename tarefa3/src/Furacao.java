public class Furacao implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoCausado = calcularDano((Dobrador_de_Ar) usuario);
        System.out.println(usuario.getNome() + " usa Furacão em " + alvo.getNome() + " causando " + danoCausado + " de dano!");
        alvo.receberDano(danoCausado);
    }

    private int calcularDano(Dobrador_de_Ar heroi) {
        double dano_base = (Math.pow(heroi.getNivel(), 2.05) + heroi.getForca());
        dano_base *= (1 + heroi.getLiberdade() / 190.0);
        int dano = (int) Math.round(dano_base);
        return dano;
    }
}
