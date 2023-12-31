package Model.Cards.Inventory;

import Model.Cards.C2_CartaShiny;
import Model.Cards.C_Carta;
import Model.USER.A_Usuario;

public class B_Inventario {
    private C_Carta[] cartas; // Alterado o tipo String para C_Carta , inicialmente com 360 espaços( o jogador mais ter mais cartas + cartas reservas para cada deck) + fução para aumentar o espaço
    private int nivelAtual = 1;
    private int cardCoins = 0;


    
    public B_Inventario(C_Carta[] cartas, int nivelAtual, int cardCoins) {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual ;
        this.cardCoins = cardCoins ;
        cartas = new C_Carta[360];
    }

 

    // Método para adicionar uma carta ao inventário
     /*Este método verifica se a nova carta não é nula, se o inventário não está cheio e, em seguida,
     adiciona a nova carta ao inventário na próxima posição disponível. 
     chama um IF para verificar se tem carta repitida
     */
    //metodo usado em E_Loja
    public boolean adicionarCarta(C_Carta novaCarta) {
        if (novaCarta != null) {
            // Encontre uma posição vazia no inventário
            for (int i = 0; i < cartas.length; i++) {

                if (cartas[i] == null) {
                   
                   if(possuiMaximoCarta(novaCarta)){
                        // Adicione nova carta à posição disponível
                        cartas[i] = novaCarta;
                        return true;
                   }
                }
            }
            // O inventário cheio, não é possível adicionar mais cartas
            return false;
        }
        return false;
    }

    // Método para adicionar uma carta shiny ao inventário ( sem restrição de carta normal)
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

   //metodo usado para apagar carta definitiva do inventario ( ainda não implementado por falta da class interface) 
   //metodo ao apagar retorna um valor em dinheiro para o usuario
    public C_Carta apagarCarta(String nome, A_Usuario usuario) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null && cartas[i].getNome().equals(nome)) {
                C_Carta cartaRemovida = cartas[i];
                cartaRemovida = null;
                
                // Compacta o vetor após a remoção ( tira espaços vazios )
                for (int j = i; j < cartas.length - 1; j++) {
                    cartas[j] = cartas[j + 1];
                }
                cartas[cartas.length - 1] = null; // Define o último elemento como null
                
                // Adiciona valor em cardcoins ao usuário
                int valorCardcoins = 10; // Define o valor a ser adicionado em cardcoins
                usuario.setCardCoins(usuario.getCardGems() + valorCardcoins);

                return cartaRemovida;
            }
        }
        return null;  // Carta não encontrada
    }
    

    // Método para aumentar o tamanho do vetor 
    public void aumentarTamanhoDoVetor(int novoTamanho) {
        int tamanhoAtual = cartas.length; // Obtem o tamanho atual do vetor

        if (novoTamanho > tamanhoAtual) {
            int tamanhoDesejado = tamanhoAtual + novoTamanho; // Calcula o tamanho desejado ( no caso +30)
            C_Carta[] novoVetor = new C_Carta[tamanhoDesejado]; // Cria novo vetor com o tamanho desejado
    
            // Copia os elementos do vetor original para o novo vetor
            for (int i = 0; i < tamanhoAtual; i++) {
                novoVetor[i] = cartas[i];
            }
    
            cartas = novoVetor; // Atualiza a referência para o novo vetor
        }
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
}