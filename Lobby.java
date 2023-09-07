import java.util.ArrayList;
import java.util.List;



public class Lobby {
    private List<Usuario> usuarios;
    private List<Arena> arenas;


    /*Neste construtor, duas listas vazias são inicializadas: usuarios e arenas. 
    Essas listas são usadas para rastrear os usuários no lobby e as arenas em que as partidas ocorrem.
    */
    public Lobby() {
        usuarios = new ArrayList<>();
        arenas = new ArrayList<>();
    }


    /*método permite adicionar um objeto Usuario à lista de usuários do lobby.
     Isso é feito simplesmente chamando o método add da lista usuarios e passando o usuario como argumento.
      Isso significa que o usuário agora está no lobby e pode ser emparelhado com outro jogador
      (deixei assim mas vai ser alterado com tiver as dificuldades da IA) */
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
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


    public void criarPartida(Usuario usuario) {
        // Verifica se há outros usuários disponíveis para uma partida
      
      //quebrei a linha para o IF não ficar muito extenso mas voces podem arrumar caso o VS CODE de vc fique dando algum bug
        for (Usuario oponente : usuarios) {
            if (!usuario.equals(oponente) && usuario.getDeck().equals(oponente.getDeck()) 
            && usuario.getModalidade().equals(oponente.getModalidade()) && usuario.getNivel() == oponente.getNivel()) {


                // Encontrou um oponente com deck e modalidade correspondentes
                usuarios.remove(oponente);
                Arena arena = new Arena(usuario, oponente);
                arenas.add(arena);
                arena.iniciarPartida(); // Inicie a partida
                return;
            }
        }
        // Se nenhum oponente foi encontrado, aguarde até que um esteja disponível
        System.out.println("Aguardando oponente...");
    }
}

//ideia inicial do codigo, vai ser refeita e adaptadas quando as outras classes forem desenvolvidas

