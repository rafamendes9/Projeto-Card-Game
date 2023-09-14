public class Deck {
    private String nome;
    private int qtdCartas;
    private boolean disponibilidade = false;
    
    public Deck (String nome, int qtdCartas, boolean disponibilidade) {
        this.nome = nome;
        this.qtdCartas = qtdCartas;
        this.disponibilidade = disponibilidade;
    }
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
}
