package lesson28.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
Throwable - базовый класс для всех ошибок и исключений
    Error - ошибки от которых нет возможности восстановиться
        OutOfMemory ...
    Exception

        "Checked exception" - мы обязаных их проверять -
        редкие но вполне нормальные ситуации при работе программы,
        дают возможность как-то выйти из особой ситуации

        RuntimeException - "ошибки программиста" - ситуации которых можно было избежать
            либо внимательностью либо дополнительной проверкой
            можно перехватывать но чаще всего нет смысла
            NullPointerException, ArithmeticException, IndexOutOfBoundsException
 */
public class TryWithResourceTester {
    public static void main(String[] args) {
        /*
        try {
            FileInputStream fis = new FileInputStream("digits.txt");
            // TODO work with file
            fis.close(); // закрыть файл если он больше не нужен
        }
//        catch (FileNotFoundException e){
//            System.err.println("File not found");
//        }
        catch (NullPointerException | IOException e) { // тоже перехватит FileNotFoundException
               System.err.println("IO Exception");
        }
        */

        /*
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("digits.txt");
            // TODO work with file
        }
        catch (NullPointerException | IOException e) // тоже перехватит FileNotFoundException
        {
            System.err.println("IO Exception");
        }
        finally {
            // выполняется всегда
            try {
                fis.close(); // закрыть файл если он больше не нужен
            } catch (IOException e) {
                System.err.println("IO Exception");
            }
        }
         */

        // try-with-resource
        // автоматически закрывает AutoClosable после окончания try-catch блока
        try (
                FileInputStream fis = new FileInputStream("digits.txt");
        ) {
            // TODO work with file
        } catch (NullPointerException | IOException e) // тоже перехватит FileNotFoundException
        {
            System.err.println("IO Exception");
        }


    }

    public static String getRandomString() {
        return null;
    }
}