package lesson23;

import java.io.*;

public class D_DataInputOutput {
    public static void main(String[] args) {
        // write();
        read();
    }

    public static void write() {
        try (
                FileOutputStream fos = new FileOutputStream("data.bin");
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeInt(33);
            dos.writeUTF("Hello, World!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void read() {
        // считайте из файла данные в том порядке и с теми типами как они были записаны и выведите на экран
        try (
                FileInputStream fis = new FileInputStream("data.bin");
                DataInputStream dis = new DataInputStream(fis);
        ) {
            double pi = dis.readDouble();
            boolean b = dis.readBoolean();
            int age = dis.readInt();
            String name = dis.readUTF();
            System.out.printf(
                    "%f, %b, %d, %s\n",
                    pi, b, age, name
            );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
