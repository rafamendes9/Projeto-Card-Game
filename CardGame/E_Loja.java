package CardGame;
import java.util.Random;


public class E_Loja {
    private String numeroCartao;
    private String codigoVerificador;

    //novos atributos da 2 entrega
    private boolean promocao = false; // definido nao por padrao por n ter promocao / ainda sem uso em codigo da classe e metodo ( 3 entrega)
    private int precoBoosterComum = 100; // Preço do booster comum, definido como atributo de classe para facilitar a modificar varios metodos de compra

    public E_Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    // metodo compra booster

    public void compraDeBooster(A_Usuario usuario) {
        // Verificar se o usuário possui cardcoins suficientes para comprar um booster
        
        int cardcoinsDoUsuario = usuario.getCardCoins();

        if (cardcoinsDoUsuario >= precoBoosterComum) { // verifica se o usuário tem cardcoins suficientes para comprar um booster

            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simula obtenção de cartas aleatórias
                C_Carta novaCarta = gerarCartaAleatoria(); 

                // Verificar se o usuário já possui 3 unidades dessa carta (exceto mana)
                if (!novaCarta.getNome().equals("mana") && usuario.getInventario().possuiMaximoCarta(novaCarta)) {
                    // O usuário já possui 3 unidades da carta, receber cardcoins
                    int valorCardcoins = 10; // Defina o valor a ser recebido em cardcoins
                    cardcoinsDoUsuario += valorCardcoins;
                } else {
                    // Adicionar a carta ao inventário do usuário
                    usuario.getInventario().adicionarCarta(novaCarta);
                }
            }
           
            // Deduzir preço do booster dos cardcoins do usuário
            cardcoinsDoUsuario -= precoBoosterComum;
            usuario.setCardCoins(cardcoinsDoUsuario);

            System.out.println(
                    "Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu inventário.");

        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

    // metodo cria uma carta aleatória simulada com base em alguns critérios, como
    // nome aleatório, valores de ataque, defesa e raridade aleatórios | nao coloquei o imagem random aqui ( fase 2)

    //!!!!!!!!!!!!!!!!!!!URGENTE GERAR IMAGEM OU PEGAR EM ENUM + resto de atributos da carta!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
   /* 
   public C_Carta gerarCartaAleatoria() {
        Random random = new Random();
        String[] nomesCartas = { "Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5", "Carta 6" };//nome da carta random
        String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
        int ataqueAleatorio = random.nextInt(10) + 1;
        int defesaAleatoria = random.nextInt(10) + 1;

        // Define os valores de raridade conforme o J_Enum
        J_Enum raridadeAleatoria = gerarRaridadeAleatoria();

        // Criação da carta com os valores aleatórios
        // imagem | tipo | habilidade | custo ( FASE 2) desenvolvimento ENUM !!!!!!!
        C_Carta cartaAleatoria = new C_Carta(nomeAleatorio, null, null, raridadeAleatoria, null, ataqueAleatorio,
                defesaAleatoria, 0);

        return cartaAleatoria;
    }
  
    private J_Enum gerarRaridadeAleatoria() {
        Random random = new Random();
        int valorRaridade = random.nextInt(5); // 0 a 4, representando raridade NORMAL, RARA, EPICA, LENDARIA, MITICA( nomes mudados e explicado no J_Enum)

        // Mapea o valor gerado em J_Enum
        switch (valorRaridade) {
            case 0:
                return J_Enum.NORMAL;
            case 1:
                return J_Enum.RARA;
            case 2:
                return J_Enum.EPICA;
            case 3:
                return J_Enum.LENDARIA;
            case 4:
                return J_Enum.MITICA;
            default:
                // Lida com casos inesperados, se necessário( caso o random bug)
                throw new IllegalArgumentException("Valor de raridade inválido: " + valorRaridade);
        }
    }*/

    // get set
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    //get/set entrega 2 inserido por preco boster ser atributo da classe ao inves de local
    public int getPrecoBoosterComum() {
        return precoBoosterComum;
    }

    public void setPrecoBoosterComum(int precoBoosterComum) {
        this.precoBoosterComum = precoBoosterComum;
    }

    public boolean getPromocao() {
        return promocao;
    }
    
    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }



//espaço para novos metodo de desenvolvimento 2 entrega !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //metodo extra para verificar promocao
    public boolean isPromocao() {
    return promocao = true;
    }


    //agora o metodo recebe valores aleatorios de raridade fixo ( definido no enum)
    public C_Carta gerarCartaAleatoria() {
    Random random = new Random();
    String[] nomesCartas = { "Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5", "Carta 6" }; // Nome da carta random
    String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
    int ataqueAleatorio = random.nextInt(10) + 1;
    int defesaAleatoria = random.nextInt(10) + 1;
    int custoAleatorio = random.nextInt(10) + 1;

    // Gera uma raridade aleatória com base nas probabilidades do J_Enum
    H_Enum raridadeAleatoria = gerarRaridadeAleatoria();

    // Criação da carta com os valores aleatórios e a raridade
    // imagem | tipo | habilidade | custo ( FASE 2) desenvolvimento ENUM !!!!!!!
    C_Carta cartaAleatoria = new C_Carta(nomeAleatorio, null, null, raridadeAleatoria, null, ataqueAleatorio,
            defesaAleatoria, custoAleatorio);

    return cartaAleatoria;
  }  

    //metodo refeito para se adequar a raridade fixa
    private H_Enum gerarRaridadeAleatoria() { 
    Random random = new Random();
    double valorProbabilidade = random.nextDouble(); // Gera um valor de probabilidade aleatório entre 0 e 1

    // Mapeia o valor gerado para a raridade com base nas probabilidades do J_Enum
    if (valorProbabilidade <= H_Enum.MITICA.getDropProbabilidade()) {
        return H_Enum.MITICA;
    } else if (valorProbabilidade <= H_Enum.LENDARIA.getDropProbabilidade()) {
        return H_Enum.LENDARIA;
    } else if (valorProbabilidade <= H_Enum.EPICA.getDropProbabilidade()) {
        return H_Enum.EPICA;
    } else if (valorProbabilidade <= H_Enum.RARA.getDropProbabilidade()) {
        return H_Enum.RARA;
    } else {
        return H_Enum.NORMAL;
    }
  }



   // booster especial para a carta "SHINY"


}
