public class G2_ArenaDouble extends G_Arena{
    private A_Usuario jogador3;  // Novos jogadores
    private A_Usuario jogador4;
    private D_Deck deckJogador3;
    private D_Deck deckJogador4;
    private C_Carta[][] campoJogador3;
    private C_Carta[][] campoJogador4;
    private int pontosVidaJogador3;
    private int pontosVidaJogador4;

    public G2_ArenaDouble(A_Usuario jogador1, A_Usuario jogador2, A_Usuario jogador3, A_Usuario jogador4,
    D_Deck deckJogador1, D_Deck deckJogador2, D_Deck deckJogador3, D_Deck deckJogador4, C_Carta[][] campoJogador3,
    C_Carta[][] campoJogador4, int pontosVidaJogador3, int pontosVidaJogador4) {
        super(jogador1, jogador2, deckJogador1, deckJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.deckJogador3 = deckJogador3;
        this.deckJogador4 = deckJogador4;
        this.campoJogador3 = new C_Carta[2][5];
        this.campoJogador4 = new C_Carta[2][5];
        this.pontosVidaJogador3 = 20;
        this.pontosVidaJogador4 = 20;
    }

    public A_Usuario getJogador3() {
        return jogador3;
    }
    public void setJogador3(A_Usuario jogador3) {
        this.jogador3 = jogador3;
    }

      public A_Usuario getJogador4() {
        return jogador4;
    }

    public void setJogador4(A_Usuario jogador4) {
        this.jogador4 = jogador4;
    }

    public D_Deck getDeckJogador3() {
        return deckJogador3;
    }
    public void setDeckJogador3(D_Deck deckJogador3) {
        this.deckJogador3 = deckJogador3;
    }

    public D_Deck getDeckJogador4() {
        return deckJogador4;
    }
    public void setDeckJogador4(D_Deck deckJogador4) {
        this.deckJogador4 = deckJogador4;
    }

    public C_Carta[][] getCampoJogador3() {
        return campoJogador3;
    }
    public void setCampoJogador3(C_Carta[][] campoJogador3) {
        this.campoJogador3 = campoJogador3;
    }

    public C_Carta[][] getCampoJogador4() {
        return campoJogador4;
    }
    public void setCampoJogador4(C_Carta[][] campoJogador4) {
        this.campoJogador4 = campoJogador4;
    }

    public int getPontosVidaJogador3() {
        return pontosVidaJogador3;
    }
    public void setPontosVidaJogador3(int pontosVidaJogador3) {
        this.pontosVidaJogador3 = pontosVidaJogador3;
    }

    public int getPontosVidaJogador4() {
        return pontosVidaJogador4;
    }
    public void setPontosVidaJogador4(int pontosVidaJogador4) {
        this.pontosVidaJogador4 = pontosVidaJogador4;
    }
    //PEQUENA IDEIA DE COMO FUNCIONARIA O MODO DE JOGO 2PV2P
    /*
    @Override
    public void saque(A_Usuario jogador) {
        Random random = new Random();
        int numCartasRetornadas = 0;

        // Seleciona 7 cartas aleatórias do deck
        for (int i = 0; i < 7; i++) {
            C_Carta carta = jogador.getDeck().sacarCartaAleatoria();
            if (carta != null) {
                // Adiciona a carta à mão
                jogador.adicionarCartaNaMao(carta);
            }
        }

        // O jogador pode retornar até 5 cartas para o deck
        while (numCartasRetornadas < 5 && jogador.getNumCartasNaMao() > 0) {
            // Escolhe aleatoriamente uma carta da mão para retornar ao deck
            C_Carta cartaRetornada = jogador.retornarCartaParaDeck(random.nextInt(jogador.getNumCartasNaMao()));

            if (cartaRetornada != null) {
                // Sacar uma nova carta aleatória
                C_Carta novaCarta = jogador.getDeck().sacarCartaAleatoria();
                if (novaCarta != null) {
                    jogador.adicionarCartaNaMao(novaCarta);
                    numCartasRetornadas++;
                }
            }
        }
    }

    @Override
    public void inicio() {
        // Sorteia aleatoriamente o jogador que irá começar
        Random random = new Random();
        int num = random.nextInt(4);

        A_Usuario jogadorAtual;
        A_Usuario outroJogador;

        // Define o jogador inicial e o outro jogador
        if (num == 0) {
            jogadorAtual = jogador1;
            outroJogador = jogador2;
        } else if (num == 1) {
            jogadorAtual = jogador2;
            outroJogador = jogador1;
        } else if (num == 2) {
            jogadorAtual = jogador3;
            outroJogador = jogador4;
        } else {
            jogadorAtual = jogador4;
            outroJogador = jogador3;
        }

        // Inicia o turno para o jogador atual
        turno(jogadorAtual, outroJogador);
    }

    // Sobrecarga do método turno para incluir aliados e inimigos
    public void turno(A_Usuario jogadorAtual, A_Usuario aliado, A_Usuario[] inimigos) {
        // Realiza as ações do turno para o jogador atual
        compra(jogadorAtual);
        posicionamento(jogadorAtual, aliado);
        ataque(jogadorAtual, inimigos);
        fimDoTurno(jogadorAtual, aliado, inimigos);
    }

    public void compra(A_Usuario jogador) {
        // Verifica se há pelo menos uma carta no deck
        if (jogador.getDeck().getNumCartas() > 0) {
            // Sacar uma carta aleatória do deck
            C_Carta cartaSaque = jogador.getDeck().sacarCartaAleatoria();
            jogador.adicionarCartaNaMao(cartaSaque);
            // Renova a mana máxima
            jogador.aumentarManaMaxima();
        }
    }

    public void posicionamento(A_Usuario jogador, A_Usuario aliado) {
        // Verifica se há mana disponível para posicionar uma carta
        if (jogador.getManaAtual() > 0) {
            // Coloca uma carta no campo (posição fixa, segunda linha do campo)
            C_Carta carta = jogador.escolherCartaParaPosicionar();
            if (carta != null) {
                jogador.posicionarCartaNoCampo(carta);
                jogador.diminuirManaAtual(carta.getCustoMana());
            }
        }
    }

    public void fimDoTurno(A_Usuario jogadorAtual, A_Usuario aliado, A_Usuario[] inimigos) {
        // Verificar se algum dos jogadores tem menos de 1 ponto de vida
        if (jogadorAtual.getPontosVida() < 1) {
            System.out.println("Jogador atual é o vencedor!");
            for (A_Usuario inimigo : inimigos) {
                inimigo.adicionarCardCoins(10);
            }
            aliado.adicionarCardCoins(100);
        } else {
            for (A_Usuario inimigo : inimigos) {
                if (inimigo.getPontosVida() < 1) {
                    System.out.println(inimigo.getNome() + " é o vencedor!");
                    aliado.adicionarCardCoins(10);
                    inimigo.adicionarCardCoins(100);
                    break;
                }
            }
        }
    }
 */
    
}