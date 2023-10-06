import java.util.Random;

public class C2_CartaShiny extends C_Carta {
    public C2_CartaShiny(String nome, String imagem, String tipo, H_Enum raridade,
    String habilidade, int ataque, int defesa, int custo) {
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
    

}
