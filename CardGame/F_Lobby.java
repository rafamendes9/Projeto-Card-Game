package CardGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class F_Lobby {
    private List<A_Usuario> usuarios;
    private List<G_Arena> arenas;

    /*
     * Neste construtor, duas listas vazias são inicializadas: usuarios e arenas.
     * Essas listas são usadas para rastrear os usuários no lobby e as arenas em que
     * as partidas ocorrem
     */
    public F_Lobby() {
        usuarios = new ArrayList<>();
        arenas = new ArrayList<>();
    }

    /*
     * Metodo permite que um jogador entre no lobby.
     * Primeiro, o jogador é adicionado à lista de usuarios.
     * Em seguida, chamamos o método emparelharUsuarios(usuario) para procurar um
     * oponente compatível para o jogador recém-adicionado.
     */
    public void adicionarUsuario(A_Usuario usuario) {
        usuarios.add(usuario);
        emparelharUsuarios(usuario);
    }

    /*
     * método responsável por procurar um oponente compatível para um jogador
     * recém-adicionado ao lobby.
     * 
     * Ele itera sobre a lista de usuários (usuarios) e verifica se o jogador é
     * diferente do oponente, se eles têm o mesmo nível e se estão jogando na mesma
     * modalidade.
     * 
     * Quando um oponente compatível é encontrado, chamamos o método criarPartida
     * para iniciar uma partida entre esses dois jogadores.
     * 
     * O return é usado para interromper a busca por oponentes após o emparelhamento
     * bem-sucedido.
     * 
     * Se nenhum oponente compatível for encontrado, printa a mensagem
     * "Aguardando oponente...".
     */

    private void emparelharUsuarios(A_Usuario usuario) {
        for (A_Usuario oponente : usuarios) {
            if (oponente != usuario && oponente.getNivel() == usuario.getNivel()//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ver possibilidade para alterar nivel de igual para + nivel aproximado!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    && oponente.getModoDeJogo().equals(usuario.getModoDeJogo())) {

                // Encontrou um oponente com deck e ModoDeJogo correspondentes
                criarPartida(usuario, oponente);
                return; // Pare de procurar por oponentes após emparelhar
            }
        }
        // Se nenhum oponente foi encontrado, aguarde até que um esteja disponível
        System.out.println("Aguardando oponente...");
    }

    /*
     * Metodo cria uma partida entre dois jogadores, desde que essas condições sejam
     * atendidas:
     * 
     * -Ambos os jogadores (jogador1 e jogador2) não sejam nulos ( eles tem q
     * existir).
     * -Ambos os jogadores tenham um baralho disponível (ou seja, seus baralhos não
     * são nulos( ele tem q existir)).
     * 
     * Se essas condições não forem atendidas, o método printa mensagens de erro
     * apropriadas.
     */

    public void criarPartida(A_Usuario jogador1, A_Usuario jogador2) {
        if (jogador1 != null && jogador2 != null) {
            // Verifique se os jogadores têm decks disponíveis
            if (jogador1.getBaralho(0) != null && jogador2.getBaralho(0) != null) {
                // Remova os jogadores da lista de usuários
                usuarios.remove(jogador1);
                usuarios.remove(jogador2);

                // Crie uma nova arena com os jogadores
                G_Arena arena = new G_Arena(jogador1, jogador2);

                arenas.add(arena);

                // Inicie a partida na arena
                arena.iniciarPartida();
            } else {
                System.out.println("Um ou ambos os jogadores não têm decks disponíveis.");
            }
        } else {
            System.out.println("Aguardando mais jogadores para criar uma partida.");
        }
    }

    // Metodo permite que um objeto do tipo A_Usuario (que representa um jogador)
    // adicione seu baralho à lista de usuários no lobby.
    // de forma flexivel a criarPartida

    public void adicionarBaralho(A_Usuario usuario, D_Deck baralho) {
        if (usuario != null && baralho != null) {
            // Verifique se o jogador já tem um baralho carregado
            if (usuario.getBaralho(0) == null) {
                // Associe o baralho ao jogador
                usuario.setBaralho(0, baralho);
                // Adicione o jogador à lista de usuários do lobby
                usuarios.add(usuario);
                System.out.println("Baralho adicionado com sucesso!");
            } else {
                System.out.println("O jogador já possui um baralho carregado.");
            }
        } else {
            System.out.println("Parâmetros inválidos.");
        }
    }

    
     // Método para criar partidas em dupla aleatoriamente.
     
    public void criarPartidasEmDuplaAleatoriamente() {
        if (usuarios.size() >= 4) {
            // Embaralhe a lista de usuários para selecionar aleatoriamente
            Collections.shuffle(usuarios);

            // Divida os 4 jogadores em 2 times aleatórios
            A_Usuario jogador1 = usuarios.get(0);
            A_Usuario jogador2 = usuarios.get(1);
            A_Usuario jogador3 = usuarios.get(2);
            A_Usuario jogador4 = usuarios.get(3);

            // Defina os times aleatoriamente
            int random = new Random().nextInt(2); // 0 ou 1
            jogador1.setNumeroTime(random);
            jogador2.setNumeroTime(random);
            random = 1 - random; // Inverte para 1 ou 0
            jogador3.setNumeroTime(random);
            jogador4.setNumeroTime(random);

            // Remova os jogadores da lista de usuários
            usuarios.remove(jogador1);
            usuarios.remove(jogador2);
            usuarios.remove(jogador3);
            usuarios.remove(jogador4);

            // Crie duas partidas em dupla com esses jogadores
            criarPartida(jogador1, jogador2);
            criarPartida(jogador3, jogador4);
        } else {
            System.out.println("Não há jogadores suficientes para criar partidas em dupla.");
        }
    }
}