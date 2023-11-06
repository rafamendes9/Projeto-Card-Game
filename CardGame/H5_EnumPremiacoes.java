package CardGame;

public enum H5_EnumPremiacoes {
    VAZIO("Nenhuma Premiação", 0),
    BOOSTER_COMUM("Sequência", 30),
    BOOSTER_ESPECIAL("Full House", 60);

    private final String nome;
    private final int pontos;

    H5_EnumPremiacoes(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
}
