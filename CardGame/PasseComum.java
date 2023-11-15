package CardGame;
public class PasseComum extends Progresso{
    
    @Override
    public void entregarPremiacao(A_Usuario jogador) {
        // Entrega um booster comum
        System.out.println("Entregando booster comum.");
        packCardCoins(jogador);
        packCardGems(jogador);
        ganhoDeXP(jogador);
        adicionarBoostMana(jogador);
        progresso(jogador);
    }

    @Override
    public void progresso(A_Usuario jogador) {
        // Incrementa o progresso (nível) do passe comum
        // Ganhar uma partida representa um passe ganho
        // O usuário avança um nível em cada vitória
        setPremiacaoAtual(getPremiacaoAtual() + 1);
        System.out.println("Ganhou uma partida. Avançou um nível.");
    }

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
}