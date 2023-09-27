package lesson22;

import java.util.Date;

public class A_PrintTester {
    public static void main(String[] args) {
        // System.out - поток вывода
        // System.in - поток ввода
        // System.err - вывод ошибок

        //         формат      boolean   целых    плавающая точка     имя
        System.out.printf("It's a %b, years %d, salary is %f, name is %s\n", false, 15, 320.345, "Max");
        //                  It's a false, years 15, salary is 320,345000, name is Max

        // три знака после запятой
        System.out.printf("pi is %.3f\n", Math.PI); // pi is 3,142

        // с шириной поля
        System.out.printf("pi is %10.3f\n", Math.PI); // pi is      3,142

        Date date = new Date();
        System.out.printf("hours: %1$tH, minutes: %1$tM, seconds: %1$tS \n", date);
        //                      hours: 20, minutes: 23, seconds: 40
    }
}
