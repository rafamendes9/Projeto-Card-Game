package Model.Shops;
import java.util.Random;
import java.util.Scanner;

import Model.Cards.C2_CartaShiny;
import Model.Cards.C_Carta;
import Model.Exceptions.J4_InsufficientGemsException;
import Model.USER.A_Usuario;

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
    }

    @Override
    public void compras(Scanner scanner, A_Usuario usuario) throws J4_InsufficientGemsException {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu de Inicial de Loja ---");
            System.out.println("1. Comprar Booster Especial");
            System.out.println("2. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    boosterEspecial(usuario);
                    System.out.println("Parabens !!!!!!");
                    System.out.println("VOCE COMPROU UM BOOSTER DE CARTAS SHINY");
                    System.out.println("VOCE É O BRABO !!!!!!!!!!");
                    break;
                case 2:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }    
}