package Modelo;
import java.util.Random;

public class E2_LojaShiny extends E_Loja {
    public E2_LojaShiny(String numeroCartao, String codigoVerificador) {
        super(numeroCartao, codigoVerificador);
    }

    public void boosterEspecial(A_Usuario usuario) throws J4_InsufficientGemsException {
        // Preço do booster especial (50% mais caro que o comum)
    
        int precoBoosterEspecial = (int) (getPrecoBoosterComum() * 1.5); //dessa forma altera o valor do booster sem mexer diretamente no metodo

        // Verificar se o usuário possui cardcoins suficientes para comprar o booster especial
        int cardgemsDoUsuario = usuario.getCardGems();
        try {
            if (cardgemsDoUsuario >= precoBoosterEspecial) {

                int quantidadeCartasBooster = 12; // Um booster contém 12 cartas aleatórias

                for (int i = 0; i < quantidadeCartasBooster; i++) {
                // Simula obtenção de cartas aleatórias com base nas probabilidades de raridade
                C_Carta novaCarta = gerarCartaAleatoria();


                // Verificar se a carta é única com 1% de probabilidade
                Random random = new Random();
                if (random.nextDouble() <= 0.01) {
                // Crie uma carta aleatória normal
                C_Carta novaCartaNormal  = gerarCartaAleatoria(); 


                    C2_CartaShiny novaCartaShiny = new C2_CartaShiny(
                    novaCartaNormal.getNome(),
                    novaCartaNormal.getImagem(),
                    novaCartaNormal.getTipo(),
                    novaCartaNormal.getRaridade(),
                    novaCartaNormal.getAtaque(),
                    novaCartaNormal.getDefesa(),
                    novaCartaNormal.getCusto(),
                    novaCartaNormal.getpontoVidaCarta(),
                    novaCartaNormal.getCustoMana()
                    );
            
            
                    usuario.getInventario().adicionarCartaShiny(novaCartaShiny);

            
                    } else {
                        // Adicionar a carta ao inventário do usuário
                        usuario.getInventario().adicionarCarta(novaCarta);
                    }
                }

                // Deduzir preço do booster especial dos cardcoins do usuário
                cardgemsDoUsuario -= precoBoosterEspecial;
                usuario.setCardCoins(cardgemsDoUsuario);

                System.out.println("Compra bem-sucedida! Você recebeu " + quantidadeCartasBooster + " cartas no seu inventário.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}