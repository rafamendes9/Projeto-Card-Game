package CardGame;

import java.util.ArrayList;

public abstract class Progresso {
    private ArrayList<String> premiacoes; // Lista de premiações
    private int premiacaoAtual; // Contador de premiações

    public Progresso() {
        this.premiacoes = new ArrayList<>();
        this.premiacaoAtual = 0;
    }

    // Método abstrato para entregar uma premiação
    public abstract void entregarPremiacao();

    // Método abstrato para fazer progresso no passe
    public abstract void progresso();

    // Método para verificar se o próximo nível é um múltiplo de 5
    protected boolean isProximoNivelMultiploDe5() {
        return (premiacaoAtual + 1) % 5 == 0;
    }

    // Método para adicionar uma premiação ao passe
    protected void adicionarPremiacao(String premiacao) {
        premiacoes.add(premiacao);
        premiacaoAtual++;
    }

    // Método para obter o índice da premiação atual
    protected int getPremiacaoAtual() {
        return premiacaoAtual;
    }
}
