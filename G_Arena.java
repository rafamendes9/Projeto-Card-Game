import java.util.Random;

public class G_Arena {
    private A_Usuario jogador1;
    private A_Usuario jogador2;
    private D_Deck deckJogador1;
    private D_Deck deckJogador2;
    private C_Carta[][] campoJogador1;
    private C_Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    // Construtores 

    
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

     // Construtor que aceita apenas jogadores
     //usado para lobby  em "criarPartida"
     public G_Arena(A_Usuario jogador1, A_Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador2 = null; // Definido como null 
        this.deckJogador1 = null; // Definido como null 
        this.campoJogador1 = new C_Carta[2][5];
        this.campoJogador2 = new C_Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    // metodos

    public void iniciarPartida() {
        System.out.println("A partida está começando!");

        //!!!!!!!!!!!!!!!!!!!URGENTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Configura o deck inicial dos jogadores (distribuir cartas) ( desenvolvida na entrega 2) !!!!!!!!!!!! esse metodo apenas existe ate o momento
        jogador1.configurarDeckInicial();
        jogador2.configurarDeckInicial();

        //embaralha deck jogadores do metodo em D_Deck
        deckJogador1.embaralhar();
        deckJogador2.embaralhar();

        // Realiza o sorteio para determinar quem começa
        A_Usuario jogadorAtual = sortearTurnosDoPrimeiroJogador();

        // Loop principal da partida
        while (!verificarVitoria()) {
            System.out.println(jogadorAtual.getNome() + " está jogando...");

            // Permite jogador atual faça um turno (jogar cartas, atacar)
         // ( desenvolvida na entrega 2) !!!!!!!!!!!! esse metodo apenas existe ate o
            // momento
            jogadorAtual.fazerTurno();

            // Trocar de jogador (swap do loop para troca de turnos no while)
            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        // Determina o vencedor da partida
        A_Usuario vencedor = determinarVencedor();

        // Printa o vencedor da partida
        if (vencedor != null) {
            System.out.println("A partida terminou! O vencedor é: " + vencedor.getNome());
        } else {
            System.out.println("A partida terminou em empate!");
        }
    }

    private boolean verificarVitoria() {
        return jogador1.getPontosVida() <= 0 || jogador2.getPontosVida() <= 0;
    }

    public void atacarJogador(A_Usuario jogadorAtacante, A_Usuario jogadorAlvo, C_Carta cartaAtaque) {
        // Verifica se jogadores e carta de ataque são válidos
        if (jogadorAtacante == null || jogadorAlvo == null || cartaAtaque == null) {
            System.out.println("Ataque inválido. Verifique os jogadores e a carta de ataque.");
            return;
        }

        // Verifica se carta de ataque pertence ao jogador atacante
        if (!jogadorAtacantePossuiCarta(jogadorAtacante, cartaAtaque)) {
            System.out.println("O jogador atacante não possui a carta de ataque no campo.");
            return;
        }

        // Calcula dano com base nas características da carta de ataque.
        int dano = calcularDano(cartaAtaque);

        // Atualiza pontos de vida do jogador alvo
        jogadorAlvo.diminuirPontosVida(dano);

        System.out.println(jogadorAtacante.getNome() + " atacou " + jogadorAlvo.getNome() + " com "
                + cartaAtaque.getNome() + " causando " + dano + " de dano.");

        // Verifica se o jogador alvo ficou sem pontos de vida
        if (jogadorAlvo.getPontosVida() <= 0) {
            System.out.println(
                    jogadorAlvo.getNome() + " ficou sem pontos de vida. " + jogadorAtacante.getNome() + " venceu!");

            // falta lógica para finalizar a partida ( desenvolvida na entrega 2)
            // !!!!!!!!!!!!
        }
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    private boolean jogadorAtacantePossuiCarta(A_Usuario jogadorAtacante, C_Carta carta) {

        // Colocar logica para verificar se o jogador atacante possui a carta no campo (
        // desenvolvida na entrega 2) !!!!!!!!!!!!
        // Vai retornar true se a carta estiver no campo do jogador atacante, caso
        // contrário, retorna false
        return true;
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    private int calcularDano(C_Carta cartaAtaque) {

        // Colocar logica para calcular o dano com base nas características da carta de ataque (
        // desenvolvida na entrega 2) !!!!!!!!!!!!
        // Retorna o valor do dano calculado
        return 5;
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    private A_Usuario sortearTurnosDoPrimeiroJogador() {

        Random random = new Random();
        int numeroSorteado = random.nextInt(2); // Gera numero aleatório 0 ou 1

        if (numeroSorteado == 0) {
            return jogador1; // Jogador1 começa se o número for 0.
        } else {
            return jogador2; // Jogador2 começa se o número for 1.
        }
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    private A_Usuario determinarVencedor() {

        if (jogador1.getPontosVida() > jogador2.getPontosVida()) {
            return jogador1; // Jogador1 vence se tiver mais pontos de vida.
        } else if (jogador2.getPontosVida() > jogador1.getPontosVida()) {
            return jogador2; // Jogador2 vence se tiver mais pontos de vida.
        } else {
            return null; // O jogo é um empate se ambos os jogadores tiverem a mesma quantidade de pontos
                         // de vida.
        }
    }

    // get set
    public A_Usuario getJogador1() {
        return jogador1;
    }

    public void setJogador1(A_Usuario jogador1) {
        this.jogador1 = jogador1;
    }

    public A_Usuario getJogador2() {
        return jogador2;
    }

    public void setJogador2(A_Usuario jogador2) {
        this.jogador2 = jogador2;
    }

    public D_Deck getDeckJogador1() {
        return deckJogador1;
    }

    public void setDeckJogador1(D_Deck deckJogador1) {
        this.deckJogador1 = deckJogador1;
    }

    public D_Deck getDeckJogador2() {
        return deckJogador2;
    }

    public void setDeckJogador2(D_Deck deckJogador2) {
        this.deckJogador2 = deckJogador2;
    }

    public C_Carta[][] campoJogador1() {
        return campoJogador1;
    }

    public void setCampoJogador1(C_Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }

    public C_Carta[][] campoJogador2() {
        return campoJogador2;
    }

    public void setCampoJogador2(C_Carta[][] campoJogador2) {
        this.campoJogador2 = campoJogador2;
    }

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }
    
    //PEQUENA IDEIA DE COMO FUNCIONARIA O MODO DE JOGO PVP
    /*    public void saque(A_Usuario jogador) {
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

    public void inicio() {
        // Sorteia aleatoriamente o jogador que irá começar
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0) {
            // Jogador1 começa
            turno(jogador1, jogador2);
        } else {
            // Jogador2 começa
            turno(jogador2, jogador1);
        }
    }

    public void turno(A_Usuario jogadorAtual, A_Usuario outroJogador) {
        // Realiza as ações do turno para o jogador atual
        compra(jogadorAtual);
        posicionamento(jogadorAtual);
        ataque(jogadorAtual, outroJogador);
        fimDoTurno(jogadorAtual, outroJogador);
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

    public void posicionamento(A_Usuario jogador) {
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

    public void ataque(A_Usuario jogadorAtacante, A_Usuario jogadorAlvo) {
        // Implementar a lógica para o ataque
        // ...
    }

    public void fimDoTurno(A_Usuario jogadorAtual, A_Usuario outroJogador) {
        // Verificar se algum dos jogadores tem menos de 1 ponto de vida
        if (jogadorAtual.getPontosVida() < 1) {
            System.out.println(outroJogador.getNome() + " é o vencedor!");
            outroJogador.adicionarCardCoins(100);
            jogadorAtual.adicionarCardCoins(10);
        } else if (outroJogador.getPontosVida() < 1) {
            System.out.println(jogadorAtual.getNome() + " é o vencedor!");
            jogadorAtual.adicionarCardCoins(100);
            outroJogador.adicionarCardCoins(10);
        }
    } */
}
