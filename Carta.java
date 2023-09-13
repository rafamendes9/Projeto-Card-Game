public class Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private String raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private String habilidade;


    public Carta (String nome, String imagem, String tipo, String raridade, String habilidade, int ataque, int defesa, int custo){
        this.nome = nome;
        this.imagem = imagem;
        //Qual tipo será imagem?
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getImagem(){
        return imagem;
    }
    public void setImagem(String imagem){
        this.imagem = imagem;
    }
    public String getTipo() {
        return tipo;
    } 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getRaridade (){
        return raridade;
    }
    public void setRaridade(String raridade){
       this.raridade = raridade; 
    }
    public int getAtaque(){
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa){
         this.defesa = defesa;
    }
    public int getCusto (){
        return custo;
    }
    public void setCusto(int custo){
        this.custo = custo;
    }
    public String getHabilidade (){
        return habilidade;
    }
    public void setHabilidade ( String habilidade){
        this.habilidade = habilidade;
    }
    public boolean estaDisponivel() {
        return false;
    }
    public void aumentarQuantidade() {
    }
    
}
