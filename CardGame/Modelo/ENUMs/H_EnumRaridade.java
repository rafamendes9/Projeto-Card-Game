package Modelo.ENUMs;
public enum H_EnumRaridade {
    /* foi trocado os nomes do enum  de Comum | Incomum | Rara | Muito rara |  Épica
    para fins mais esteticos e de facil entendimento.
*/
    NORMAL(0.8),  // Probabilidade: 80%
    RARA(0.15),   // Probabilidade: 15%
    EPICA(0.04),  // Probabilidade: 4%
    LENDARIA(0.008),  // Probabilidade: 0.8%
    MITICA(0.002); // Probabilidade: 0.2%

    private double dropProbabilidade; // Probabilidade de drop

    // Construtor privado para associar a probabilidade a cada raridade
    private H_EnumRaridade(double dropProbabilidade) {
        this.dropProbabilidade = dropProbabilidade;
    }

    // Método para obter a probabilidade de drop
    public double getDropProbabilidade() {
        return dropProbabilidade;
    }
}


