public class B_Inventario {
    private String[] cartas = new String[200];
    private int nivel;
    private int cardcoins;

    public B_Inventario(String[] cartas, int nivel, int cardcoins) {
        this.cartas = cartas;
        this.nivel = 1;
        this.cardcoins = 0;
    }

    public String[] getCartas() {
        return cartas;
    }
    public void setCartas(String[] cartas) {
        this.cartas = cartas;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCardcoins() {
        return cardcoins;
    }
    public void setCardcoins(int cardcoins) {
        this.cardcoins = cardcoins;
    }

    

    //MÉTODO PARA 2ª ENTREGA
    // Método para adicionar uma carta ao inventário
    /*public boolean adicionarCarta(Carta carta) {
        if (carta != null) {
            if (carta.estaDisponivel()) {
                for(int i = 0; i < cartas.length; i++){
                    //adicionar cartas ao inventário
                }
                return true;
            } else {
                // O jogador ganha cardcoins em vez da carta.
                cardcoins += 10; // Suponhamos que 10 cardcoins sejam ganhos.
            }
        }
        return false;
    }*/
}
