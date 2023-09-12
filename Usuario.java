public class Usuario {
    private String user;
   private String cpf;
   private String senha;
   private String sexo;
   private String email;
   private int cardCoins;
   private Deck[] baralho = new Deck [5];

   public Usuario(String user, String cpf, String senha, String sexo, String email, int cardCoins) {
    this.user = user;
    this.cpf = cpf;
    this.senha = senha;
    this.sexo = sexo;
    this.email = email;
    this.cardCoins = cardCoins;
   }
   public String getUser(){
    return user;
   }
   public void setUser(String user){
    this.user = user;
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
   public int getCardCoins() {
    return cardCoins;
   }
   public void setCardCoins(int cardCoins) {
    this.cardCoins = cardCoins;
   }
    
}
