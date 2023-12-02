package Modelo;
import java.util.Random;

public class G2_Arena2V2 extends G1_ArenaPVP{
    private A_Usuario jogador3;  // Novos jogadores
    private A_Usuario jogador4;
    private D_Deck deckJogador3;
    private D_Deck deckJogador4;
    private C_Carta[][] campoJogador3;
    private C_Carta[][] campoJogador4;
    private int pontosVidaJogador3;
    private int pontosVidaJogador4;

    //atributos novos
    private C_Carta[] maoJogador3 = new C_Carta[11];
    private C_Carta[] maoJogador4 = new C_Carta[11];
    private C_Carta[] cemiterioJogador3 = new C_Carta[120];
    private C_Carta[] cemiterioJogador4 = new C_Carta[120];
    

    //novo atributo para criar em lobby
    private F_Lobby lobby; // Adicione um atributo para a referência do lobby

    public G2_Arena2V2(A_Usuario jogador1, A_Usuario jogador2, A_Usuario jogador3, A_Usuario jogador4,
            D_Deck deckJogador1, D_Deck deckJogador2, D_Deck deckJogador3, D_Deck deckJogador4, C_Carta[][] campoJogador3,
            C_Carta[][] campoJogador4, int pontosVidaJogador3, int pontosVidaJogador4, F_Lobby lobby) {
        super(jogador1, jogador2, deckJogador1, deckJogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.deckJogador3 = deckJogador3;
        this.deckJogador4 = deckJogador4;
        this.campoJogador3 = new C_Carta[2][5];
        this.campoJogador4 = new C_Carta[2][5];
        this.pontosVidaJogador3 = 20;
        this.pontosVidaJogador4 = 20;
        this.lobby = lobby; // Injete a referência do lobby no construtor
    }

    //POSSIVELMENTE O ATRIBUTO DEVA VIRAR PROTECTED
    @Override
    public A_Usuario sortearTurnosDoPrimeiroJogador() {

        Random random = new Random();
        int numeroSorteado = random.nextInt(4); // Gera numero aleatório 0 ou 1
        A_Usuario jogadorSorteado = new A_Usuario(null, null, null, null, null, numeroSorteado, numeroSorteado, null, null);

        if (numeroSorteado == 0) {
            jogadorSorteado = super.getJogador1(); // Jogador1 começa se o número for 0.
        } else if(numeroSorteado == 1) {
            jogadorSorteado = super.getJogador2(); // Jogador2 começa se o número for 1.
        }else if(numeroSorteado == 2){
            jogadorSorteado = jogador3;
        }else if(numeroSorteado == 3){
            jogadorSorteado = jogador4;
        }

        return jogadorSorteado;
    }

    
    // Método para iniciar a partida com 4 jogadores
    @Override
    public void iniciarPartida() {
        System.out.println("A partida está começando!");

        escolherMaoDoUsuario(super.getJogador1(), 2);
        escolherMaoDoUsuario(super.getJogador2(), 2);
        escolherMaoDoUsuario(jogador3, 2);
        escolherMaoDoUsuario(jogador4, 2);

        A_Usuario jogadorAtual = sortearTurnosDoPrimeiroJogador();

        while (!super.verificarVitoria()) {
            System.out.println(jogadorAtual.getNome() + " está jogando...");

            if (jogadorAtual == super.getJogador1() || jogadorAtual == super.getJogador2()) {
                // Ataque dos aliados para os jogadores 1 e 2
                turno(jogadorAtual, (jogadorAtual == super.getJogador1()) ? super.getJogador2() : super.getJogador1());
            } else {
                // Ataque dos aliados para os jogadores 3 e 4
                turno(jogadorAtual, (jogadorAtual == jogador3) ? jogador4 : jogador3);
            }

            fimDeTurno();
            jogadorAtual = (jogadorAtual == super.getJogador1()) ? super.getJogador2() : (jogadorAtual == super.getJogador2()) ? jogador3 : jogador4;
        }

        determinarVencedor();
    }



    public void escolherMaoDoUsuario(A_Usuario jogador, int a){
        jogador.escolherCartasDoIndiceBaralho(a);
    }



    public boolean verificarVitoria() {
        return super.getJogador1().getPontosVida() <= 0 || super.getJogador2().getPontosVida() <= 0 ||
        jogador3.getPontosVida() <= 0 || jogador4.getPontosVida() <= 0;
    }

    // metodo isso aqui mata a carta e leva pro cemiterio 
    public void moverCartaParaCemiterio(C_Carta carta, A_Usuario jogador) {
        // Verifique qual jogador é dono da carta
        if (jogador == super.getJogador1()) {
            // Encontre a primeira posição vazia no cemitério do jogador 1
            for (int i = 0; i < super.getcampoJogador1().length; i++) {
                if (super.getCemiterioJogador1()[i] == null) {
                    // Coloque a carta no cemitério do jogador 1
                    super.getCemiterioJogador2()[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        }else if (jogador == super.getJogador2()) {
            // Encontre a primeira posição vazia no cemitério do jogador 2
            for (int i = 0; i < super.getcampoJogador2().length; i++) {
                if (super.getCemiterioJogador2()[i] == null) {
                    // Coloque a carta no cemitério do jogador 2
                    super.getCemiterioJogador2()[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        }else if (jogador == jogador3) {
            // Encontre a primeira posição vazia no cemitério do jogador 2
            for (int i = 0; i < campoJogador3.length; i++) {
                if (super.getCemiterioJogador2()[i] == null) {
                    // Coloque a carta no cemitério do jogador 2
                    super.getCemiterioJogador2()[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        }else if (jogador == super.getJogador2()) {
            // Encontre a primeira posição vazia no cemitério do jogador 2
            for (int i = 0; i < super.getcampoJogador2().length; i++) {
                if (super.getCemiterioJogador2()[i] == null) {
                    // Coloque a carta no cemitério do jogador 2
                    super.getCemiterioJogador2()[i] = carta;
                    break; // Saia do loop depois de encontrar a primeira posição vazia
                }
            }
        }
    }

    // Método para realizar o turno com aliados
    @Override
    public void turno(A_Usuario jogadorAtual, A_Usuario outroJogador) {//toda essa loucura faz parte de (TURNO) até (moverCartaParaCemiterio)
        System.out.println(jogadorAtual.getNome() + " está jogando...");
        
        //cada turno jogador deve ganhar + 1 de mana para usar
        int novaMana = super.getMana() + 1;
        jogadorAtual.setManaDoJogador( novaMana);// LOGICA PREVIA DE MANA ENQUANTO NÂO SE REQUER LOGICA ESPEFICA EM SLIDE !!!!!!!
        super.setmanaMaxima(jogadorAtual.getManaDoJogador());
        
        // Sacar carta
        saque(jogadorAtual);
    
        // Posicionamento
        posicionarManaOuCartaNoCampo(jogadorAtual);
    
        // Ataque
        atacar(outroJogador, jogadorAtual);
    
        // Remover cartas com menos de 1 ponto de vida do campo e enviá-las para o cemitério
        removerCartasComMenosDeUmPonto(super.getcampoJogador1(), jogadorAtual);
        removerCartasComMenosDeUmPonto(super.getcampoJogador2(), outroJogador);
        removerCartasComMenosDeUmPonto(campoJogador3, outroJogador);
        removerCartasComMenosDeUmPonto(campoJogador4, outroJogador);
    }

    @Override
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
                C_Carta novaCarta = jogador.sacarCartaAleatoriaDoDeckREROLL();
 
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
        C_Carta[] maoJogador1 = (jogador == super.getJogador1()) ? super.getMaoJogador1() : super.getMaoJogador2();

        C_Carta[] maoJogador2 = (jogador == jogador3) ? maoJogador3 : maoJogador4;
     
        for (int i = 0; i < maoJogador1.length; i++) {
            if (maoJogador1[i] == null) {
                return i; // Encontrou uma posição vazia
            }
        }

        for (int i = 0; i < maoJogador2.length; i++) {
            if (maoJogador2[i] == null) {
                return i; // Encontrou uma posição vazia
            }
        }
        return -1; // Nenhuma posição vazia encontrada
    }
//Método que adiciona a carta na mao do jogador em especifico
    public C_Carta[] escolherMaoDoTime1(A_Usuario jogador) {
        return (jogador == getJogador1()) ? super.getMaoJogador1() : super.getMaoJogador2();
    }

    public C_Carta[] escolherMaoDoTime2(A_Usuario jogador) {
        return (jogador == jogador3) ? maoJogador3 : maoJogador4;
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
        C_Carta[] maoJogador = (jogador == super.getJogador1()) ? super.getMaoJogador1() : super.getMaoJogador2();
        C_Carta[] maoJogador2 = (jogador == jogador3) ? maoJogador3 : maoJogador4;
        int numCartas = 0;
     
        for (C_Carta carta : maoJogador) {
             if (carta != null) {
                 numCartas++;
             }
        }

        for (C_Carta carta : maoJogador2) {
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

    // Método para realizar o ataque com aliados
    @Override
    public void atacar(A_Usuario jogadorAlvo, A_Usuario jogadorAtacante) {
        //escolhe os jogador correspondente               
        C_Carta[][] campoJogadorAlvo = new C_Carta[2][5];
        C_Carta[][] campoJogadorAtacante = new C_Carta[2][5];
        if (jogadorAlvo == super.getJogador1()) {
            jogadorAtacante = super.getJogador2();
            campoJogadorAlvo = super.getcampoJogador1();
            campoJogadorAtacante = super.getcampoJogador2(); 
        }else if(jogadorAlvo == super.getJogador2()){
            jogadorAtacante = super.getJogador1();
            campoJogadorAlvo = super.getcampoJogador2();
            campoJogadorAtacante = super.getcampoJogador1();
        }
    
        for (int linha = 0; linha < campoJogadorAtacante.length; linha++) {
            for (int coluna = 0; coluna < campoJogadorAtacante[linha].length; coluna++) {
                C_Carta cartaAtacante = campoJogadorAtacante[linha][coluna];
                if (cartaAtacante != null) {
                    
                    C_Carta cartaAlvo = encontrarCartaAlvo(campoJogadorAlvo, linha, coluna);
    
                    if (cartaAlvo != null) {
                                            
                        K_Feitico.ativarHabilidade(cartaAtacante.getHabilidade(), cartaAtacante);
                        // Reduz os pontos de vida da carta alvo com o dano calculado
                        if (cartaAtacante instanceof C2_CartaShiny) {
                            C2_CartaShiny cartaShiny = (C2_CartaShiny) cartaAtacante;
                            K_Feitico.ativarHabilidade(cartaShiny.getHabilidadeExtra(), cartaShiny);
                        }
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

                    if (jogador == super.getJogador1()) {
                        // Verifica se a carta tem menos de um ponto de vida
                        if (carta.getpontoVidaCarta() < 1) {
                            // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                            moverCartaParaCemiterio(carta, super.getJogador1());
                        
                            // Remove a carta do campo
                            campoJogador[linha][coluna] = null;
                        }

                    }else if (jogador == super.getJogador2()) {
                        // Verifica se a carta tem menos de um ponto de vida
                        if (carta.getpontoVidaCarta() < 1) {
                            // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                            moverCartaParaCemiterio(carta, super.getJogador2());
                        
                            // Remove a carta do campo
                            campoJogador[linha][coluna] = null;
                        }

                    }else if (jogador == jogador3) {
                        // Verifica se a carta tem menos de um ponto de vida
                        if (carta.getpontoVidaCarta() < 1) {
                            // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                            moverCartaParaCemiterio(carta, jogador3);
                        
                            // Remove a carta do campo
                            campoJogador[linha][coluna] = null;
                        }

                    }else if (jogador == jogador4) {
                        // Verifica se a carta tem menos de um ponto de vida
                        if (carta.getpontoVidaCarta() < 1) {
                            // Move a carta para o cemitério (assumindo que você tem um vetor para o cemitério)
                            moverCartaParaCemiterio(carta, jogador4);
                        
                            // Remove a carta do campo
                            campoJogador[linha][coluna] = null;
                        }

                    }
                }
            }
        }
    }
    
    //metodo determinar quem ganhou o jogo quando sai do LOOP da PARTIDA
    public A_Usuario determinarVencedor() {
        A_Usuario vencedor = null;
    
        if (super.getJogador1().getPontosVida() > jogador3.getPontosVida() || super.getJogador1().getPontosVida() > jogador4.getPontosVida()) {
            vencedor = super.getJogador1(); // Jogador1 vence se tiver mais pontos de vida.
        } else if (super.getJogador2().getPontosVida() > jogador3.getPontosVida() || super.getJogador2().getPontosVida() > jogador4.getPontosVida()) {
            vencedor = super.getJogador2(); // Jogador2 vence se tiver mais pontos de vida.
        }else if (jogador3.getPontosVida() > super.getJogador1().getPontosVida() || jogador3.getPontosVida() > super.getJogador2().getPontosVida()) {
            vencedor = jogador3; // Jogador2 vence se tiver mais pontos de vida.
        }else if (jogador4.getPontosVida() > super.getJogador1().getPontosVida() || jogador4.getPontosVida() > super.getJogador2().getPontosVida()) {
            vencedor = jogador4; // Jogador2 vence se tiver mais pontos de vida.
        } else {
            // O jogo é um empate se ambos os jogadores tiverem a mesma quantidade de pontos de vida.
            System.out.println("A partida terminou em empate!");
            return null;
        }

        if (super.getJogador1().getPontosVida() < 1 || super.getJogador2().getPontosVida() < 1) {
            System.out.println("A partida terminou! Os vencedores são: " + super.getJogador2().getNome() + " e " + super.getJogador1().getNome());

            // Vencedores ganham 100 card coins
            //Entrega dos passes
            if (super.getJogador1().getWins() % 7 == 0) {
                PassePremium passePremium = new PassePremium();
                passePremium.entregarPremiacao(super.getJogador2());
                passePremium.setPremiacaoAtual(passePremium.getPremiacaoAtual() + 1);
            } else if(super.getJogador1().getWins() % 3 == 0){
                PasseComum passeComum = new PasseComum();
                passeComum.entregarPremiacao(super.getJogador2());
                passeComum.setPremiacaoAtual(passeComum.getPremiacaoAtual() + 1);
            }

            super.getJogador2().adicionarCardCoins(100);
            super.getJogador2().atualizarNivel(1000);
            super.getJogador2().setWins(super.getJogador2().getWins() + 1);

            //Entrega dos passes
            if (super.getJogador1().getWins() % 7 == 0) {
                PassePremium passePremium = new PassePremium();
                passePremium.entregarPremiacao(super.getJogador1());
                passePremium.setPremiacaoAtual(passePremium.getPremiacaoAtual() + 1);
            } else if(super.getJogador1().getWins() % 3 == 0){
                PasseComum passeComum = new PasseComum();
                passeComum.entregarPremiacao(super.getJogador1());
                passeComum.setPremiacaoAtual(passeComum.getPremiacaoAtual() + 1);
            }

            super.getJogador1().adicionarCardCoins(100);
            super.getJogador1().atualizarNivel(1000);
            super.getJogador1().setWins(super.getJogador1().getWins() + 1);

            // Perdedores ganham 10 card coins
            jogador3.adicionarCardCoins(10);
            jogador3.atualizarNivel(500);

            jogador4.adicionarCardCoins(10);
            jogador4.atualizarNivel(500);

        } else if (jogador3.getPontosVida() < 1 || jogador4.getPontosVida() < 1) {
            System.out.println("A partida terminou! Os vencedores são: " + jogador4.getNome() + " e " + jogador3.getNome());

            // Vencedores ganham 100 card coins
            //Entrega dos passes
            if (jogador3.getWins() % 7 == 0) {
                PassePremium passePremium = new PassePremium();
                passePremium.entregarPremiacao(jogador3);
                passePremium.setPremiacaoAtual(passePremium.getPremiacaoAtual() + 1);
            } else if(jogador3.getWins() % 3 == 0){
                PasseComum passeComum = new PasseComum();
                passeComum.entregarPremiacao(jogador3);
                passeComum.setPremiacaoAtual(passeComum.getPremiacaoAtual() + 1);
            }
            jogador3.adicionarCardCoins(100);
            jogador3.atualizarNivel(1000);
            jogador3.setWins(jogador3.getWins() + 1);

            //Entrega dos passes
            if (jogador4.getWins() % 7 == 0) {
                PassePremium passePremium = new PassePremium();
                passePremium.entregarPremiacao(jogador4);
                passePremium.setPremiacaoAtual(passePremium.getPremiacaoAtual() + 1);
            } else if(jogador4.getWins() % 3 == 0){
                PasseComum passeComum = new PasseComum();
                passeComum.entregarPremiacao(jogador4);
                passeComum.setPremiacaoAtual(passeComum.getPremiacaoAtual() + 1);
            }
            jogador4.adicionarCardCoins(100);
            jogador4.atualizarNivel(1000);
            jogador4.setWins(jogador4.getWins() + 1);

            // Perdedores ganham 10 card coins
            super.getJogador1().adicionarCardCoins(10);
            super.getJogador1().atualizarNivel(500);

            super.getJogador2().adicionarCardCoins(10);
            super.getJogador2().atualizarNivel(500);
        }
        return vencedor;
    }
    
    // get e set
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

    public C_Carta[] getMaoJogador3() {
        return maoJogador3;
    }
    public void setMaoJogador3(C_Carta[] maoJogador3) {
        this.maoJogador3 = maoJogador3;
    }

    public C_Carta[] getMaoJogador4() {
        return maoJogador4;
    }
    public void setMaoJogador4(C_Carta[] maoJogador4) {
        this.maoJogador4 = maoJogador4;
    }

    public C_Carta[] getCemiterioJogador3() {
        return cemiterioJogador3;
    }
    public void setCemiterioJogador3(C_Carta[] cemiterioJogador3) {
        this.cemiterioJogador3 = cemiterioJogador3;
    }

    public C_Carta[] getCemiterioJogador4() {
        return cemiterioJogador4;
    }
    public void setCemiterioJogador4(C_Carta[] cemiterioJogador4) {
        this.cemiterioJogador4 = cemiterioJogador4;
    }

    public F_Lobby getLobby() {
        return lobby;
    }
    public void setLobby(F_Lobby lobby) {
        this.lobby = lobby;
    }

    // Método para chamar criarPartidasEmDuplaAleatoriamente() no lobby
    public void iniciarPartidasEmDuplaAleatoriamente() {
        if (lobby != null) {
            lobby.criarPartidasEmDuplaAleatoriamente();
        } else {
            System.out.println("Referência do lobby não definida(DEU RUIM NO iniciarPartidasEmDuplaAleatoriamente DE = G2.");
        }
    } 
}