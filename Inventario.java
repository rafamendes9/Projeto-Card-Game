import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private static List<Carta> cartas;
    private static int nivel;
    private static int cardcoins;

    public Inventario() {
        Inventario.cartas = new ArrayList<>();
        Inventario.nivel = 1;
        Inventario.cardcoins = 0;
    }

    public List<Carta> getCartas(){
        return cartas;
    }

    public void setCartas(List<Carta> cartas){
        Inventario.cartas = cartas;
    }

    public static int getNivel(){
        return nivel;
    }

    public void setNivel(int nivel){
        Inventario.nivel = nivel;
    }

    public int getCardcoins(){
        return cardcoins;
    }

    public void setCardcoins(int cardcoins){
        Inventario.cardcoins = cardcoins;
    }

    // Método para adicionar uma carta ao inventário
    public void adicionarCarta(Carta carta) {
        if (carta != null) {
            if (carta.estaDisponivel()) {
                cartas.add(carta);
                carta.aumentarQuantidade();
            } else {
                // O jogador ganha cardcoins em vez da carta.
                cardcoins += 10; // Suponhamos que 10 cardcoins sejam ganhos.
            }
        }
    }
}
