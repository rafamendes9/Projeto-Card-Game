package CardGame;
public class A_Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private String sexo;
    private String email;
    private int nivel = 1;
    private int cardCoins = 0;
    private D_Deck[] baralho = new D_Deck[5];
    private B_Inventario inventario;

    // atributos adicionais
    private int idade;
    private String ModoDeJogo; // Atributo para armazenar a modalidade de LOBBY / MODO DE JOGO / mudar para classe lobby
    private int pontosVida; // Atributo para armazenar vida do jogador usado em ARENA
    private boolean emTime; // Atributo utilizado no novo modo de Jogo 2Px2P
    private int numeroTime; // Atributo utilizado no novo modo de Jogo 2Px2P

    public A_Usuario(String nome, String cpf, String senha, String sexo, String email, int nivel, int cardCoins,
            D_Deck[] baralho, B_Inventario inventario) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.email = email;
        this.nivel = nivel;
        this.cardCoins = cardCoins;
        this.baralho = baralho;
        this.inventario = inventario;
    }

    // 1 metodo toString que retorna uma representação de string formatada do objeto
    // útil para depuração e para exibir informações do usuário.
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nNível: " + nivel + "\nCardCoins: " + cardCoins;
    }

    // 2 metodo para adicionar decks
    public boolean adicionarDeck(D_Deck deck) {
        // Verifica se o usuário já possui o número máximo de decks permitidos (5)
        if (baralho.length >= 5) {
            System.out.println("Você já atingiu o número máximo de decks permitidos.");
            return false; // Não foi possível adicionar o deck
        }

        // Verifica se o deck já está na lista ( evita clone de deck)
        for (D_Deck existingDeck : baralho) {
            if (existingDeck != null && existingDeck.getNome().equals(deck.getNome())) {
                System.out.println("Este deck já está na sua lista de decks.");
                return false; // Não foi possível adicionar o deck
            }
        }

        // Encontra um espaço vazio no vetor de decks ( remodelado para evitar criar um vetor de vazios ao editar decks novos)
        for (int i = 0; i < baralho.length; i++) {
            if (baralho[i] == null) {
                baralho[i] = deck; // Adiciona o deck ao vetor de decks
                System.out.println("Deck adicionado com sucesso.");
                return true; // Deck adicionado com sucesso
            }
        }

        return false; // Não foi possível adicionar o deck (nenhum espaço vazio encontrado)
    }

     // Método para validar CPF (modelo simples, vai ser trocado por uma melhor na segunda fase
        private boolean validarCPF(String cpf) {
        // Lógica de validação de CPF aqui (vai ser mais elaborada)
        return cpf != null && cpf.matches("\\d{11}");
    }

    // 3 metodo validacao
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

        // Adicione outras validações conforme necessário

        // Se todas as validações passaram, retorna true
        return true;
    }
  
   
    public void diminuirPontosVida(int quantidade) {
        if (quantidade > 0) {
            pontosVida -= quantidade;
            if (pontosVida < 0) {
                pontosVida = 0; // Garante que os pontos de vida nao fique negativo

            }
        }
    }

     //!!!!!!!!!!!!!!!!!!!!!URGENTE 4 metodo atualizar nivel | ( desenvolvida na entrega 2)!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void atualizarNivel(int pontuacao) {
        // Vai ser desenvolvido a lógica para atualizar o nível aqui 
        if (pontuacao >= 1000) { // Exemplo: Quando a pontuação atinge 1000 pontos, aumente o nível
            nivel++; // Aumente o nível em 1
        }
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!! esse metodo apenas existe ate o momento
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!! metodo vinculado a debate em uso de novos metodos de Arena ( coisas do slide da entrega 2)
    public void configurarDeckInicial() {
    }

    // ( desenvolvida na entrega 2) !!!!!!!!!!!! esse metodo apenas existe ate o momento
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!! metodo vinculado a debate em uso de novos metodos de Arena ( coisas do slide da entrega 2)
    public void fazerTurno() {
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
    public void setBaralho(int indice, D_Deck novoBaralho) {
        if (indice >= 0 && indice < 5) {
            baralho[indice] = novoBaralho;
        }
    }

    // indice baralho
    public D_Deck getBaralho(int indice) {
        if (indice >= 0 && indice < 5) {
            return baralho[indice];
        } else {
            return null; // Retorna nulo se o índice estiver fora do intervalo
        }
    }

    // Adiciona metodo para obter todos os baralhos do jogador
    public D_Deck[] getTodosBaralhos() {
        return baralho;
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

}

/*
 * metodo 1 toString
 * 
 * ele depura e exibr informações do usuário.
 * 
 */
/*
 * metodo 2 adicionar decks
 * 
 * Ele verifica se o usuário já atingiu o número máximo de decks permitidos (5)
 * e, se sim, retorna false.
 * 
 * Em seguida, ele verifica se o deck já está na lista de decks do usuário. Se
 * estiver, também retorna false.
 * 
 * Se o deck não estiver na lista e ainda houver espaço disponível no vetor de
 * decks, ele adiciona o deck à primeira posição vazia encontrada.
 * 
 * Finalmente, ele retorna true se o deck for adicionado com sucesso e false se
 * não puder ser adicionado (porque o usuário atingiu o limite de decks ou
 * porque o deck já estava na lista).
 */
/*
 * metodo 3 validacoes
 * 
 * Validação de CPF: Verifica(simples) se o CPF é válido.
 * 
 * Validação de idade: Verifica se o usuário tem pelo menos 18 anos para criar
 * uma conta.(pode ser alterado em "if (idade < 18)")
 * 
 * Validação de senha: Exige que a senha tenha pelo menos 8 caracteres. (Você
 * pode ajustar essa validação de acordo com seus requisitos de senha).
 */
/*
 * metodo 4 atualizar nivel ( metodo exploratorio para proxima entrega)
 * método atualizarNivel recebe a pontuação atual do usuário como argumento.
 * (pode definir sua lógica específica para atualizar o nível) com base na
 * pontuação atual.
 * No exemplo dado, quando a pontuação atinge 1000 pontos, o nível é aumentado
 * em 1
 */