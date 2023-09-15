import java.util.Random;

public class E_Loja {
    private String numeroCartao;
    private String codigoVerificador;

    public E_Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }













    // metodo compra booster
   
    public void compraDeBooster(A_Usuario usuario) {
        // Verificar se o usuário possui cardcoins suficientes para comprar um booster
        int precoBooster = 100; // Defina o preço do booster em cardcoins
        int cardcoinsDoUsuario = usuario.getCardCoins();
    
        if (cardcoinsDoUsuario >= precoBooster) { // verifica se o usuário tem cardcoins suficientes para comprar um booster
           
            //Random random = new Random();
            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias
    
            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simular a obtenção de cartas aleatórias
                C_Carta novaCarta = gerarCartaAleatoria(); // Supondo que você tenha uma função para gerar uma C_Carta aleatória
    
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
    
            // Deduzir o preço do booster dos cardcoins do usuário
            cardcoinsDoUsuario -= precoBooster;
            usuario.setCardCoins(cardcoinsDoUsuario);
    
            System.out.println("Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu inventário.");
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }


    //metodo cria uma carta aleatória simulada com base em alguns critérios, como nome aleatório, valores de ataque, defesa e raridade aleatórios

    public C_Carta gerarCartaAleatoria() {
        Random random = new Random();
        String[] nomesCartas = {"Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5"};
        String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
        int ataqueAleatorio = random.nextInt(10) + 1;
        int defesaAleatoria = random.nextInt(10) + 1;
    
        // Define os valores de raridade conforme o C2_EnumRaridadeCarta
        C2_EnumRaridadeCarta raridadeAleatoria = gerarRaridadeAleatoria();
    
        // Criação da carta com os valores aleatórios
        C_Carta cartaAleatoria = new C_Carta(nomeAleatorio, null, null, raridadeAleatoria, null, ataqueAleatorio, defesaAleatoria, 0);
    
        return cartaAleatoria;
    }
    
    private C2_EnumRaridadeCarta gerarRaridadeAleatoria() {
        Random random = new Random();
        int valorRaridade = random.nextInt(5); // 0 a 4, representando raridade comum, incomum, rara, muito rara, épica
    
        // Mapea o valor gerado em C2_EnumRaridadeCarta.
        // Aqui, estamos supondo um mapeamento direto dos valores.
        switch (valorRaridade) {
            case 0:
                return C2_EnumRaridadeCarta.NORMAL;
            case 1:
                return C2_EnumRaridadeCarta.RARA;
            case 2:
                return C2_EnumRaridadeCarta.EPICA;
            case 3:
                return C2_EnumRaridadeCarta.LENDARIA;
            case 4:
                return C2_EnumRaridadeCarta.MITICA;
            default:
                // Lida com casos inesperados, se necessário
                throw new IllegalArgumentException("Valor de raridade inválido: " + valorRaridade);
        }
    }








  




    

    //get set
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


}
