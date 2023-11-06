package CardGame;

public class PasseComum extends Progresso{
    
    @Override
    public void entregarPremiacao() {
        // Entrega um booster comum
        // Isso pode incluir a lógica para abrir o booster
        System.out.println("Entregando booster comum.");
    }

    @Override
    public void progresso() {
        // Incrementa o progresso (nível) do passe comum
        // Ganhar uma partida representa um nível ganho
        // O usuário avança um nível em cada vitória
        entregarPremiacao();
        System.out.println("Ganhou uma partida. Avançou um nível.");
    }
}