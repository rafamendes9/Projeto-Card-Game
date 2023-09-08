import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    // Método para compra de booster com cardcoins
    public void compraDeBooster(Inventario inventario) {
        int precoBooster = 100; // Preço do booster em cardcoins (exemplo)

        if (inventario.getCardcoins() >= precoBooster) {
            // Verifica se o usuário tem cardcoins suficientes para comprar o booster.
            inventario.setCardcoins(inventario.getCardcoins() - precoBooster); // Deduz o preço do booster dos cardcoins.

            List<Carta> booster = gerarBoosterAleatorio(); // Gera um booster com 12 cartas aleatórias.

            for (Carta carta : booster) {
                if (inventario.adicionarCarta(carta)) {
                    // A carta foi adicionada com sucesso.
                    System.out.println("Você recebeu a carta: " + carta.getNome());
                } else {
                    // O usuário já possui 3 unidades da carta, recebe cardcoins em vez da carta.
                    int valorCardcoins = 10; // Suponhamos que o valor seja 10 cardcoins (exemplo).
                    inventario.setCardcoins(inventario.getCardcoins() + valorCardcoins);
                    System.out.println("Você já possui 3 unidades da carta: " + carta.getNome() + ". Recebeu " + valorCardcoins + " cardcoins.");
                }
            }
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

    // Método de exemplo para gerar um booster aleatório com 12 cartas.
    private List<Carta> gerarBoosterAleatorio() {
        List<Carta> booster = new ArrayList<>();

        // Lógica para gerar cartas aleatórias do booster.
        // Suponhamos que estamos gerando cartas aleatórias para o exemplo.

        return booster;
    }
}
