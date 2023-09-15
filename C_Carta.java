public class C_Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private C2_EnumRaridadeCarta raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private String habilidade;
    private int quantidade;

    //Atributo adicional
    //uso na fase 2
    private String TERRENO;
        
    public C_Carta(String nome, String imagem, String tipo, C2_EnumRaridadeCarta raridade, String habilidade, int ataque, int defesa, int custo) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = 0; // Inicialmente, a quantidade é 0.
    }
    

    //metodos

    //Metodo 1  estaDisponivel
    public boolean estaDisponivel() {
        return quantidade > 0;
    }


    //Metodo 2 aumentarQuantidade
    public void aumentarQuantidade() {
        if (quantidade < 3) {
            quantidade++;
        }
    }
           

















    
    //get set
    
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
    public C2_EnumRaridadeCarta getRaridade() {
        return raridade;
    }

    public void setRaridade(C2_EnumRaridadeCarta raridade) {
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
    public int getQuantidade() {
        return quantidade;
    }

    //esse SETTER permite definir o valor da variável da variavel "quantidade" 
    //metodo inclui uma verificação para garantir que a quantidade esteja dentro do intervalo de 0 a 3
    public void setQuantidade(int quantidade) {
        if (quantidade >= 0 && quantidade <= 3) {
            this.quantidade = quantidade;
        } else {
            // Trate o limite de quantidade aqui, por exemplo, lançando uma exceção.
            //Isso garante que a quantidade seja válida.
            throw new IllegalArgumentException("A quantidade deve estar entre 0 e 3.");
        }
    }
}
//Metodo 1  estaDisponivel 
/*verifica se a quantidade de cartas desse tipo é maior que 0. Se a quantidade for maior que 0, significa que pelo menos uma carta desse tipo está disponível. 
O método retorna true nesse caso, indicando que a carta está disponível. Caso contrário, retorna false */

//Metodo 2 aumentarQuantidade
/*é usado para aumentar a quantidade de cartas desse tipo. Ele verifica se a quantidade atual é menor do que 3 (o limite máximo permitido, exceto para manas).
 Se for menor que 3, ele aumenta a quantidade em 1. Isso permite que os jogadores colecionem até 3 cartas de um tipo específico*/

 /*métodos são úteis para controlar a quantidade de cartas de um tipo específico e garantir que as regras de limite sejam seguidas.
  Se os jogadores tentarem adicionar mais cartas do que o permitido, uma exceção será lançada para indicar que algo está errado */