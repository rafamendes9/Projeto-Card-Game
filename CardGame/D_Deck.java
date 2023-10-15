package CardGame;
import java.util.Random;

public class D_Deck {
    private String nome;
    private int qtdCartas;
    private boolean disponibilidade = false;
    private C_Carta[] cartas = new C_Carta[60];

    public D_Deck(String nome, int qtdCartas, boolean disponibilidade, C_Carta[] cartas) {
        this.nome = nome;
        this.qtdCartas = qtdCartas;
        this.disponibilidade = disponibilidade;
        this.cartas = cartas;
    }
    
    // metodo recebe carta que vai ser adicionada de  inventario 
    public void addCarta(C_Carta carta, B_Inventario inventario) { 
        // verifica se o deck estourou o limite e se a carta estiver sendo repetida 3 vezes
        // Limite definido como 60 cartas
        if (qtdCartas < 60 && !maximasRepeticoes(carta)) {
            cartas[qtdCartas] = carta;
            qtdCartas++;
        }
        isDeckDisponivel(); //atualiza a diponibilidade da carta com o acréscimo de uma nova
    }
    //metodo usado em addCarta + valida maximo de cartas no deck
    public void isDeckDisponivel() { 
        if (qtdCartas < 60 ) {
            disponibilidade = false;
        } else {
            disponibilidade = true;
        }
    }


    // metodo para verificar se o deck( baralho)se repete mais de 3 vezes
    public boolean maximasRepeticoes(C_Carta carta) {
        if (carta.getNome().equals("mana")) {
            return false; 
        }
        int contador = 0;
        for (int i = 0; i < qtdCartas; i++) { // compara carta recebida com as outras que já estão no vetor
            contador++;
            if (contador >= 3) {
                return true;
            }
        }
        return false;
    }

    // metodo usado em ARENA , mistura as cartas
    public void embaralhar() {
        Random rand = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            C_Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    //metodo para remover carta do deck ( baralho ) e retorna para inventario
    public void removerCarta(String nome, B_Inventario inventario) {
        // Encontre a carta no deck pelo nome
        for (int i = 0; i < qtdCartas; i++) {
            if (cartas[i] != null && cartas[i].getNome().equals(nome)) {
                C_Carta cartaRemovida = cartas[i];
                cartas[i] = null;  // Marcar a carta como removida do deck
                inventario.adicionarCarta(cartaRemovida);  // Adicionar a carta ao inventário
                qtdCartas--;
                return;  // Carta removida com sucesso
            }
        }
        System.out.println("Carta não encontrada no deck: " + nome);
    }

    // get set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCartas() {
        return qtdCartas;
    }

    public void setQtdCartas(int qtdCartas) {
        this.qtdCartas = qtdCartas;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public C_Carta[] getCartas() {
        return cartas;
    }

    public void setCarta(C_Carta[] cartas) {
        this.cartas = cartas;
    }

 

}
