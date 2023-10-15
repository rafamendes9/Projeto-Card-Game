package CardGame;

import java.util.List;
import java.util.Random;

public class A_Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private String sexo;
    private String email;
    private int nivel = 1;
    private int cardCoins = 0;
    private D_Deck[] indiceBaralho = new D_Deck[5];
    private B_Inventario inventario;

    // atributos adicionais
    private int idade;
    private String ModoDeJogo; // Atributo para armazenar a modalidade de LOBBY / MODO DE JOGO / mudar para classe lobby
    private int pontosVida; // Atributo para armazenar vida do jogador usado em ARENA
    private boolean emTime; // Atributo utilizado no novo modo de Jogo 2Px2P
    private int numeroTime; // Atributo utilizado no novo modo de Jogo 2Px2P
    private int manaDoJogador;
    private List<C_Carta> deck;
    private List<C_Carta> mao;

    public A_Usuario(String nome, String cpf, String senha, String sexo, String email, int nivel, int cardCoins,
            D_Deck[] indiceBaralho, B_Inventario inventario) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.email = email;
        this.nivel = nivel;
        this.cardCoins = cardCoins;
        this.indiceBaralho = indiceBaralho;
        this.inventario = inventario;
    }
   

    // metodo para adicionar decks
    public boolean adicionarDeck(D_Deck deck) {
        // Verifica se o usuário já possui o número máximo de decks permitidos (5)
        if (indiceBaralho.length >= 5) {
            System.out.println("Você já atingiu o número máximo de decks permitidos.");
            return false; // Não foi possível adicionar o deck
        }

        // Verifica se o deck já está na lista ( evita clone de deck)
        for (D_Deck existingDeck : indiceBaralho) {
            if (existingDeck != null && existingDeck.getNome().equals(deck.getNome())) {
                System.out.println("Este deck já está na sua lista de decks.");
                return false; // Não foi possível adicionar o deck
            }
        }

        // Encontra um espaço vazio no vetor de decks ( remodelado para evitar criar um vetor de vazios ao editar decks novos)
        for (int i = 0; i < indiceBaralho.length; i++) {
            if (indiceBaralho[i] == null) {
                indiceBaralho[i] = deck; // Adiciona o deck ao vetor de decks
                System.out.println("Deck adicionado com sucesso.");
                return true; // Deck adicionado com sucesso
            }
        }

        return false; // Não foi possível adicionar o deck (nenhum espaço vazio encontrado)
    }

     // Método para validar CPF (modelo simples, vai ser trocado por uma melhor na segunda fase
        public boolean validarCPF(String cpf) {
        // Lógica de validação de CPF aqui (vai ser mais elaborada)
        return cpf != null && cpf.matches("\\d{11}");
    }

    //  metodo validacao
    public boolean validacoes() {
        // Validação de CPF
        if (!validarCPF(cpf)) {
            System.out.println("CPF inválido.");
            return false;
        }

        // Validação de idade ( maior de idade para jogar)
        if (idade < 18) {
            System.out.println("Você deve ter pelo menos 18 anos para criar uma conta.");
            return false;
        }

        // Validação de senha (por exemplo, exigindo uma senha com pelo menos 8
        // caracteres)
        if (senha.length() < 8) {
            System.out.println("A senha deve ter pelo menos 8 caracteres.");
            return false;
        }

        // Se todas as validações passaram, retorna true
        return true;
    }
  
   
    public void atualizarNivel(int pontuacao) {
           if (pontuacao >= 1000) { // Exemplo: Quando a pontuação atinge 1000 pontos, aumente o nível
            nivel++; // Aumente o nível em 1
        }
    }

  
    public void adicionarCardCoins(int x){
        cardCoins += x;
    }


    public C_Carta[] escolherCartasDoIndiceBaralho(int i) {
        if (i >= 0 && i <= 4) {
            switch (i) {
                case 0:
                    return indiceBaralho[0].getCartas();
                case 1:
                    return indiceBaralho[1].getCartas();
                case 2:
                    return indiceBaralho[2].getCartas();
                case 3:
                    return indiceBaralho[3].getCartas();
                case 4:
                    return indiceBaralho[4].getCartas();
                default:
                    System.out.println("Escolha quais cartas serão sacadas. E escolha entre 0 a 4.");
                    break;
            }
        }
        return null;  
    }


    public C_Carta retornarCartaParaDeck(int posicao) {
        if (posicao >= 0 && posicao < mao.size()) {
            // Pega a carta da mão na posição especificada
            C_Carta carta = mao.get(posicao);

            // Remove a carta da mão
            mao.remove(posicao);

            // Adiciona a carta de volta ao deck (baralho)
            deck.add(carta);

           return carta;
        } else {
            System.out.println("Posição de mão inválida.");
            return null; // Ou lança uma exceção, dependendo do comportamento desejado
        }
    }

    
    
    public C_Carta sacarCartaAleatoriaDoDeckREROLL() {
        Random random = new Random();
        int tamanhoDoDeck = deck.size();
        
        if (tamanhoDoDeck > 0) {
            int indiceAleatorio = random.nextInt(tamanhoDoDeck);
            C_Carta carta = deck.remove(indiceAleatorio); // Remove a carta do deck
            return carta;
        } else {
            // Lida com o caso em que o deck está vazio (nenhuma carta para sacar)
            return null;
        }
    }

  
    // get set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCardCoins() {
        return cardCoins;
    }

    public void setCardCoins(int cardCoins) {
        this.cardCoins = cardCoins;
    }

    // indice baralho
    public void setIndiceBaralhoNovo(int indice, D_Deck novoBaralho) {
        if (indice >= 0 && indice < 5) {
            indiceBaralho[indice] = novoBaralho;
        }
    }

    // indice baralho
    public D_Deck getIndiceBaralho(int indice) {
        if (indice >= 0 && indice < 5) {
            D_Deck test = indiceBaralho[indice];
            return test;
        } else {
            return null; // Retorna nulo se o índice estiver fora do intervalo
        }
    }

   

    // Adiciona metodo para obter todos os baralhos do jogador
    public D_Deck[] getTodosBaralhos() {
        return indiceBaralho;
    }

    public B_Inventario getInventario() {
        return inventario;
    }

    public void setInventario(B_Inventario inventario) {
        this.inventario = inventario;
    }

    public String getModoDeJogo() {
        return ModoDeJogo;
    }

    public void setModoDeJogo(String modalidade) {
        this.ModoDeJogo = modalidade;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public Object getDeckJogador() {
        return null;
    }

    //Modo em Dupla 2Px2P
    public boolean isEmTime() {
        return emTime;
    }

    public void setEmTime(boolean emTime) {
        this.emTime = emTime;
    }

    public int getNumeroTime() {
        return numeroTime;
    }

    public void setNumeroTime(int numeroTime) {
        this.numeroTime = numeroTime;
    }

    public Object getMao() {
        return null;
    }

    public int getManaDoJogador() {
        return manaDoJogador;
    }

    public void setManaDoJogador(int manaDoJogador) {
        this.manaDoJogador = manaDoJogador;
    }
    
}
