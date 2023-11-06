package CardGame;

public enum H5_EnumPremiacoes {
    NENHUMA("Nenhuma Premiação", 0),
    PAR_DE_REIS("Par de Reis", 10),
    TRINCA("Trinca", 20),
    SEQUENCIA("Sequência", 30),
    QUADRA("Quadra", 40),
    QUINA("Quina", 50),
    FULL_HOUSE("Full House", 60);

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
