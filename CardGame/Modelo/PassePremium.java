package Modelo;

public class PassePremium extends Progresso{
    
    @Override
    public void entregarPremiacao(A_Usuario jogador) {
        // Entrega um booster especial para níveis múltiplos de 7    
        System.out.println("Nível múltiplo de 7. Entregando booster especial.");
        packCardCoins(jogador);
        packCardGems(jogador);
        ganhoDeXP(jogador);
        adicionarBoostMana(jogador);
        progresso(jogador);
    }

    @Override
    public void progresso(A_Usuario jogador) {
        // Incrementa o progresso (nível) do passe premium
        // Ganhar uma partida representa um passe ganho
        // O usuário avança um nível em cada vitória
        setPremiacaoAtual(getPremiacaoAtual() + 1);
        System.out.println("Ganhou uma partida. Avançou um nível.");
    }

    public void packCardCoins(A_Usuario jogador){
        // Adicionar um valor específico de coins ao jogador
        jogador.setCardCoins(3000 + jogador.getCardCoins()); // Exemplo: adiciona 1000 coins
    }

    public void packCardGems(A_Usuario jogador){
        // Adicionar um valor específico de gemas ao jogador
        jogador.setCardGems(30 + jogador.getCardGems()); // Exemplo: adiciona 10 gemas
    }

    public void ganhoDeXP(A_Usuario jogador){
        // Adicionar um valor específico de experiência ao jogador
        jogador.setNivel(600 + jogador.getNivel()); // Exemplo: adiciona 200xp
    }

    public void adicionarBoostMana(A_Usuario jogador) {
        // Adicionar um valor específico de mana ao jogador
        jogador.setManaDoJogador(jogador.getManaDoJogador() + 15); // Exemplo: adiciona 5 de mana
    }
}
