package lesson14.retro;

import com.google.gson.Gson;
import lesson14.Student;

public class JsonTester {
    public static void main(String[] args) {
        Gson gson = new Gson(); // гугловая библиотека для работы c JSON
        Student max = new Student("Max Kotkov", 3, "B-123");
        String json = gson.toJson(max);
        System.out.println(json);

        String zina = "{\"name\":\"Zina Pavlova\",\"year\":2,\"group\":\"B-55\"}";
        Student ina = gson.fromJson(zina, Student.class);
        System.out.println("name: " + ina.getName() + ", year: " + ina.getYear());
    }
}
