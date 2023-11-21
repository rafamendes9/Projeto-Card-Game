package CardGame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMain2 {

    public static void main(String[] args) {
        try {
            // Lê o conteúdo do arquivo JSON
            String jsonContent = readResourceFile(getResourcePath("DADOS.json"));

            // Converte o JSON para um objeto Java
            SeuObjeto seuObjeto = fromJson(jsonContent, SeuObjeto.class);

            // Modifica o objeto (por exemplo, adiciona uma string)
            seuObjeto.setNovaString("Nova String Adicionada");

            // Converte o objeto modificado de volta para JSON
            String novoJsonContent = toJson(seuObjeto);

            // Imprime o novo JSON
            System.out.println(novoJsonContent);

        } catch (IOException e) {
            e.printStackTrace(); // ou trate a exceção de acordo com sua lógica de manipulação de erros
        }
    }

    public static Path getResourcePath(String nameFile) {
        Path caminhoRelativo = Paths.get("C:", "Caminho", "Para", "Recursos", nameFile);
        return caminhoRelativo;
    }

    public static String readResourceFile(Path resourceFilePath) throws IOException {
        return String.join(" ", Files.readAllLines(resourceFilePath, StandardCharsets.UTF_8));
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
