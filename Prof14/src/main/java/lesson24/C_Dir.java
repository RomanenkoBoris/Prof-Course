package lesson24;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Arrays;
import java.util.stream.IntStream;

public class C_Dir {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String path = file.getAbsolutePath();
        printDir(0, path);
    }
    public static void printDir(int level, String path) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles(); // все файлы в директории
        if (files != null) {
            Arrays.sort(files);
            for (File f : files) {
                System.out.print(!f.isDirectory() ? "-" : "d");
                System.out.print(f.canRead() ? "r" : "-");
                System.out.print(f.canWrite() ? "w" : "-");
                System.out.print(f.canExecute() ? "x" : "-");
                // для получения дополнительной информации о правах доступа/владельцах и тп
                FileOwnerAttributeView av = Files.getFileAttributeView(
                        Paths.get(f.getAbsolutePath()),
                        FileOwnerAttributeView.class);
                System.out.printf("\t%8d\t%12s", f.length(), av.getOwner().getName());
                IntStream.rangeClosed(0, level).forEach(
                        i -> System.out.print("\t"));
                System.out.println(f.getName());

                if(f.isDirectory()) {
                    printDir(level + 1, f.getAbsolutePath());
                }
            }
        }
    }
}
