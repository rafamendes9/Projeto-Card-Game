package CardGame;
import java.util.Random;

public class G_ArenaPVP {
    private A_Usuario jogador1;
    private A_Usuario jogador2;
    private D_Deck deckJogador1;
    private D_Deck deckJogador2;
    private C_Carta[][] campoJogador1;
    private C_Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    //atributos novos
    //deve ser movido para Usuário
    private C_Carta[] maoJogador1 = new C_Carta[11];
    private C_Carta[] maoJogador2 = new C_Carta[11];
    private int manaMaxima;
    private C_Carta[] cemiterioJogador1 = new C_Carta[120];
    private C_Carta[] cemiterioJogador2 = new C_Carta[120];

    // Construtores 

    
    public G_ArenaPVP(A_Usuario jogador1, A_Usuario jogador2, D_Deck deckJogador1, D_Deck deckJogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.campoJogador1 = new C_Carta[2][5];
        this.campoJogador2 = new C_Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        this.maoJogador1 = new C_Carta[11]; // Vetor de até 11 posições para a mão do jogador 1
        this.maoJogador2 = new C_Carta[11]; // Vetor de até 11 posições para a mão do jogador 2
        this.manaMaxima = 0; // Inicialmente, a mana máxima é zero
        this.cemiterioJogador1 = new C_Carta[120]; // Vetor de tamanho 100 para o cemitério do jogador 1
        this.cemiterioJogador2 = new C_Carta[120]; // Vetor de tamanho 100 para o cemitério do jogador 2

      
    }

     // Construtor que aceita apenas jogadores
     //usado para lobby  em "criarPartida"
     public G_ArenaPVP(A_Usuario jogador1, A_Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador2 = null; // Definido como null 
        this.deckJogador1 = null; // Definido como null 
        this.campoJogador1 = new C_Carta[2][5];
        this.campoJogador2 = new C_Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        
    }


    public void escolherMaoDoUsuario(A_Usuario jogador, int a){
        jogador.escolherCartasDoIndiceBaralho(a);
    }








    // metodos
/*
    public void iniciarPartida() {
        
        System.out.println("A partida está começando!");

        
        escolherMaoDoUsuario(jogador1, 1);
        escolherMaoDoUsuario(jogador2, 1);


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
            turno(jogadorAtual, outroJogador);

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
    
    */







