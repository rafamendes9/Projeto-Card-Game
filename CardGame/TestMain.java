package CardGame;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter; // ler o Json ( objeto)
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson; // converte Json em objeto

public class TestMain {
    public static void main(String[] args) {


        A_Usuario user1 = new A_Usuario(null,null, null, null, null, 9, 40000, null, null);
        A_Usuario user2 = new A_Usuario(null,null, null, null, null, 5, 50, null, null);

       

        List<A_Usuario> users = new ArrayList<A_Usuario>();

        users.add(user1);
        users.add(user2);



        String gsonTeste = new Gson().toJson(users);
        
System.out.println(gsonTeste);
    }

    FileWriter lerJson = new FileWriter();

    // Ajuda de Álef logo abaixo

    // public Path getResourcePath(String typeResources, String nameFile) { // add depois um exception criado
    //     Path caminhoRelativo = Paths.get("resources", typeResources, nameFile);
    //     return Paths.get(System.getProperty("user.dir")).resolve(caminhoRelativo);
    // }

    // public String readResourceFile(Path resourceFilePath) throws IOException {
    //     return String.join(" ", 
    //         Files.readAllLines(
    //             resourceFilePath, 
    //                 StandardCharsets.UTF_8)
    //     );
    // }
}