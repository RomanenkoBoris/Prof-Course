package lesson24;

import java.io.File;
import java.util.Arrays;

public class B_File {
    public static void main(String[] args) {
        File dogBin = new File("dog.bin");
        System.out.println("exists: " + dogBin.exists());
        System.out.println("length: " + dogBin.length());

        File currentDir = new File(".");
        if (currentDir.isDirectory()) {
            System.out.println("is directory");
            String[] files = currentDir.list();
            System.out.println(Arrays.asList(files));

            Arrays.stream(files)
                    .forEach(f -> {
                        File tmp = new File(f);
                        if (tmp.isDirectory()) {
                            System.out.println("d " + f);
                        } else {
                            System.out.println("f " + f);
                        }
                    });
        }
    }
}
