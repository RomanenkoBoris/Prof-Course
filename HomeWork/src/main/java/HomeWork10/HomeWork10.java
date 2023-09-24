package HomeWork10;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HomeWork10 {
    public static void main(String[] args) {

        try {
            System.out.println(linesCounter("text.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        try {
            System.out.println(wc("month.txt"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(grep("month.txt", "r"));
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    //Напишите функцию, которая считает количество строк в передаваемом в нее в виде параметра текстовом файле
    public static int linesCounter(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int numberOfLines = 0;
        while (scanner.hasNextLine()) {
            numberOfLines++;
            scanner.nextLine();
        }
        scanner.close();
        return numberOfLines;
    }

    //Напишите функцию, которая считает количество строк в передаваемом в нее в виде параметра текстовом файле
    public static Long wc(String fileName) throws Exception {
        try(
                Reader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        )
        {
            return bufferedReader.lines().count();
        }
    }

    // В функцию передаются имя файла и подстрока. Посчитайте количество строк текстового файла, содержащие эту подстроку.
    public static Long grep(String fileName, String pattern) throws Exception
    {
        try(
                Reader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        )
        {
            return bufferedReader.lines()
                    .filter(string -> string.contains(pattern))
                    .count();
        }
    }

}
