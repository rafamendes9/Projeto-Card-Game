package CardGame;

//import java.util.Random;

//classe antiga
/*import java.util.Random;

public class C2_CartaShiny extends C_Carta {
    public C2_CartaShiny(String nome, String imagem, H4_EnumTipo tipo, H_Enum raridade,
    H3_EnumHabilidade habilidade, int ataque, int defesa, int custo) {
        super(nome, imagem, tipo, raridade, habilidade, ataque + 1, defesa + 1, custo);
        this.adicionarHabilidadeExtra();
    }

    private void adicionarHabilidadeExtra() {
        // Pega uma habilidade extra aleatória do enum Habilidade
        H3_EnumHabilidade[] habilidades = H3_EnumHabilidade.values();
        Random random = new Random();
        int index = random.nextInt(habilidades.length);
        this.setHabilidade(this.getHabilidade() + ", " + habilidades[index].toString());
    }
    

}*/
//classe apos task de colocar enumHabilidade passando dentro de carta
public class C2_CartaShiny extends C_Carta {

    private H3_EnumHabilidade habilidadeExtra;

    public C2_CartaShiny(String nome, String imagem, H4_EnumTipo tipo, H_Enum raridade,
            H3_EnumHabilidade habilidadeAleatoria, int ataque, int defesa, int custo) {
        super(nome, imagem, tipo, raridade, habilidadeAleatoria, ataque + 1, defesa + 1, custo);
    }

    public H3_EnumHabilidade getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(H3_EnumHabilidade habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

    /*private H3_EnumHabilidade gerarRaridadeAleatoria() {
        Random random = new Random();
        double valorProbabilidade = random.nextDouble(); // Gera um valor de probabilidade aleatório entre 0 e 1

        // Mapeia o valor gerado para a raridade com base nas probabilidades do
        // H3_EnumHabilidade
        if (valorProbabilidade <= H3_EnumHabilidade.AMEDRONTAR.getHabilidadeExtra()) {
            return H3_EnumHabilidade.AMEDRONTAR;
        } else if (valorProbabilidade <= H3_EnumHabilidade.ATROPELAR.getHabilidadeExtra()) {
            return H3_EnumHabilidade.ATROPELAR;
        } else if (valorProbabilidade <= H3_EnumHabilidade.UNIR.getHabilidadeExtra()) {
            return H3_EnumHabilidade.UNIR;
        } else if (valorProbabilidade <= H3_EnumHabilidade.CURA.getHabilidadeExtra()) {
            return H3_EnumHabilidade.CURA;
        } else if (valorProbabilidade <= H3_EnumHabilidade.VENENO.getHabilidadeExtra()) {
            return H3_EnumHabilidade.VENENO;
        } else if (valorProbabilidade <= H3_EnumHabilidade.ESCUDOREFLETOR.getHabilidadeExtra()) {
            return H3_EnumHabilidade.ESCUDOREFLETOR;
        }
    }*/
}
