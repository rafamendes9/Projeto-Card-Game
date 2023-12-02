package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;

import Model.Exceptions.J1_InsufficientCoinsException;
import Model.Exceptions.J4_InsufficientGemsException;
import Model.Shops.E2_LojaShiny;
import Model.Shops.E_Loja;
import Model.USER.A_Usuario;

public class InterfaceUserMenu {


    //testando o cadastro para colocar JSON
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            //add funções de logar e dentro de logar, acessar a loja, jogar = entrar no lobby para jogar só ou em dupla e sair.
            System.out.println("\n--- Menu de Inicial de Usuários ---");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Logar na conta");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            A_Usuario usuario = new A_Usuario(null, null, null, null, null, 0, 0, null, null);

            switch (escolha) {
                case 1:
                    
                    criarNovoUsuario(scanner, usuario);
                    break;
                case 2:
                    logar(scanner, usuario);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    public static void criarNovoUsuario(Scanner scanner, A_Usuario usuario) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        usuario.setNome(nome);
        
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        usuario.setCpf(cpf);

        System.out.print("Crie uma senha: ");
        String senha = scanner.nextLine();
        usuario.setSenha(senha);

        System.out.print("Digite seu sexo: ");
        String sexo = scanner.nextLine();
        usuario.setSexo(sexo);
        
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        usuario.setEmail(email);

        usuario.validarCPF(cpf);
        if (usuario.validacoes()) {
            // Chama o método para salvar no arquivo
            salvarUsuario(usuario);
        } else {
            System.out.println("Não foi possível criar um jogador!.");
        }
    }

     // salvar em dois arquivos singulares, DadosLocal.TXT & Json
    public static void salvarUsuario(A_Usuario usuario) {
        try {
            FileWriter writer = new FileWriter("CardGame\\Recursos\\DadosLocal.txt", true); // Abre o arquivo para escrita
            List<A_Usuario> writerJson = new ArrayList<A_Usuario>();

            writerJson.add(usuario);


            String DADOS = new Gson().toJson(writerJson);
            // Escreve os dados no arquivo
            writer.write(usuario.getNome() + "," + usuario.getCpf() + "," + usuario.getSenha() +"," + usuario.getSexo() +"," + usuario.getEmail() + "\n");
            

            writer.close(); // Fecha o arquivo após a escrita

            System.out.println("Dados guardados do Json --->   "+ DADOS);

            System.out.println("Usuário criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }
    // FIM DE CADASTRO + DADOS (JSON, TXT)


    public static void logar(Scanner scanner, A_Usuario usuario){
        String nomeTeste;
        String senhaTeste;
        boolean sair = false;

        System.out.println("Digite seu nome:");
        nomeTeste = scanner.nextLine();

        System.out.println("Digite sua senha:");
        senhaTeste = scanner.nextLine();

        if (nomeTeste == nomeJson && senhaTeste == senhaJson) {
            
        } else {
            System.out.println("Usuário não existente.");
        }
        

        while (!sair) {
            System.out.println("\n--- Menu de Inicial do Lobby ---");
            System.out.println("1. Entrar numa partida");
            System.out.println("2. Entrar na Loja");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    entrarNumaPartida(scanner, usuario);
                    break;
                case 2:
                    entrarNaLoja(scanner, usuario);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void entrarNumaPartida(Scanner scanner, A_Usuario usuario){
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu de Inicial de Lobby ---");
            System.out.println("1. Entrar numa partida PVP");
            System.out.println("2. Entrar numa partida 2V2");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            F_Lobby lobby = new F_Lobby();

            switch (escolha) {
                case 1:
                    lobby.adicionarUsuario(usuario);
                    break;
                case 2:
                    usuario.setEmTime(true);
                    lobby.adicionarUsuario(usuario);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void entrarNaLoja(Scanner scanner, A_Usuario usuario) throws J1_InsufficientCoinsException, J4_InsufficientGemsException{
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu de Inicial de Loja ---");
            System.out.println("1. Entrar numa Loja Comum");
            System.out.println("2. Entrar numa Loja Shiny");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    E_Loja lojaComum = new E_Loja(null, null);
                    lojaComum.compras(scanner, usuario);
                    break;
                case 2:
                    E2_LojaShiny lojaShiny = new E2_LojaShiny(null, null);
                    lojaShiny.compras(scanner, usuario);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

   
 
}