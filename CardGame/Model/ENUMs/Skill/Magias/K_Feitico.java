package Model.ENUMs.Skill.Magias;

import Model.Cards.C_Carta;
import Model.ENUMs.H3_EnumHabilidade;

public class K_Feitico {
    public static void ativarHabilidade(H3_EnumHabilidade habilidade, C_Carta carta) {
        switch (habilidade) {
            case AMEDRONTAR:
                amedrontar(carta);
                break;
            case VENENO:
                veneno(carta);
                break;
            case ESCUDOREFLETOR:
                escudoRefletor(carta);
                break;
            case CURA:
                cura(carta);
                break;
            case ATROPELAR:
                atropelar(carta);
                break;
            case ARMADURA:
                armadura(carta);
                break;
            default:
                throw new IllegalArgumentException("Habilidade desconhecida: " + habilidade);
        }
    }

    private static void amedrontar(C_Carta carta) {
        // A habilidade "AMEDRONTAR" faz com que a defesa da carta alvo diminua em 3 pontos
        int novaDefesa = carta.getDefesa() - 3;
        carta.setDefesa(novaDefesa);
    }

    private static void veneno(C_Carta carta) {
        // A habilidade "VENENO" diminui 1 ponto de vida da carta alvo por 5 turnos
        System.out.println("Ativando efeito de veneno na carta " + carta.getNome());
    }

    private static void escudoRefletor(C_Carta carta) {
        // A habilidade "ESCUDOREFLETOR" faz com que o ataque da classe atacante vire 0 por 1 turno
        System.out.println("Ativando efeito de escudo refletor na carta " + carta.getNome());
    }

    private static void cura(C_Carta carta) {
        // A habilidade "CURA" restaura a vida da carta atacante em 5 pontos
        int novaVida = carta.getpontoVidaCarta() + 5;
        carta.setpontoVidaCarta(novaVida);
    }

    private static void atropelar(C_Carta carta) {
        // A habilidade "ATROPELAR" aumenta o dano da carta atacante em 4 pontos
        int novoAtaque = carta.getAtaque() + 4;
        carta.setAtaque(novoAtaque);
    }

    private static void armadura(C_Carta carta) {
        // A habilidade "ARMADURA" aumenta a defesa da carta em 6 pontos
        int novaDefesa = carta.getDefesa() + 6;
        carta.setDefesa(novaDefesa);
    }
}
