package CardGame;

import java.util.Random;

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
            int ataque, int defesa, int custo) {
        super(nome, imagem, tipo, raridade, null, ataque + 1, defesa + 1, custo);
        this.habilidadeExtra = gerarHabilidadeAleatoriaExtra();
    }

    public H3_EnumHabilidade getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(H3_EnumHabilidade habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

     private H3_EnumHabilidade gerarHabilidadeAleatoriaExtra() {
        Random random = new Random();
        int valorHabilidade = random.nextInt(6); // 0 a 5, representando habilidades

        switch (valorHabilidade) {
            case 0:
                return H3_EnumHabilidade.AMEDRONTAR;
            case 1:
                return H3_EnumHabilidade.ATROPELAR;
            case 2:
                return H3_EnumHabilidade.UNIR;
            case 3:
                return H3_EnumHabilidade.CURA;
            case 4:
                return H3_EnumHabilidade.VENENO;
            case 5:
                return H3_EnumHabilidade.ESCUDOREFLETOR;
            default:
                throw new IllegalArgumentException("Valor de Habilidade inválido: " + valorHabilidade);
        }
    }
}
