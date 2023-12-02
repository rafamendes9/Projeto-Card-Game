package Modelo;
public class C_Carta implements C3_AtivacaoCarta{
    private String nome;
    private String imagem;
    private H4_EnumTipo  tipo;
    private H_EnumRaridade raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private H3_EnumHabilidade habilidade;
    private int quantidade;
    private int pontoVidaCarta;
    private int mana;
    
   
    
    public C_Carta(String nome, String imagem, H4_EnumTipo tipo, H_EnumRaridade raridade, H3_EnumHabilidade habilidade,
            int ataque, int defesa, int custo, int pontoVidaCarta, int mana) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = 0; // Inicialmente, a quantidade é 0.
        this.pontoVidaCarta = pontoVidaCarta;
        this.mana = mana;
        
    }

    

   // Metodo  estaDisponivel ( perguntar para o professor onde implementar esse metodo)
/*
 * verifica se a quantidade de cartas desse tipo é maior que 0. Se a quantidade
 * for maior que 0, significa que pelo menos uma carta desse tipo está
 * disponível.
 * O método retorna true nesse caso, indicando que a carta está disponível. Caso
 * contrário, retorna false
 */
    public boolean estaDisponivel() {
        return quantidade > 0;
    }

     

    // Metodo 2 aumentarQuantidade ( perguntar para o professor onde implementar esse metodo)
/*
 * é usado para aumentar a quantidade de cartas desse tipo. Ele verifica se a
 * quantidade atual é menor do que 3 (o limite máximo permitido, exceto para
 * manas).
 * Se for menor que 3, ele aumenta a quantidade em 1. Isso permite que os
 * jogadores colecionem até 3 cartas de um tipo específico
 */

    public void aumentarQuantidade() {
        if (quantidade < 3) {
            quantidade++;
        }
    }


    //Método que foi criado pela interface
    @Override
    public void ativar(H3_EnumHabilidade habilidade) {
        // Implementação da ativação da habilidade da carta comum
        if (habilidade != null) {
            // Lógica específica para a ativação da habilidade da carta comum
            System.out.println("Ativando habilidade da carta: " + habilidade);
        }
    }


    // get set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public H4_EnumTipo  getTipo() {
        return tipo;
    }

    public void setTipo(H4_EnumTipo  tipo) {
        this.tipo = tipo;
    }

    public H_EnumRaridade getRaridade() {
        return raridade;
    }

    public void setRaridade(H_EnumRaridade raridade) {
        this.raridade = raridade;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public H3_EnumHabilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(H3_EnumHabilidade habilidade) {
        this.habilidade = habilidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidadee(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setpontoVidaCarta(int pontoVidaCarta) {
        this.pontoVidaCarta = pontoVidaCarta;
    }

    public int getpontoVidaCarta() {
        return pontoVidaCarta;
    }
    public int getCustoMana() {
        return mana;
    }

    // esse SETTER permite definir o valor da variável da variavel "quantidade"
    // metodo inclui uma verificação para garantir que a quantidade esteja dentro do
    // intervalo de 0 a 3
    public void setQuantidade(int quantidade) {
        if (quantidade >= 0 && quantidade <= 3) {
            this.quantidade = quantidade;
        } else {
            // Trata o limite de quantidade 
            // Isso garante que a quantidade seja válida.
            throw new IllegalArgumentException("A quantidade deve estar entre 0 e 3.");
        }
    }

    // metodo para  diminuir a vida da carta usado em arena
    public void calculoDeDiminuirPontosVidaCarta(int dano){
        dano -= defesa;
        int vidaSobrando = dano - pontoVidaCarta ;
        setpontoVidaCarta(vidaSobrando);

    }

}