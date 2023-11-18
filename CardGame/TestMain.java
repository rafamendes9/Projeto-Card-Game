package CardGame;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestMain {
    public static void main(String[] args) {


        A_Usuario user1 = new A_Usuario(null,null, null, null, null, 9, 40000, null, null);
        A_Usuario user2 = new A_Usuario(null,null, null, null, null, 5, 50, null, null);

       

        List<A_Usuario> userJson = new ArrayList<A_Usuario>();

        userJson.add(user1);
        userJson.add(user2);



        String gsonTeste = new Gson().toJson(userJson);
        
System.out.println(gsonTeste);
    }
}