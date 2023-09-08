public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Deck deckJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    public Usuario getJogador1(){
        return jogador1;
    }

    public void setJogador1(Usuario jogador1){
        this.jogador1 = jogador1;
    }

    public Usuario getJogador2(){
        return jogador2;
    }

    public void setJogador2(Usuario jogador2){
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1(){
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1){
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2(){
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2){
        this.deckJogador2 = deckJogador2;
    }

    public Carta[][] campoJogador1(){
        return campoJogador1;
    }

    public void setCampoJogador1(Carta[][] campoJogador1){
        this.campoJogador1 = campoJogador1;
    }

    public Carta[][] campoJogador2(){
        return campoJogador2;
    }

    public void setCampoJogador2(Carta[][] campoJogador2){
        this.campoJogador2 = campoJogador2;
    }

    public int getPontosVidaJogador1(){
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2(){
        return pontosVidaJogador2;
    }

    //Quais as condições para se iniciar uma partida?
    public void iniciarPartida() {

    }

    //Para finalizar uma partida é quando 
    //os pontos de vida de qualquer um dos jogadores zerar.
    //Mas como implementar isso? 
    public void finalizarPartida() {
        if(pontosVidaJogador1 == 0 || pontosVidaJogador2 == 0){

        }
    }
}
