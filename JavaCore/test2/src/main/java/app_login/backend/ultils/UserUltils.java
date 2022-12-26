package app_login.backend.ultils;

import app_login.backend.model.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserUltils {
    public static ArrayList<Users> getDataFromFile(String fileName) {
        Gson gson=new Gson();
        ArrayList<Users> users = new ArrayList<>();
        try {
            FileReader fileReader=new FileReader("user.json");
            Type type=new TypeToken<ArrayList<Users>>(){}.getType();
            users=gson.fromJson(fileReader,type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }
    public static void addDataToFile(String fileName, Object obj) {
        try {
            // Tạo đối tượng gson
            // Gson gson = new Gson();

            // Nếu muốn format JSON cho đẹp
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Tạo đối tượng Writer để ghi nội dung vào file
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            // Ghi object vào file
            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
