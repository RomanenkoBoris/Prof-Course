package homework11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework11 {
    public static void main(String[] args) {
        String testString = "asds sadsdf foih lkjase";
        repleceAllVowels(testString);

        System.out.println(isPinCode("5465"));
        System.out.println(isPinCode("546565"));
        System.out.println(isPinCode("546"));

        String testString2 = "profit 12 expense 20 income 50.3";
        mapAllIntsToDouble(testString2);


    }
    public static void repleceAllVowels (String str){
        String current = str.replaceAll("[aeiou]", "");
        System.out.println(current);
    }

    public static boolean isPinCode (String str){
        return str.matches("\\d{4}|\\d{6}");
    }

    // Напишите функцию mapAllIntsToDouble, которая бы добавляла к
    // каждому целому в передаваемой строке ".0"
    // Пример: "прибыль 12 расходы 20 доходы 50.3" -> "прибыль 12.0 расходы 20.0 доходы 50.3"
    // "1 день прибыль 12 расходы 20 доходы 50.3 итого 9" ->"1.0 день прибыль 12 расходы 20 доходы 50.3 итого 9.0"
    public static String mapAllIntsToDouble(String s)
    {
        // ^ - символ начала строки
        // $ - символ конца строки
        // модифицируйте чтобы заработало
        // return s.replaceAll("(\\s)(\\d+)(\\s)", "$1$2.0$3");
        return s.replaceAll("(\\s|^)(\\d+)(\\s|$)", "$1$2.0$3");
    }
}
