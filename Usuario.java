public class Usuario {
   private String user;
   private String cpf;
   private String senha;
   private String sexo;
   private String email;
   private int cardCoins;
   private Deck[] baralho = new Deck [5];
<<<<<<< HEAD
   private Inventario option;
   private int nivel;

   public Usuario(String user, String cpf, String senha, String sexo, String email,int nivel, int cardCoins, Inventario option) {
    this.user = user;
    this.cpf = cpf;
    this.senha = senha;
    this.sexo = sexo;
    this.email = email;
    this.nivel = nivel;
    this.cardCoins = cardCoins;
    this.option = option;
=======
   private Inventario inventario;

    public Usuario(String user, String cpf, String senha, String sexo, String email, int cardCoins, Deck[] baralho, Inventario inventario) {
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.email = email;
        this.cardCoins = cardCoins;
        this.baralho = baralho;
        this.inventario = inventario;
>>>>>>> cdd5b216e4bebde8fc63cb73510a26ebc2cd843b
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
<<<<<<< HEAD
   public Inventario getOption(){
    return option;
   }
   public void setOption(Inventario option) {
    this.option = option;
   }
   public int getNivel() {
    return nivel;
   }

   // Não acho que esteja correto:
   //A ideia que não fosse possível mexer no nível se o número for maior que 3
   //Exception?
   public void setNivel(int nivel) {
    if(nivel > 3) {
        System.out.println("O nível " + this.getNivel() + " é inválido!");
    } else {
        this.nivel = nivel;
    }
   }
    
=======
   public Deck[] getBaralho(){
    return baralho;
   }
   public Inventario getInventario(){
    return inventario;
   }
   public void setInventario(Inventario inventario){
    this.inventario = inventario;
   }
>>>>>>> cdd5b216e4bebde8fc63cb73510a26ebc2cd843b
}
