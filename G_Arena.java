public class G_Arena {
    private A_Usuario jogador1;
    private A_Usuario jogador2;
    private D_Deck deckJogador1;
    private D_Deck deckJogador2;
    private C_Carta[][] campoJogador1;
    private C_Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    public G_Arena(A_Usuario jogador1, A_Usuario jogador2, D_Deck deckJogador1, D_Deck deckJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = new C_Carta[2][5];
        this.campoJogador2 = new C_Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    public A_Usuario getJogador1(){
        return jogador1;
    }
    public void setJogador1(A_Usuario jogador1){
        this.jogador1 = jogador1;
    }

    public A_Usuario getJogador2(){
        return jogador2;
    }
    public void setJogador2(A_Usuario jogador2){
        this.jogador2 = jogador2;
    }

    public D_Deck getDeckJogador1(){
        return deckJogador1;
    }
    public void setDeckJogador1(D_Deck deckJogador1){
        this.deckJogador1 = deckJogador1;
    }

    public D_Deck getDeckJogador2(){
        return deckJogador2;
    }
    public void setDeckJogador2(D_Deck deckJogador2){
        this.deckJogador2 = deckJogador2;
    }

    public C_Carta[][] campoJogador1(){
        return campoJogador1;
    }
    public void setCampoJogador1(C_Carta[][] campoJogador1){
        this.campoJogador1 = campoJogador1;
    }

    public C_Carta[][] campoJogador2(){
        return campoJogador2;
    }
    public void setCampoJogador2(C_Carta[][] campoJogador2){
        this.campoJogador2 = campoJogador2;
    }

    public int getPontosVidaJogador1(){
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2(){
        return pontosVidaJogador2;
    }
    /*
    //Quais as condições para se iniciar uma partida?
    public void iniciarPartida() {
        jogador1.getInventario();
        jogador2.getInventario();
        // Checar se os jogadores tão no msm level
        if (Inventario.getNivel() == Inventario.getNivel()) {
            System.out.println("A partida está iniciando...");
            // Lógica da partida
        } else {
            System.out.println("Os usuários não têm o mesmo nível. A partida não pode ser iniciada.");
        }
    }

    //Para finalizar uma partida é quando 
    //os pontos de vida de qualquer um dos jogadores zerar.
    //Mas como implementar isso? 
    public void finalizarPartida() {
        if(pontosVidaJogador1 == 0 || pontosVidaJogador2 == 0){

        }
    }
     */
}