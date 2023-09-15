public class B_Inventario {
    private String[] cartas = new String[200];
    private int nivelAtual = 1;
    private int cardCoins = 0;


    
    public B_Inventario(String[] cartas, int nivelAtual, int cardCoins) {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual ;
        this.cardCoins = cardCoins ;
    }

    public String[] getCartas() {
        return cartas;
    }
    public void setCartas(String[] cartas) {
        this.cartas = cartas;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }
    public void setNivelAtual(int nivel) {
        this.nivelAtual = nivel;
    }

    public int getCardCoins() {
        return cardCoins;
    }
    public void setCardCoins(int cardcoins) {
        this.cardCoins = cardcoins;
    }

    

    //MÉTODO PARA 2ª ENTREGA
    // Método para adicionar uma carta ao inventário
     /*Este método verifica se a nova carta não é nula, se o inventário não está cheio e, em seguida,
     adiciona a nova carta ao inventário na próxima posição disponível. 
     */
    public boolean adicionarCarta(String novaCarta) {
        if (novaCarta != null) {
            // Verifique se o inventário não está cheio
            if (cartas.length < 200) {
                // Adicione a nova carta ao inventário na próxima posição disponível
                cartas[cartas.length - 1] = novaCarta;
                return true;
            } else {
                // O inventário está cheio, não é possível adicionar mais cartas
                return false;
            }
        }
        return false;
    }
   
}
