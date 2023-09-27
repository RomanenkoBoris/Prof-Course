package lesson22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class E_BufferedReaderTester {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("test.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);){
            // reader.read() только символы либо массивы символов
            // BufferedReader позволяет считывать построчно
            String line = bufferedReader.readLine();
            while (line != null){ // больше нет строк в файле
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
