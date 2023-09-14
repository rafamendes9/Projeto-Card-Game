public class Usuario {
   private String nome;
   private String cpf;
   private String senha;
   private String sexo;
   private String email;
   private int nivel = 1;
   private int cardCoins = 0;
   private Deck[] baralho = new Deck [5];
   private Inventario inventario;

   public Usuario(String nome, String cpf, String senha, String sexo, String email, int nivel, int cardCoins, Deck[] baralho, Inventario inventario) {
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
   public Deck[] getBaralho(){
    return baralho;
   }
   public Inventario getInventario(){
    return inventario;
   }
   public void setInventario(Inventario inventario){
    this.inventario = inventario;
   }
}
