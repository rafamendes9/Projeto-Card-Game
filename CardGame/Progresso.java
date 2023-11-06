package CardGame;

import java.util.Arrays;

public abstract class Progresso {
    private H5_EnumPremiacoes[] premiacoes; // Vetor de premiações
    private int premiacaoAtual; // Premiação atual

    public Progresso() {
        this.premiacoes = new H5_EnumPremiacoes[60];
        // Inicialize o vetor de premiações com algum valor padrão
        Arrays.fill(premiacoes, H5_EnumPremiacoes.VAZIO);
        this.premiacaoAtual = 0;
    }

    public int getPremiacaoAtual(){
        return premiacaoAtual;
    }

    // Método abstrato para entregar uma premiação
    public abstract void entregarPremiacao();

    // Método abstrato para fazer progresso no passe
    public abstract void progresso();
}
