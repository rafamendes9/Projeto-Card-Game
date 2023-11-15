package CardGame;

public abstract class Progresso {
    private int premiacaoAtual; // Contador de premiações

    public Progresso() {
        this.premiacaoAtual = 0;
    }

    // Método abstrato para entregar uma premiação
    public abstract void entregarPremiacao(A_Usuario jogador);

    // Método abstrato para fazer progresso no passe
    public abstract void progresso(A_Usuario jogador);
    
    // Método para obter o índice da premiação atual
    protected int getPremiacaoAtual() {
        return premiacaoAtual;
    }
    public void setPremiacaoAtual(int premiacaoAtual) {
        this.premiacaoAtual = premiacaoAtual;
    }
}