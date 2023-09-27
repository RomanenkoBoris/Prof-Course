package lesson23;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class F_Gson {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
//        Dog d = new Dog("Polkan", 5, true);
//        write(d, "dog.json.txt");
        Dog d = read("dog.json.txt");
        System.out.println(d);
    }
    public static void write(Object o, String filename) {
        try (
                FileWriter fileWriter = new FileWriter(filename);
        ) {
            gson.toJson(o, fileWriter);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static Dog read(String filename) {
        Dog d = null;
        try (
                FileReader fileReader = new FileReader("dog.json.txt");
        ) {
            d = gson.fromJson(fileReader, Dog.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return d;
    }
}