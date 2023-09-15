import java.util.ArrayList;
import java.util.List;

public class F_Lobby {
    private List<A_Usuario> usuarios;
    private List<G_Arena> arenas;


    /*Neste construtor, duas listas vazias são inicializadas: usuarios e arenas. 
    Essas listas são usadas para rastrear os usuários no lobby e as arenas em que as partidas ocorrem.
    */
    public F_Lobby() {
        usuarios = new ArrayList<>();
        arenas = new ArrayList<>();
    }


    /*método permite adicionar um objeto Usuario à lista de usuários do lobby.
     Isso é feito simplesmente chamando o método add da lista usuarios e passando o usuario como argumento.
      Isso significa que o usuário agora está no lobby e pode ser emparelhado com outro jogador
      (deixei assim mas vai ser alterado com tiver as dificuldades da IA) */
    public void adicionarUsuario(A_Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarBaralho(A_Usuario usuario) {
        usuarios.add(usuario);
    }

    
    public void criarPartida() {
        // Verifique se há pelo menos dois jogadores no lobby
        if (usuarios.size() >= 2) {
            A_Usuario jogador1 = usuarios.get(0);
            A_Usuario jogador2 = usuarios.get(1);
            
            // Verifique se os jogadores têm decks disponíveis
            if (jogador1.getBaralho() != null && jogador2.getBaralho() != null) {
                // Remova os jogadores da lista de usuários
                usuarios.remove(jogador1);
                usuarios.remove(jogador2);
                
                // Crie uma nova arena com os jogadores
                G_Arena arena = new G_Arena(jogador1, jogador2);
                arenas.add(arena);
                
                // Acesse os decks dos jogadores
                D_Deck deckJogador1 = arena.getDeckJogador1();
                D_Deck deckJogador2 = arena.getDeckJogador2();
                
                // Agora você pode usar os decks dos jogadores como desejar
                // ...
                
                //2ªFASE
                // Inicie a partida na arena
                // arena.iniciarPartida();
            } else {
                System.out.println("Um ou ambos os jogadores não têm decks disponíveis.");
            }
        } else {
            System.out.println("Aguardando mais jogadores para criar uma partida.");
        }
    }


    /*Esse é o maior metodo da classe e um pouco compleo de entender,
     o método é usado para criar uma partida para um usuário. 
     Ele verifica se há outros usuários disponíveis para uma partida, com base em várias condições:
    Verifica se o usuario não é igual ao oponente (para não jogar contra si mesmo).
    Verifica se o deck do usuario é igual ao deck do oponente.
    Verifica se a modalidade de jogo do usuario é igual à modalidade de jogo do oponente.
    Verifica se o nível do usuario é igual ao nível do oponente. 

    Se todas essas condições forem atendidas para algum oponente, uma nova arena é criada,
     removendo o oponente da lista de usuários e adicionando-o à lista de arenas. 
     A partida é então iniciada chamando o método iniciarPartida() na arena criada.

    Se nenhum oponente compatível for encontrado, uma mensagem "Aguardando oponente..." é exibida no console.
    (o OPONENTE se refere a IA que vamos usar para lutar contra o usuario)
    (irei modificar isso quando a interface estiver 100% adaptada com as classes)*/


    //2ª FASE
    /* 
    public void criarPartida(Usuario jogador1) {
        // Verifica se há outros usuários disponíveis para uma partida
      
      //quebrei a linha para o IF não ficar muito extenso mas voces podem arrumar caso o VS CODE de vc fique dando algum bug
        for (Usuario jogador2 : usuarios) {
            if (!jogador1.equals(jogador2) && jogador1.getBaralho().equals(jogador2.getBaralho()) 
            && jogador1.getModalidade().equals(jogador2.getModalidade()) && jogador1.getInventario().getNivel() == jogador2.getNivel()) {

                //2ªFASE
                // Encontrou um oponente com deck e modalidade correspondentes
                usuarios.remove(jogador2);
                Arena arena = new Arena(jogador1, jogador2); //adicionar os outros atributos dos players para Arena
                arenas.add(arena);
                arena.iniciarPartida(); // Inicie a partida
                return;
                
            }
        }
        // Se nenhum oponente foi encontrado, aguarde até que um esteja disponível
        System.out.println("Aguardando oponente...");
    }*/

    
}

//ideia inicial do codigo, vai ser refeita e adaptadas quando as outras classes forem desenvolvidas