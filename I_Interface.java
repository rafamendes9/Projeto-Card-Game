/*  

    INTERFACE EM DESENVOLVIMENTO PARA SER ADAPTADA E IMPLEMENTADA POSTERIOMENTE A ENTREGAS INICIAIS, ESTANDO PRONTA NA CONCLUSAO DAS DATAS FINAIS



//pacotes para criar a interface gráfica.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class I_Interface extends JFrame {
    private F_Lobby lobby;

    private JTextField nomeUsuario;
    private JComboBox<String> decks;
    private JComboBox<String> modalidades;
    private JButton adicionarUsuarioButton;
    private JButton criarPartidaButton;

    // O construtorEle recebe uma instância de Lobby como parâmetro para que a
    // interface possa interagir com o lobby.
    public I_Interface(F_Lobby lobby) {
        this.lobby = lobby;

        /*
         * Configurar a janela, Define o título da janela, seu tamanho
         * e especifica que a janela deve ser fechada quando o usuário clicar no botão
         * fechar.
         
        setTitle("Lobby de Jogo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout define a janela como um layout de BorderLayout, que organiza os
        // componentes na parte superior e inferior da janela.
        setLayout(new BorderLayout());

        // Painel superior, Cria um painel na parte superior da janela para os campos de
        // entrada, rótulos e botões relacionados aos usuários.
        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());

        // Cria campos de entrada de texto para o nome do usuário.
        JLabel labelNome = new JLabel("Nome de Usuário:");
        nomeUsuario = new JTextField(15);

        // Cria JComboBoxes (caixas de seleção) para selecionar o deck e a modalidade do
        // usuário.
        JLabel labelDeck = new JLabel("Deck:");
        decks = new JComboBox<>(new String[] { "Deck 1", "Deck 2", "Deck 3" });

        JLabel labelModalidade = new JLabel("Modalidade:");
        modalidades = new JComboBox<>(new String[] { "Normal Game", "Outra Modalidade" });

        // Cria um botão "Adicionar Usuário" que será usado para adicionar o usuário ao
        // lobby.
        adicionarUsuarioButton = new JButton("Adicionar Usuário");
        adicionarUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarUsuario();
            }
        });

        painelSuperior.add(labelNome);
        painelSuperior.add(nomeUsuario);
        painelSuperior.add(labelDeck);
        painelSuperior.add(decks);
        painelSuperior.add(labelModalidade);
        painelSuperior.add(modalidades);
        painelSuperior.add(adicionarUsuarioButton);

        add(painelSuperior, BorderLayout.NORTH);

        // Painel inferior, Cria um painel na parte inferior da janela para o botão
        // "Criar Partida".
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new FlowLayout());

        // Cria um botão "Criar Partida" que será usado para criar uma partida no lobby.
        criarPartidaButton = new JButton("Criar Partida");

        // Ação do Botão "Criar Partida": Define uma ação para o botão "Criar Partida"
        // que chama o método criarPartida() quando o botão é clicado.
        criarPartidaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarPartida();
            }
        });

        painelInferior.add(criarPartidaButton);

        add(painelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    /*
     * OK.... vamos com calma aqui kkkk
     * Este método é chamado quando o botão "Adicionar Usuário" é clicado na
     * interface gráfica. Ele faz o seguinte:
     * 
     * Obtém os valores dos campos de entrada:
     * nomeUsuario.getText(): Obtém o texto inserido no campo de entrada de nome do
     * usuário.
     * (String) decks.getSelectedItem(): Obtém a opção selecionada no JComboBox
     * "decks" (provavelmente uma lista de opções de decks).
     * (String) modalidades.getSelectedItem(): Obtém a opção selecionada no
     * JComboBox "modalidades" (provavelmente uma lista de opções de modalidades).
     * 
     * Define o nível do usuário:
     * Neste código, o nível do usuário é definido como 1. Você pode personalizar
     * essa parte do código para definir o nível conforme necessário.
     * 
     * Cria um novo usuário:
     * Um novo objeto Usuario é criado com os valores obtidos dos campos de entrada.
     * Os parâmetros passados para o construtor são o nome do usuário, o deck
     * selecionado, a modalidade selecionada e o nível definido.
     * 
     * Adiciona o usuário ao lobby:
     * O novo usuário criado é adicionado ao lobby chamando o método
     * adicionarUsuario() do objeto lobby (provavelmente uma instância da classe
     * Lobby).
     * 
     * Limpa os campos de entrada:
     * Após adicionar o usuário com sucesso, o campo de entrada de nome do usuário é
     * limpo, definindo seu texto como uma string vazia ("") usando
     * nomeUsuario.setText("").
     
    private void adicionarUsuario() {
        String nome = nomeUsuario.getText();
        String deckSelecionado = (String) decks.getSelectedItem();
        String modalidadeSelecionada = (String) modalidades.getSelectedItem();
        int nivel = 1; // Defina o nível do usuário conforme necessário

        // Crie um novo usuário com os dados fornecidos
        A_Usuario novoUsuario = new A_Usuario(nome, deckSelecionado, modalidadeSelecionada, nivel);

        // Adicione o usuário ao lobby
        lobby.adicionarUsuario(novoUsuario);

        // Limpe os campos de entrada
        nomeUsuario.setText("");
    }

    /*
     * Esse aqui é mais tranquilo
     * 
     * Este método é chamado quando o botão "Criar Partida" é clicado na interface
     * gráfica. Ele faz o seguinte:
     * 
     * Verifica se há usuários suficientes:
     * Ele verifica se o número de usuários no lobby é pelo menos igual a 2, o que
     * significa que há pelo menos dois usuários para criar uma partida.
     * 
     * Obtém os dois primeiros usuários da lista:
     * Se houver pelo menos dois usuários, ele obtém os dois primeiros usuários da
     * lista de usuários no lobby. Esses serão os dois jogadores que participarão da
     * partida.
     * 
     * Cria uma partida:
     * O método criarPartida() do objeto lobby é chamado com os dois usuários
     * obtidos como parâmetros. Isso provavelmente cria uma instância da classe
     * Arena ou alguma outra classe que representa uma partida.
     * 
     * Atualiza a interface ou realiza ações necessárias:
     * Nesta parte do código, você pode adicionar código para atualizar a interface
     * ou realizar qualquer ação necessária após a criação da partida.
     * 
     * Trata caso haja menos de 2 usuários:
     * Se não houver pelo menos dois usuários no lobby, uma caixa de diálogo de erro
     * será exibida usando JOptionPane.showMessageDialog(), informando que é
     * necessário pelo menos 2 usuários para criar uma partida.
     

    private void criarPartida() {
        // Verifique se há usuários suficientes para criar uma partida
        if (lobby.getUsuarios().size() >= 2) {
            // Obtenha os dois primeiros usuários da lista
            A_Usuario usuario1 = lobby.getUsuarios().get(0);
            A_Usuario usuario2 = lobby.getUsuarios().get(1);

            // Crie uma partida com esses usuários
            lobby.criarPartida(usuario1, usuario2);

            // Atualize a interface ou faça qualquer ação necessária
        } else {
            JOptionPane.showMessageDialog(this, "É necessário pelo menos 2 usuários para criar uma partida.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // usei esse main para testar se tudo funciounou corretamente, mas vou deixar
    // comentado so pra n dar dor de cabeça quando as classes definitivas estão
    // sendo desenvolvidas

    /*
     * public static void main(String[] args) {
     * // Crie uma instância do Lobby
     * Lobby lobby = new Lobby();
     * 
     * // Crie uma instância da interface gráfica
     * SwingUtilities.invokeLater(new Runnable() {
     * public void run() {
     * new Interface(lobby);
     * }
     * });
     * }
     
}
w

// ideia inicial do codigo, vai ser refeita e adaptadas quando as outras classes
// forem desenvolvidas
// a interface se adequa a classe LOBBY ate o momento com pequenas citaçoes de
// outras classe ( que ainda vão ser desenvolvidas)







*/