package CardGame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class C4_UserMenu {


    //testando o cadastro para colocar JSON
    public static void cadastro() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu de Criação de Usuários ---");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    criarNovoUsuario(scanner);
                    break;
                case 2:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    private static void criarNovoUsuario(Scanner scanner) {
        A_Usuario usuario = new A_Usuario(null, null, null, null, null, 0, 0, null, null);
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        usuario.setNome(nome);
        

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        usuario.setSenha(senha);

        // Chama o método para salvar no arquivo
        salvarUsuario(nome, senha);
    }



    private static void salvarUsuario(String nome, String senha) {
        try {
            FileWriter writer = new FileWriter("Arena.txt", true); // Abre o arquivo para escrita

            // Escreve os dados no arquivo
            writer.write(nome + "," + senha + "\n");

            writer.close(); // Fecha o arquivo após a escrita
            System.out.println("Usuário criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    // json + gson



/*  A_Usuario user1 = new A_Usuario("rafa","12345678901", null, null, null, 9, 40000, null, null);
        A_Usuario user2 = new A_Usuario("vitinho",null, null, null, null, 5, 50, null, null);

       



        List<A_Usuario> users = new ArrayList<A_Usuario>();
        users.add(user1);
        users.add(user2);

        String DADOS = new Gson().toJson(users);
         */


}