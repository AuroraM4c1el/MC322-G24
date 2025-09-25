public abstract class Personagem implements Combatente {
    private String nome;
    private int pontosDeVida;
    private int forca;
    Arma arma;

    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void updatePontosDeVida(int newPontosDeVida) {
        this.pontosDeVida = newPontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public void updateForca(int newForca) {
        this.forca = newForca;
    }

    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) {
            pontosDeVida = 0;
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void receberCura(int cura) {
        pontosDeVida += cura;
        System.out.println(nome + " recebeu " + cura + " pontos de cura.");
    }

    public boolean estaVivo(){ 
        return pontosDeVida > 0 ; 
    }

    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    public void exibirStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontos de Vida: " + pontosDeVida);
        System.out.println("Força: " + forca);
    }

    public abstract void atacar(Personagem alvo);
}