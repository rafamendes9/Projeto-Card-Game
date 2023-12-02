package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.Exceptions.J1_InsufficientCoinsException;
import Model.Exceptions.J4_InsufficientGemsException;
import Model.Shops.E2_LojaShiny;
import Model.Shops.E_Loja;
import Model.USER.A_Usuario;

public class InterfaceUserMenu {


    //interface para fluxo do Usuario "jogar"
    public static void main(String[] args) throws J1_InsufficientCoinsException, J4_InsufficientGemsException {
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


            //case para fluxo de cadastro ou logar ou sair do programa
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
        try (FileWriter writer = new FileWriter("CardGame\\Recursos\\DadosLocal.txt", true);
             BufferedWriter txtWriter = new BufferedWriter(writer)) {
            // Escrever os dados no arquivo de texto
            txtWriter.write(usuario.getNome() + "," + usuario.getCpf() + "," + usuario.getSenha() + ","
                    + usuario.getSexo() + "," + usuario.getEmail() + "\n");

            

            writer.close(); // Fecha o arquivo após a escrita

            System.out.println("Usuário criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }
    
    // FIM DE CADASTRO + DADOS (.TXT)


    //metodo de login para checar dados ao validar login
    private static List<A_Usuario> carregarUsuarios() {
        List<A_Usuario> usuarios = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("CardGame\\Recursos\\DadosLocal.txt"))) {
            // Ler dados do arquivo de texto
            while (scanner.hasNextLine()) {
                String[] dados = scanner.nextLine().split(",");
                if (dados.length == 5) {
                    A_Usuario usuario = new A_Usuario(dados[0], dados[1], dados[2], dados[3], dados[4], 0, 0, null, null);
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        return usuarios;
    }


    
   






    public static void logar(Scanner scanner, A_Usuario usuario) throws J1_InsufficientCoinsException, J4_InsufficientGemsException{
        String nomeTemp;
        String senhaTemp;
        boolean sair = false;

        System.out.println("Digite seu nome:");
        nomeTemp = scanner.nextLine();

        System.out.println("Digite sua senha:");
        senhaTemp = scanner.nextLine();


        // ocorre apos o login bem sucedido

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













    //inicar fluxo de partida
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