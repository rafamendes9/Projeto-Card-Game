package CardGame;

public class I_Premiacoes {
    public void packCardCoins(A_Usuario jogador){
        // Adicionar um valor específico de coins ao jogador
        jogador.setCardCoins(1000 + jogador.getCardCoins()); // Exemplo: adiciona 1000 coins
    }

    public void packCardGems(A_Usuario jogador){
        // Adicionar um valor específico de gemas ao jogador
        jogador.setCardGems(10 + jogador.getCardGems()); // Exemplo: adiciona 10 gemas
    }

    public void ganhoDeXP(A_Usuario jogador){
        // Adicionar um valor específico de experiência ao jogador
        jogador.setNivel(200 + jogador.getNivel()); // Exemplo: adiciona 200xp
    }

    public void adicionarBoostMana(A_Usuario jogador) {
        // Adicionar um valor específico de mana ao jogador
        jogador.setManaDoJogador(jogador.getManaDoJogador() + 5); // Exemplo: adiciona 5 de mana
    }

    public void packComum(A_Usuario jogador){
        packCardCoins(jogador);
        packCardGems(jogador);
        ganhoDeXP(jogador);
        adicionarBoostMana(jogador);
    }
}
