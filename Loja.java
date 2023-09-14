import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

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

    public void compraDeBooster(Usuario usuario) {
        // Verificar se o usuário possui cardcoins suficientes para comprar um booster
        int precoBooster = 100; // Defina o preço do booster em cardcoins
        int cardcoinsDoUsuario = usuario.getCardCoins();

        if (cardcoinsDoUsuario >= precoBooster) {
            // O usuário tem cardcoins suficientes para comprar um booster
            Random random = new Random();
            int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

            for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simular a obtenção de cartas aleatórias
                Carta cartaAleatoria = gerarCartaAleatoria();


                // desenvolvimento apos implementar ENUM na 2ª fase
                // Verificar se o usuário já possui 3 unidades dessa carta
                /*  if (!usuario.getInventario().possuiMaximoCarta(cartaAleatoria)) {
                    // Adicionar a carta ao inventário do usuário
                    usuario.getInventario().adicionarCarta(cartaAleatoria);
                } else {
                    // O usuário já possui 3 unidades da carta, receber cardcoins
                    int valorCardcoins = 10; // Defina o valor a ser recebido em cardcoins
                    cardcoinsDoUsuario += valorCardcoins;
                }*/
            }

            // Deduzir o preço do booster dos cardcoins do usuário
            cardcoinsDoUsuario -= precoBooster;
            usuario.setCardCoins(cardcoinsDoUsuario);

            System.out.println("Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu inventário.");
        } else {
            System.out.println("Você não possui cardcoins suficientes para comprar um booster.");
        }
    }

  
    public Carta gerarCartaAleatoria() {
        // Simulação de geração de uma carta aleatória
        Random random = new Random();
        String[] nomesCartas = {"Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5"};
        String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
        int ataqueAleatorio = random.nextInt(10) + 1;
        int defesaAleatoria = random.nextInt(10) + 1;

        // carta retorna menos variaves devido a falta de metodos/ enums que serão efetuados na 2ª entrega
        
        int raridadeAleatoria = random.nextInt(5); // 0 a 4, representando raridade comum, incomum, rara, super rara, épica

        //esboco de nova carta
        return new Carta(nomeAleatorio, ataqueAleatorio, defesaAleatoria, raridadeAleatoria);
    }

}