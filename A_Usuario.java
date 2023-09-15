public class A_Usuario {
   private String nome;
   private String cpf;
   private String senha;
   private String sexo;
   private String email;
   private int nivel = 1;
   private int cardCoins = 0;
   private D_Deck[] baralho = new D_Deck [5];
   private B_Inventario inventario;

   // atributos adicionais
   private int idade;

   public A_Usuario(String nome, String cpf, String senha, String sexo, String email, int nivel, int cardCoins, D_Deck[] baralho, B_Inventario inventario) {
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

   //1 metodo  toString que retorna uma representação de string formatada do objeto útil para depuração e para exibir informações do usuário.
   @Override
   public String toString() {
      return "Nome: " + nome + "\nCPF: " + cpf + "\nNível: " + nivel + "\nCardCoins: " + cardCoins;
   }
   
   //2 metodo para adicionar decks
   public boolean adicionarDeck(D_Deck deck) {
      // Verifica se o usuário já possui o número máximo de decks permitidos (5)
      if (baralho.length >= 5) {
          System.out.println("Você já atingiu o número máximo de decks permitidos.");
          return false; // Não foi possível adicionar o deck
      }
  
      // Verifica se o deck já está na lista
      for (D_Deck existingDeck : baralho) {
          if (existingDeck != null && existingDeck.getNome().equals(deck.getNome())) {
              System.out.println("Este deck já está na sua lista de decks.");
              return false; // Não foi possível adicionar o deck
          }
      }
  
      // Encontra um espaço vazio no vetor de decks
      for (int i = 0; i < baralho.length; i++) {
          if (baralho[i] == null) {
              baralho[i] = deck; // Adiciona o deck ao vetor de decks
              System.out.println("Deck adicionado com sucesso.");
              return true; // Deck adicionado com sucesso
          }
      }
  
      return false; // Não foi possível adicionar o deck (nenhum espaço vazio encontrado)
   }
  
   //3 metodo validacao 
   public boolean validacoes() {
      // Validação de CPF
      if (!validarCPF(cpf)) {
          System.out.println("CPF inválido.");
          return false;
      }
  
      
      // Validação de idade
      if (idade < 18) {
          System.out.println("Você deve ter pelo menos 18 anos para criar uma conta.");
          return false;
      }
  
      // Validação de senha (por exemplo, exigindo uma senha com pelo menos 8 caracteres)
      if (senha.length() < 8) {
          System.out.println("A senha deve ter pelo menos 8 caracteres.");
          return false;
      }
  
      // Adicione outras validações conforme necessário
  
      // Se todas as validações passaram, retorna true
      return true;
  }
  
  // Método para validar CPF (exemplo simples, pode ser substituído por uma lógica mais robusta)
  private boolean validarCPF(String cpf) {
      // Lógica de validação de CPF aqui (pode ser mais elaborada)
      return cpf != null && cpf.matches("\\d{11}");
  }
  
  //4 metodo atualizar nivel | metodo exploratorio para proximas entregas
   public void atualizarNivel(int pontuacao) {
      // Defina sua lógica para atualizar o nível aqui | Por exemplo, se a pontuação atingir um certo limite, aumente o nível
      if (pontuacao >= 1000) { // Exemplo: Quando a pontuação atinge 1000 pontos, aumente o nível
          nivel++; // Aumente o nível em 1
      }
  }







   //get set
   public String getNome(){
    return nome;
   }
   public void setNome(String nome){
    this.nome = nome;
   }
   public String getCpf(){
    return cpf;
   }
   public void setCpf(String cpf){
    this.cpf = cpf;
   }
   public String getSenha(){
    return senha;
   }
   public void setSenha(String senha){
    this.senha = senha;
   }
   public String getSexo(){
    return sexo;
   }
   public void setSexo(String sexo) {
    this.sexo = sexo;
   }
   public String getEmail(){
    return email;
   }
   public void setEmail(String email){
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
   public D_Deck[] getBaralho(){
    return baralho;
   }
   public B_Inventario getInventario(){
    return inventario;
   }
   public void setInventario(B_Inventario inventario){
    this.inventario = inventario;
   }
}

/* metodo 1 toString

   ele depura e exibr informações do usuário.
  
 */
/* metodo 2 adicionar decks

     Ele verifica se o usuário já atingiu o número máximo de decks permitidos (5) e, se sim, retorna false.

    Em seguida, ele verifica se o deck já está na lista de decks do usuário. Se estiver, também retorna false.

    Se o deck não estiver na lista e ainda houver espaço disponível no vetor de decks, ele adiciona o deck à primeira posição vazia encontrada.

    Finalmente, ele retorna true se o deck for adicionado com sucesso e false se não puder ser adicionado (porque o usuário atingiu o limite de decks ou porque o deck já estava na lista).
 */
/* metodo 3 validacoes 

    Validação de CPF: Verifica(simples) se o CPF é válido.

    Validação de idade: Verifica se o usuário tem pelo menos 18 anos para criar uma conta.(pode ser alterado em "if (idade < 18)")

    Validação de senha: Exige que a senha tenha pelo menos 8 caracteres. (Você pode ajustar essa validação de acordo com seus requisitos de senha).
    */
/* metodo 4 atualizar nivel ( metodo exploratorio para proxima entrega)
   método atualizarNivel recebe a pontuação atual do usuário como argumento.
   (pode definir sua lógica específica para atualizar o nível) com base na pontuação atual.
   No exemplo dado, quando a pontuação atinge 1000 pontos, o nível é aumentado em 1. 
 */