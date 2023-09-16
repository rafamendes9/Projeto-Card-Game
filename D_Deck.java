public class D_Deck {
    private String nome;
    private int qtdCartas;
    private boolean disponibilidade = false;
    private C_Carta[] cartas = new C_Carta[60];

    public D_Deck (String nome, int qtdCartas, boolean disponibilidade, C_Carta[] cartas) {
        this.nome = nome;
        this.qtdCartas = qtdCartas;
        this.disponibilidade = disponibilidade;
        this.cartas = cartas;
    }
    
    public void addCarta(C_Carta carta, B_Inventario inventario){ //recebe carta que vai ser adicionada e o inventario para remover a quantidade na classe
        //verifica se o deck estourou o limite e se a carta estiver sendo repetida 3 vezes
        //Limite definido como 120 cartas
        if (qtdCartas < 60 && !maximasRepeticoes(carta)) {
            cartas[qtdCartas] = carta;
            qtdCartas++;
        }
        disponibilidadeCarta();
    }

    public C_Carta removerCarta(String nome){
        return null;
    }

    public boolean maximasRepeticoes(C_Carta carta){
        if(carta.getNome().equals("mana")){
            return false; //cartas de mana podem ser chamadas mais de 3 vezes
        }
        int contador = 0;
        for(int i = 0; i < qtdCartas; i++){ //compara carta recebida com as outras que já estão no vetor
            contador++;
            if(contador >= 3){
                return true;
            }
        }
        return false;
    }

    //get set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getQtdCartas(){
        return qtdCartas;
    }
    public void setQtdCartas(int qtdCartas){
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

    public void disponibilidadeCarta(){
        if(qtdCartas >= 60 && qtdCartas < 120){
            disponibilidade = true;
        }else{
            disponibilidade = false;
        }
    }
}