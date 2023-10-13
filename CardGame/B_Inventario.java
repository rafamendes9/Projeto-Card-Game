package CardGame;
public class B_Inventario {
    private C_Carta[] cartas = new C_Carta[360]; // Alterado o tipo String para C_Carta , usado para o metodo adicionarCarta / alterado de 200 para 360 ( o jogador mais ter mais cartas + cartas reservas para cada deck)
    private int nivelAtual = 1;
    private int cardCoins = 0;


    
    public B_Inventario(C_Carta[] cartas, int nivelAtual, int cardCoins) {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual ;
        this.cardCoins = cardCoins ;
    }

 

    // Método para adicionar uma carta ao inventário
     /*Este método verifica se a nova carta não é nula, se o inventário não está cheio e, em seguida,
     adiciona a nova carta ao inventário na próxima posição disponível. 
     */
    //metodo usado em E_Loja
    public boolean adicionarCarta(C_Carta novaCarta) {
        if (novaCarta != null) {
            // Encontre uma posição vazia no inventário
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] == null) {
                    // Adicione nova carta à posição disponível
                    cartas[i] = novaCarta;
                    return true;
                }
            }
            // O inventário cheio, não é possível adicionar mais cartas
            return false;
        }
        return false;
    }

    // !!!!!!!!!!!!!!!!!!!!!!! EDITAR PARA ACEITAR CARTA REPITIDA DO TIPO "shiny" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //resolvido no metodo abaixo
    
    //metodo verifica se o inventário já possui 3 unidades da mesma carta com base no nome da carta.
    //percorre o array de cartas no inventário e conta quantas vezes a carta com o mesmo nome é encontrada
    //Se o contador for maior ou igual a 3, significa que o inventário possui o máximo permitido daquela carta, e o método retorna (true)
    //metodo usado em E_Loja.
    public boolean possuiMaximoCarta(C_Carta carta) {
        int contador = 0;
        for (C_Carta cartaNoInventario : cartas) {
            if (cartaNoInventario != null && cartaNoInventario.getNome().equals(carta.getNome())) {
                contador++;
                if (contador >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public C_Carta apagarCarta(String nome) {
        // Lógica para apagar a carta do inventário
        // Você pode remover a carta com o nome especificado e retorná-la
        // ou simplesmente marcá-la como null no array de cartas e retornar.
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null && cartas[i].getNome().equals(nome)) {
                C_Carta cartaRemovida = cartas[i];
                cartas[i] = null;  // Marcar a carta como removida
                return cartaRemovida;
            }
        }
        return null;  // Carta não encontrada
    }
    
    //GET SET

       public C_Carta[] getCartas() {
        return cartas;
    }
    public void setCartas(C_Carta[] cartas) {
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





//espaço para novos metodo de desenvolvimento 2 entrega !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



public void adicionarCartaShiny(C2_CartaShiny novaCartaShiny) {
    if (novaCartaShiny != null) {
        // Encontre uma posição vazia no inventário
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] == null) {
                // Adicione a nova carta "shiny" à posição disponível
                cartas[i] = novaCartaShiny;
                break; // Sai do loop após adicionar a carta
            }
        }
    }
}


}
