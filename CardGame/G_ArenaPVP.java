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


    
    
    
    // metodos
    
    
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

    
    
    public void escolherMaoDoUsuario(A_Usuario jogador, int a){
        jogador.escolherCartasDoIndiceBaralho(a);
    }



    public boolean verificarVitoria() {
        return jogador1.getPontosVida() <= 0 || jogador2.getPontosVida() <= 0;
    }

    public A_Usuario sortearTurnosDoPrimeiroJogador() {

        Random random = new Random();
        int numeroSorteado = random.nextInt(2); // Gera numero aleatório 0 ou 1

        if (numeroSorteado == 0) {
            return jogador1; // Jogador1 começa se o número for 0.
        } else {
            return jogador2; // Jogador2 começa se o número for 1.
        }
    }

    
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!COMEÇO DE SAQUE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       
 //saque e sub metodos de saque ( colados )   
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
            C_Carta cartaRetornada = jogador.retornarCartaParaDeck(escolherPosicaoDaCartaQueVaiRetornarParaDeck(jogador));

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
//Método que adiciona a carta na mao do jogador em especifico
    public C_Carta[] escolherMaoDoJogador(A_Usuario jogador) {
        return (jogador == jogador1) ? maoJogador1 : maoJogador2;
    }
//Método adiciona a cara para a mao
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
//Método conta o numero de cartas na mão
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
//Método especifico para adicionar a carta na mao do jogador ( dentro do while de SAQUE) esse metodo coloca as cartas trocadas
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
//Metodo pega o indice do vetor mao e retorna ele para escolher quais cartas vao retornar ( cartas vao dar REROLL)
    public int escolherPosicaoDaCartaQueVaiRetornarParaDeck(A_Usuario jogador) {
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
// !!!!!!!!!!!!!!!!! FIM DE SAQUE !!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
    

     public void turno(A_Usuario jogadorAtual, A_Usuario outroJogador) {//toda essa loucura faz parte de (TURNO) até (moverCartaParaCemiterio)
        System.out.println(jogadorAtual.getNome() + " está jogando...");
    
        // Sacar carta
        saque(jogadorAtual);
    
        // Posicionamento
        posicionarManaOuCarta(jogadorAtual);
    
        // Ataque
        atacar(outroJogador, jogadorAtual);
    
        // Remover cartas com menos de 1 ponto de vida do campo e enviá-las para o cemitério
        removerCartasComMenosDeUmPonto(campoJogador1, jogadorAtual);
        removerCartasComMenosDeUmPonto(campoJogador2, outroJogador);
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

    public C_Carta[][] getcampoJogador1() {
        return campoJogador1;
    }

    public void setCampoJogador1(C_Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }

    public C_Carta[][] getcampoJogador2() {
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
        //escolhe os jogador correspondente               
        C_Carta[][] campoJogadorAlvo = new C_Carta[2][5];
        C_Carta[][] campoJogadorAtacante = new C_Carta[2][5];
        if (jogadorAlvo == jogador1) {
            jogadorAtacante = jogador2;
            campoJogadorAlvo = campoJogador1;
            campoJogadorAtacante = campoJogador2; 
        }else if(jogadorAlvo == jogador2){
            jogadorAtacante = jogador1;
            campoJogadorAlvo = campoJogador2;
            campoJogadorAtacante = campoJogador1;
        }
    
        for (int linha = 0; linha < campoJogadorAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoJogadorAtacante[linha].length; coluna++) {
                C_Carta cartaAtacante = campoJogadorAtacante[linha][coluna];
                if (cartaAtacante != null) {
                    
                    C_Carta cartaAlvo = encontrarCartaAlvo(campoJogadorAlvo, linha, coluna);
    
                    if (cartaAlvo != null) {
                                                
                        // Reduz os pontos de vida da carta alvo com o dano calculado
                        cartaAlvo.calculoDeDiminuirPontosVidaCarta(cartaAtacante.getAtaque());
    
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
    


    //checa se matou a carta ( isso garante que a carta vai para o cemiterio caso tenha uma carta espcial do tipo magia)!!!!!!
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
            jogador2.atualizarNivel(1000);

            // Perdedor ganha 10 card coins
            jogador1.adicionarCardCoins(10);
            jogador1.atualizarNivel(500);


            // Encerrar o jogo ou fazer outras ações de final de jogo
            // Pode ser uma boa ideia lançar uma exceção ou chamar um método de encerramento aqui
            System.exit(0);
        } else if (jogador2.getPontosVida() < 1) {
            System.out.println("A partida terminou! O vencedor é: " + jogador1.getNome());

            // Vencedor ganha 100 card coins
            jogador1.adicionarCardCoins(100);
            jogador1.atualizarNivel(1000);

            // Perdedor ganha 10 card coins
            jogador2.adicionarCardCoins(10);
            jogador2.atualizarNivel(500);

            System.exit(0);
        }
    }























  

   
    
   
    









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