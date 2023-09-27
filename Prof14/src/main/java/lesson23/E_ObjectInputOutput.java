package lesson23;

import java.io.*;

public class E_ObjectInputOutput {
    public static void main(String[] args) {
        // write();
        read();
    }

    public static void write() {
        Dog dog = new Dog("Sharik", 4, false);
        try (
                FileOutputStream fos = new FileOutputStream("dog.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(dog);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void read() {
        try (
                FileInputStream fis = new FileInputStream("dog.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Object o = ois.readObject();
            if (o instanceof Dog) {
                Dog d = (Dog) o;
                System.out.println(d);
            }
        } catch (IOException | ClassNotFoundException e) { // catch (Exception e) - снимает вопросы
            System.out.println(e.getMessage());            // по всем видам исключений
        }


    }

}
