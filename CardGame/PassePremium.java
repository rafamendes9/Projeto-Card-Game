package CardGame;

public class PassePremium extends Progresso{
    
    @Override
    public void entregarPremiacao() {
        // Entrega um booster comum para níveis não múltiplos de 5
        // Entrega um booster especial para níveis múltiplos de 5
        // Isso pode incluir a lógica para abrir os boosters
        int nivelAtual = getPremiacaoAtual() + 1; // Nível atual (1-60)
        
        if (nivelAtual % 5 == 0) {
            System.out.println("Nível múltiplo de 5. Entregando booster especial.");
        } else {
            System.out.println("Entregando booster comum.");
        }
    }

    @Override
    public void progresso() {
        // Incrementa o progresso (nível) do passe premium
        // Ganhar uma partida representa dois níveis ganhos
        // O usuário avança dois níveis a cada vitória
        entregarPremiacao();
        System.out.println("Ganhou uma partida. Avançou dois níveis.");
    }
}
