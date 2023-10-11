package CardGame;
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

    //atributos novos
    private C_Carta[] maoJogador1;
    private C_Carta[] maoJogador2;
    private int manaMaxima;
    private C_Carta[] cemiterioJogador1 = new C_Carta[100];
    private C_Carta[] cemiterioJogador2 = new C_Carta[100];

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
        this.maoJogador1 = new C_Carta[10]; // Vetor de até 10 posições para a mão do jogador 1
        this.maoJogador2 = new C_Carta[10]; // Vetor de até 10 posições para a mão do jogador 2
        this.manaMaxima = 0; // Inicialmente, a mana máxima é zero
        this.cemiterioJogador1 = new C_Carta[100]; // Vetor de tamanho 100 para o cemitério do jogador 1
        this.cemiterioJogador2 = new C_Carta[100]; // Vetor de tamanho 100 para o cemitério do jogador 2

      
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
    protected A_Usuario sortearTurnosDoPrimeiroJogador() {

        Random random = new Random();
        int numeroSorteado = random.nextInt(2); // Gera numero aleatório 0 ou 1

        if (numeroSorteado == 0) {
            return jogador1; // Jogador1 começa se o número for 0.
        } else {
            return jogador2; // Jogador2 começa se o número for 1.
        }
    }






/* metodo re feito para a 2 entrega ( refeito abaixo)

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

 */






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
    

    //metodos novos ( coisas mto separadas foram desenvolvidas separadamente com seus pares)

    public void saque(A_Usuario jogador) {
        Random random = new Random();
        int numCartasRetornadas = 0;

        // Seleciona 7 cartas aleatórias do deck
        for (int i = 0; i < 7; i++) {
            C_Carta carta = jogador.getIndiceBaralho(i).sacarCartaAleatoria();
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









    public void turno(A_Usuario jogadorAtual, A_Usuario outroJogador) {//toda essa loucura faz parte de (TURNO) até (moverCartaParaCemiterio)
        System.out.println(jogadorAtual.getNome() + " está jogando...");
    
        // Compra
        comprarCartaAleatoria(jogadorAtual);
    
        // Posicionamento
        posicionarManaOuCarta(jogadorAtual);
    
        // Ataque
        atacar(outroJogador, jogadorAtual);
    
        // Remover cartas com menos de 1 ponto de vida do campo e enviá-las para o cemitério
        removerCartasComMenosDeUmPonto(jogadorAtual);
        removerCartasComMenosDeUmPonto(outroJogador);
    }
    
    private void comprarCartaAleatoria(A_Usuario jogador) {
        if (jogador.getDeck().getNumCartas() > 0) {
            C_Carta cartaSaque = jogador.getDeck().sacarCartaAleatoria();
            jogador.adicionarCartaNaMao(cartaSaque);
            jogador.renovarManaMaxima();
        }
    }
    
    private void posicionarManaOuCarta(A_Usuario jogador) {
        if (jogador.getManaAtual() > 0) {
            // Coloque uma mana no campo
            jogador.posicionarManaNoCampo();
        } else {
            // Coloque uma carta no campo (segunda linha)
            C_Carta carta = jogador.escolherCartaParaPosicionar();
            if (carta != null) {
                jogador.posicionarCartaNoCampo(carta);
                jogador.diminuirManaAtual(carta.getCustoMana());
            }
        }
    }













    
    private void atacar(A_Usuario jogadorAlvo, A_Usuario jogadorAtacante) {
        C_Carta[][] campoJogadorAlvo = jogadorAlvo.getCampo();
        C_Carta[][] campoJogadorAtacante = jogadorAtacante.getCampo();
    
        for (int linha = 0; linha < campoJogadorAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoJogadorAtacante[linha].length; coluna++) {
                C_Carta cartaAtacante = campoJogadorAtacante[linha][coluna];
                if (cartaAtacante != null) {
                    // Verifique se esta carta pode atacar (pode haver regras específicas para isso)
    
                    // Encontre a carta alvo para o ataque (pode haver regras específicas para isso)
                    C_Carta cartaAlvo = encontrarCartaAlvo(campoJogadorAlvo, linha, coluna);
    
                    if (cartaAlvo != null) {
                        // Calcule o dano com base na diferença entre ataque e defesa
                        int dano = cartaAtacante.getAtaque() - cartaAlvo.getDefesa();
                        
                        // Reduza os pontos de vida da carta alvo com o dano calculado
                        cartaAlvo.diminuirPontosVida(dano);
    
                        // Verifique se a carta alvo chegou a 0 ou menos pontos de vida
                        if (cartaAlvo.getPontosVida() <= 0) {
                            // Mova a carta alvo para o cemitério (pode haver métodos específicos para isso)
                            jogadorAlvo.moverCartaParaCemiterio(cartaAlvo);
                        }
                    }
                }
            }
        }
    }
    
    private C_Carta encontrarCartaAlvo(C_Carta[][] campoJogadorAlvo, int linhaAtacante, int colunaAtacante) {
        // Verifique se a posição de ataque é válida
        if (linhaAtacante >= 0 && linhaAtacante < campoJogadorAlvo.length) {
            // A linha de ataque é válida
    
            // Obtenha a carta na mesma posição (mesma linha) do campo do jogador alvo
            C_Carta cartaAlvo = campoJogadorAlvo[linhaAtacante][colunaAtacante];
    
            // Verifique se há uma carta na posição de ataque do jogador alvo
            if (cartaAlvo != null) {
                return cartaAlvo; // Retorne a carta alvo encontrada
            }
        }
    
        // Se não houver carta alvo na posição de ataque, retorne null
        return null;
    }
    











    private void removerCartasComMenosDeUmPonto(C_Carta[][] campoJogador) {
        for (int linha = 0; linha < campoJogador.length; linha++) {
            for (int coluna = 0; coluna < campoJogador[linha].length; coluna++) {
                C_Carta carta = campoJogador[linha][coluna];
                
                // Verifica se há uma carta na posição atual do campo
                if (carta != null) {
                    // Verifica se a carta tem menos de um ponto de vida
                    if (carta.getPontosVida() < 1) {
                        // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                        moverCartaParaCemiterio(carta);
                        
                        // Remove a carta do campo
                        campoJogador[linha][coluna] = null;
                    }
                }
            }
        }
    }
    
    private void moverCartaParaCemiterio(C_Carta carta, A_Usuario jogador) {
        // Verifique qual jogador é dono da carta
        if (jogador == jogador1) {
            // Encontre a primeira posição vazia no cemitério do jogador 1
            for (int i = 0; i < cemiterioJogador1.length; i++) {
                if (cemiterioJogador1[i] == null) {
                    // Coloque a carta no cemitério do jogador 1
                    cemiterioJogador1[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        } else if (jogador == jogador2) {
            // Encontre a primeira posição vazia no cemitério do jogador 2
            for (int i = 0; i < cemiterioJogador2.length; i++) {
                if (cemiterioJogador2[i] == null) {
                    // Coloque a carta no cemitério do jogador 2
                    cemiterioJogador2[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        }
    }

    //metodo refeito para segunda entrega (baseado no slide)

    private A_Usuario determinarVencedor() {
        A_Usuario vencedor = null;
    
        if (jogador1.getPontosVida() > jogador2.getPontosVida()) {
            vencedor = jogador1; // Jogador1 vence se tiver mais pontos de vida.
        } else if (jogador2.getPontosVida() > jogador1.getPontosVida()) {
            vencedor = jogador2; // Jogador2 vence se tiver mais pontos de vida.
        } else {
            // O jogo é um empate se ambos os jogadores tiverem a mesma quantidade de pontos de vida.
            System.out.println("A partida terminou em empate!");
            return null;
        }
    
        System.out.println("A partida terminou! O vencedor é: " + vencedor.getNome());
    
        // Aqui você pode adicionar a lógica para recompensar o vencedor e o perdedor com card coins.
        int cardCoinsVencedor = 100;
        int cardCoinsPerdedor = 10;
    
        vencedor.adicionarCardCoins(cardCoinsVencedor);
        if (vencedor == jogador1) {
            jogador2.adicionarCardCoins(cardCoinsPerdedor);
        } else {
            jogador1.adicionarCardCoins(cardCoinsPerdedor);
        }
    
        return vencedor;
    }







/* metodo re feito para a 2 entrega ( refeito abaixo)

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

 */























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

