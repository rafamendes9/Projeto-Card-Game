package CardGame;

public abstract class Progresso {
    int premiacaoAtual;
    String premiacoes[] = new String[60];

    public abstract void progresso();
    public abstract void entregarPremiacoes();
}
