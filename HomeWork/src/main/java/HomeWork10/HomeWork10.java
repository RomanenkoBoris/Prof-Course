package HomeWork10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            findSubString("text.txt", "fdg");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
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

    // В функцию передаются имя файла и подстрока. Посчитайте количество строк текстового файла, содержащие эту подстроку.
    public static void findSubString(String fileName, String subString) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.lines()
                .collect(Collectors.partitioningBy(line -> line.contains(subString), Collectors.counting()))
                .entrySet().stream()
                .filter(pair -> pair.getKey().equals(true))
                .mapToInt(pair -> Math.toIntExact(pair.getValue()))
                .forEach(System.out::println);
        br.close();
    }

}
