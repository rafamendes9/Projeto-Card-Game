package CardGame;



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
    public C2_CartaShiny(String nome, String imagem, H4_EnumTipo tipo, H_Enum raridade,
    H3_EnumHabilidade habilidadeExtra, int ataque, int defesa, int custo) {
    super(nome, imagem, tipo, raridade, habilidadeExtra, ataque + 1, defesa + 1, custo);
    this.adicionarHabilidadeExtra(habilidadeExtra);
}

    private void adicionarHabilidadeExtra(H3_EnumHabilidade habilidadeExtra) {
        this.setHabilidade(habilidadeExtra);
    }
    

}
