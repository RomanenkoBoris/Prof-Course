package lesson23;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public class A_StringStream {
    public static void main(String[] args) {
        String hello = "hello\nworld\nhow are you?";
        Reader stringReader = new StringReader(hello);
        // считайте и распечатайте строки из этой строки
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        bufferedReader.lines()
                .forEach(System.out::println);  // hello
                                                // world
                                                // how are you?
    }
}
