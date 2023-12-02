package Model.Cards;

import java.util.Random;

import Model.ENUMs.H3_EnumHabilidade;
import Model.ENUMs.H4_EnumTipo;
import Model.ENUMs.H_EnumRaridade;

public class C2_CartaShiny extends C_Carta{

    private H3_EnumHabilidade habilidadeExtra;
    

    public C2_CartaShiny(String nome, String imagem, H4_EnumTipo tipo, H_EnumRaridade raridade,
                        int ataque, int defesa, int custo, int pontoVidaCarta, int mana) {
        super(nome, imagem, tipo, raridade, null, ataque + 1, defesa + 1, custo, pontoVidaCarta +2, mana - 1);
        this.habilidadeExtra = gerarHabilidadeAleatoriaExtra();
        nomearShiny();    
    }

    //metodo usado para adicionar uma raridade ao nome de forma que ele se apresente ainda mais UNICO
    public void nomearShiny() {
        Random random = new Random();
        char caractereShiny = (char) (random.nextInt(26) + 'A'); // Gera uma letra maiúscula aleatória (A-Z)
        setNome(getNome() + caractereShiny); // Atualiza o atributo 'nome' com o caractere aleatório
    }
    

    @Override
    public void aumentarQuantidade() {
        // Implementação específica para a classe C2_CartaShiny
        int aux = super.getQuantidade();
        aux++;
        super.setQuantidadee(aux);
    }

    public H3_EnumHabilidade gerarHabilidadeAleatoriaExtra() {
        Random random = new Random();
        int valorHabilidade = random.nextInt(6); // 0 a 5, representando habilidades

        switch (valorHabilidade) {
            case 0:
                return H3_EnumHabilidade.AMEDRONTAR;
            case 1:
                return H3_EnumHabilidade.ATROPELAR;
            case 2:
                return H3_EnumHabilidade.ARMADURA;
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

    //Método que foi criado pela interface 
    @Override
    public void ativar(H3_EnumHabilidade habilidade) {
        // Implementação da ativação da habilidade da carta shiny
        super.ativar(habilidade); // Chama a implementação da classe base (C_Carta)
        
        if (habilidadeExtra != null) {
            // Lógica específica para a ativação da habilidade extra da carta shiny
            System.out.println("Ativando habilidade extra da carta shiny: " + habilidadeExtra);
        }
    }

    //get set
    public H3_EnumHabilidade getHabilidadeExtra() {
        return habilidadeExtra;
    }
    public void setHabilidadeExtra(H3_EnumHabilidade habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }
}