    public boolean verificarVitoria() {
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
    public boolean jogadorAtacantePossuiCarta(A_Usuario jogadorAtacante, C_Carta carta) {

        // Colocar logica para verificar se o jogador atacante possui a carta no campo (
        // desenvolvida na entrega 2) !!!!!!!!!!!!
        // Vai retornar true se a carta estiver no campo do jogador atacante, caso
        // contrário, retorna false
        return true;
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    public int calcularDano(C_Carta cartaAtaque) {

        // Colocar logica para calcular o dano com base nas características da carta de ataque (
        // desenvolvida na entrega 2) !!!!!!!!!!!!
        // Retorna o valor do dano calculado
        return 5;
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!!
    public A_Usuario sortearTurnosDoPrimeiroJogador() {

        Random random = new Random();
        int numeroSorteado = random.nextInt(2); // Gera numero aleatório 0 ou 1

        if (numeroSorteado == 0) {
            return jogador1; // Jogador1 começa se o número for 0.
        } else {
            return jogador2; // Jogador2 começa se o número for 1.
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
    






    
    





  
    
   

    //metodos novos ( coisas mto separadas foram desenvolvidas separadamente com seus pares)


    
    // Método para encontrar a próxima posição vazia na mão do jogador 1
    public int encontrarProximaPosicaoVaziaNaMaoJogador(A_Usuario jogador) {
        C_Carta[] maoJogador = (jogador == jogador1) ? maoJogador1 : maoJogador2;
    
        for (int i = 0; i < maoJogador.length; i++) {
            if (maoJogador[i] == null) {
                return i; // Encontrou uma posição vazia
            }
        }
        return -1; // Nenhuma posição vazia encontrada
    }


    public C_Carta[] escolherMaoDoJogador(A_Usuario jogador) {
        return (jogador == jogador1) ? maoJogador1 : maoJogador2;
    }

    public void adicionarCartaNaMaoJogador(A_Usuario jogador, C_Carta[] cartas, int posicaoNaMao) {
        // Obtem a mão do jogador com base no jogador passado como argumento
        C_Carta[] maoDoJogador = escolherMaoDoJogador(jogador);
    
        // Verifica se a posiçãoNaMao é válida e se o jogador possui uma mão
        if (posicaoNaMao >= 0 && posicaoNaMao < maoDoJogador.length && maoDoJogador != null) {
            // Verifica se a posição já está ocupada na mão do jogador
            if (maoDoJogador[posicaoNaMao] == null) {
                // Adiciona as cartas à posição da mão especificada
                for (int i = 0; i < cartas.length; i++) {
                    maoDoJogador[posicaoNaMao + i] = cartas[i];
                }
                System.out.println("Cartas adicionadas à mão do jogador " + jogador.getNome());
            } else {
                System.out.println("Posição na mão do jogador já ocupada.");
            }
        } else {
            System.out.println("Posição de mão inválida.");
        }
    }
    



    

    public int contarCartasNaMao(A_Usuario jogador) {
        C_Carta[] maoJogador = (jogador == jogador1) ? maoJogador1 : maoJogador2;
        int numCartas = 0;
    
        for (C_Carta carta : maoJogador) {
            if (carta != null) {
                numCartas++;
            }
        }
    
        return numCartas;
    }
    


    public void adicionarCartaTrocadaNaMaoJogador(A_Usuario jogador, C_Carta carta, int posicaoNaMao) {
        // Implementação específica para adicionar uma única carta trocada à mão do jogador
        C_Carta[] maoDoJogador = escolherMaoDoJogador(jogador);
    
        // Verifica se a posiçãoNaMao é válida e se o jogador possui uma mão
        if (posicaoNaMao >= 0 && posicaoNaMao < maoDoJogador.length && maoDoJogador != null) {
            // Verifica se a posição já está ocupada na mão do jogador
            if (maoDoJogador[posicaoNaMao] == null) {
                maoDoJogador[posicaoNaMao] = carta;
                System.out.println("Carta trocada adicionada à mão do jogador " + jogador.getNome());
            } else {
                System.out.println("Posição na mão do jogador já ocupada.");
            }
        } else {
            System.out.println("Posição de mão inválida.");
        }
    }







    public void saque(A_Usuario jogador) {
       int numCartasRetornadas = 0;
    
        // Seleciona 7 cartas aleatórias do deck
        for (int i = 0; i < 7; i++) {
            C_Carta[] carta = jogador.getIndiceBaralho(i).getCartas();
            if (carta != null) {
                // Encontra a próxima posição vazia na mão do jogador
                int posicaoNaMao = encontrarProximaPosicaoVaziaNaMaoJogador(jogador);
    
                // Adiciona a carta à mão do jogador 
                adicionarCartaNaMaoJogador(jogador, carta, posicaoNaMao);
                
            }
        }
    
        // O jogador pode TROCAR (retornar) até 5 cartas (da sua mao) para o deck
        while (numCartasRetornadas < 5 && contarCartasNaMao(jogador) > 0) {
                // Escolhe aleatoriamente uma carta da mão para retornar ao deck
            C_Carta cartaRetornada = jogador.retornarCartaParaDeck(escolherPosicaoParaRetornar(jogador));

            if (cartaRetornada != null) {
                // Sacar uma nova carta aleatória
                C_Carta novaCarta = jogador.sacarCartaAleatoriaDoDeck();

                if (novaCarta != null) {
                    // Adiciona a carta à mão do jogador com base no jogador
                    adicionarCartaTrocadaNaMaoJogador(jogador, novaCarta, numCartasRetornadas);
                    numCartasRetornadas++;
                }
            }
        }
    }
    

    public int escolherPosicaoParaRetornar(A_Usuario jogador) {
        // Obtém o número de cartas na mão do jogador
        int numCartasNaMao = contarCartasNaMao(jogador);

        if (numCartasNaMao > 0) {
            // Escolhe aleatoriamente um índice válido na mão do jogador
            Random random = new Random();
            int posicaoEscolhida = random.nextInt(numCartasNaMao);
            return posicaoEscolhida;
        } else {
            // Se não houver cartas na mão do jogador, retorne -1 para indicar que não há cartas para retornar
            return -1;
        }
    }








































//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       vitinho             !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    
    public void iniciarPartida() {
        System.out.println("A partida está começando!");

        escolherMaoDoUsuario(jogador1, 2);
        escolherMaoDoUsuario(jogador2, 2);

        A_Usuario jogadorAtual = sortearTurnosDoPrimeiroJogador();

        while (!verificarVitoria()) {
            System.out.println(jogadorAtual.getNome() + " está jogando...");
            turno(jogadorAtual, (jogadorAtual == jogador1) ? jogador2 : jogador1);
            fimDeTurno();  // Adicionando o fim de turno ao final de cada turno
            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        determinarVencedor();
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






    public void comprarCartaAleatoria(A_Usuario jogador) {
        if (jogador.getDeck().getNumCartas() > 0) {
            C_Carta cartaSaque = jogador.getDeck().sacarCartaAleatoria();
            jogador.adicionarCartaNaMao(cartaSaque);
            jogador.renovarManaMaxima();
        }
    }

    public void posicionarManaOuCarta(A_Usuario jogador) {
        //Não temos atributo Mana em Usuário
        if (jogador.getManaAtual() > 0) {
            // Coloque uma mana no campo
            jogador.posicionarManaNoCampo();
        } else {
            // Coloque uma carta no campo (segunda linha)
            //refazer o método para definir qual classe terá a função
            C_Carta carta = jogador.escolherCartaParaPosicionar();
            if (carta != null) {
                jogador.posicionarCartaNoCampo(carta);
                jogador.diminuirManaAtual(carta.getCustoMana());
            }
        }
    }


    

    public void atacar(A_Usuario jogadorAlvo, A_Usuario jogadorAtacante) {
        //não tem atributo campo em Usuário, necessário alterar o caminho de chamada de função
        C_Carta[][] campoJogadorAlvo = jogadorAlvo.getCampo();
        C_Carta[][] campoJogadorAtacante = jogadorAtacante.getCampo();
    
        for (int linha = 0; linha < campoJogadorAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoJogadorAtacante[linha].length; coluna++) {
                C_Carta cartaAtacante = campoJogadorAtacante[linha][coluna];
                if (cartaAtacante != null) {
                    
                    C_Carta cartaAlvo = encontrarCartaAlvo(campoJogadorAlvo, linha, coluna);
    
                    if (cartaAlvo != null) {
                                                
                        // Reduz os pontos de vida da carta alvo com o dano calculado
                        cartaAlvo.diminuirPontosVidaCarta(cartaAtacante.getAtaque());
    
                        // Verifique se a carta alvo chegou a 0 ou menos pontos de vida
                        //criar atributo pontos de vida para Cartas
                        if (cartaAlvo.getpontoVidaCarta() <= 0) {
                            // Mova a carta alvo para o cemitério (pode haver métodos específicos para isso)
                            moverCartaParaCemiterio(cartaAlvo, jogadorAlvo);
                        }
                    }
                }
            }
        }
    }


     public C_Carta encontrarCartaAlvo(C_Carta[][] campoJogadorAlvo, int linhaAtacante, int colunaAtacante) {
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
    


    //checa se matou a carta !!!!!!

     public void removerCartasComMenosDeUmPonto(C_Carta[][] campoJogador, A_Usuario jogador) {
        for (int linha = 0; linha < campoJogador.length; linha++) {
            for (int coluna = 0; coluna < campoJogador[linha].length; coluna++) {
                C_Carta carta = campoJogador[linha][coluna];
                
                // Verifica se há uma carta na posição atual do campo
                if (carta != null) {

                if (jogador == jogador1) {
                    // Verifica se a carta tem menos de um ponto de vida
                    if (carta.getpontoVidaCarta() < 1) {
                        // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                        moverCartaParaCemiterio(carta, jogador1);
                        
                        // Remove a carta do campo
                        campoJogador[linha][coluna] = null;
                    }

                }
                    if (jogador == jogador2) {

                    
                        // Verifica se a carta tem menos de um ponto de vida
                        if (carta.getpontoVidaCarta() < 1) {
                            // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                            moverCartaParaCemiterio(carta, jogador2);
                        
                            // Remove a carta do campo
                            campoJogador[linha][coluna] = null;
                        }

                    }



                }
            }
        }
    }


   
    public A_Usuario determinarVencedor() {
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





        

    public void fimDeTurno() {
    // Verificar se algum jogador tem menos de 1 ponto de vida
        if (jogador1.getPontosVida() < 1) {
            System.out.println("A partida terminou! O vencedor é: " + jogador2.getNome());

            // Vencedor ganha 100 card coins
            jogador2.adicionarCardCoins(100);

            // Perdedor ganha 10 card coins
            jogador1.adicionarCardCoins(10);

            // Encerrar o jogo ou fazer outras ações de final de jogo
            // Pode ser uma boa ideia lançar uma exceção ou chamar um método de encerramento aqui
            System.exit(0);
        } else if (jogador2.getPontosVida() < 1) {
            System.out.println("A partida terminou! O vencedor é: " + jogador1.getNome());

            // Vencedor ganha 100 card coins
            jogador1.adicionarCardCoins(100);

            // Perdedor ganha 10 card coins
            jogador2.adicionarCardCoins(10);

            System.exit(0);
        }
    }
























    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  RAFA    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!









  

   
    
   
    









// isso aqui mata a carta e leva pro cemiterio

   
    

    public void moverCartaParaCemiterio(C_Carta carta, A_Usuario jogador) {
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

    
}