package lesson23;

import Lesson19.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class B_EmployeeTokenizer {
    public static void main(String[] args) {
        write(); // Max Lotkov|27|analyst

    }

    public static void write() {
        Employee max = new Employee("Max Lotkov", 27, "analyst");
        try (PrintWriter printWriter = new PrintWriter("employee.txt");) {
            printWriter.format("%s|%d|%s", max.getName(), max.getAge(), max.getPosition());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax

    public static void read() {
        try (
                Reader fileReader = new FileReader("employee.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String s = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s, "|");
            String name = tokenizer.nextToken();
            int age = Integer.parseInt(tokenizer.nextToken());
            String position = tokenizer.nextToken();
            System.out.println(new Employee(name, age, position));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

