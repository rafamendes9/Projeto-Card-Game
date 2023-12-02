package CardGame;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class C4_InterfaceUserMenu {


    //testando o cadastro para colocar JSON
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            //add funções de logar e dentro de logar, acessar a loja, jogar = entrar no lobby para jogar só ou em dupla e sair.
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
        


        // Chama o método para salvar no arquivo
        salvarUsuario(usuario );
    }



    // salvar em dois arquivos singulares, DadosLocal.TXT & Json
    private static void salvarUsuario(A_Usuario usuario) {
        try {
            FileWriter writer = new FileWriter("DadosLocal.txt", true); // Abre o arquivo para escrita
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

    // json + gson



/*  A_Usuario user1 = new A_Usuario("rafa","12345678901", null, null, null, 9, 40000, null, null);
        A_Usuario user2 = new A_Usuario("vitinho",null, null, null, null, 5, 50, null, null);

       

 List<A_Usuario> users = new ArrayList<A_Usuario>();

        List<A_Usuario> users = new ArrayList<A_Usuario>();
        users.add(user1);
        users.add(user2);

        String DADOS = new Gson().toJson(users);
         */


}