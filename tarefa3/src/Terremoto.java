public class Terremoto implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoCausado = calcularDano((Dobrador_de_Terra) usuario);
        System.out.println(usuario.getNome() + " usa Terremoto em " + alvo.getNome() + " causando " + danoCausado + " de dano!");
        alvo.receberDano(danoCausado);
    }
    
    private int calcularDano(Dobrador_de_Terra heroi) {
        double dano_base = (Math.pow(heroi.getNivel(), 2) + heroi.getForca());
        dano_base = dano_base + 0.65 * heroi.getDeterminacao() + 0.03 * heroi.getNivel() * heroi.getDeterminacao();
        int dano = (int) Math.round(dano_base);
        return dano;
    }
}





