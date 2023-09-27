package lesson25;

/*
Применения регулярных выражений / regex
1. проверка соответствия строки шаблону
2. разбиение строки по регулярному выражению
3. замена
 */

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson25 {
    public static void main(String[] args) {
        String string = "this is a max temperature and it has a real maximum";
        Pattern max = Pattern.compile("max"); // скомпилированный шаблон
        Matcher maxMatcher = max.matcher(string); // все совпадения с шаблоном в строке
        while (maxMatcher.find())
        {
            System.out.printf(
                    "s: %d, e:%d, group: %s\n",
                    maxMatcher.start(), // порядковый номер начального символа совпадения
                    maxMatcher.end(), // порядковый номер конечного символа совпадения
                    maxMatcher.group() // само совпадение
            );
        }
        System.out.println("=== .* ===");
        // . - любой символ
        // * - 0 и более предыдущих символов
        String telran = "https://www.telran.de";
        Pattern telranPattern = Pattern.compile(".*www.*", Pattern.CASE_INSENSITIVE);
        System.out.println(
                telranPattern.matcher(telran).matches()); // есть ли совпадения ?

        // если нужно проверить наличие точки, то ее нужно "искейпить" - \.
        // "\\"
        System.out.println(
                // telran.contains("www\\.") // \\ - обратный слэш тоже нужно искейпить
                telran.matches(".*www\\..*"));

        // hello -> hel.*
        System.out.println(
                "hello".matches("hel.*"));
        // hello -> hel..
        System.out.println(
                "hello".matches("hel.."));

        // * - нуль и более предыдущих символов
        // + - один и более предыдущих символов
        // ? - нуль или один предыдущий символ
        // {1,7} - от одного до 7 предыдущих символов
        // {2,} - от двух и более
        // {,6} - до шести

        System.out.println("=== | - альтернатива === "); // | - либо
        System.out.println("max".matches("dima|max|masha")); // true

        System.out.println("maxmasha".matches("dima|max|masha")); // false

        System.out.println("=== () - группировка === ");
        System.out.println("maxmasha".matches(".*(dima|max|masha).*")); // true

        System.out.println("=== [] - перечисление === ");
        System.out.println("a".matches("[abcdefx]")); // true

        System.out.println("abc".matches("[abcdefx]*")); // true
        System.out.println("abc".matches("[abcdefx]{3}")); // true
        System.out.println("abc".matches("[a-fx]{3}")); // true

        System.out.println("=== [^] - отрицание === ");
        System.out.println("a".matches("[^klm]")); // true

        System.out.println("=== \\s - пробельные символы === "); // \s
        // пробульные символы это: \n - новая строка, \t - табуляция, " " - пробел
        // напишите шаблон: одна и более букв - один и более пробельных символов - одна и более букв
        System.out.println("max   kotkov".matches("[a-z]+\\s+[a-z]+"));

        // Проверка соответсвует ли строка формату "Фамилия Имя"
        System.out.println("Max   Kotkov".matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")); // true

        System.out.println("=== hex number ===");
        System.out.println(isHexNumber("0x1")); // true
        System.out.println(isHexNumber("123")); // false
        System.out.println(isHexNumber("0XB")); // true
        System.out.println(isHexNumber("abc")); // false
        System.out.println(isHexNumber("0x")); // false
        System.out.println(isHexNumber("0xABW")); // false

        System.out.println("=== phone number ===");
        System.out.println(isPhoneNumber("+1")); // true
        System.out.println(isPhoneNumber("1")); // false
        System.out.println(isPhoneNumber("+1A")); // false
        System.out.println(isPhoneNumber("123")); // false

        System.out.println("=== ipv4 address ===");
        System.out.println(isIpV4Address("0.0.0.0")); // true
        System.out.println(isIpV4Address("0.0.0.0.")); // false
        System.out.println(isIpV4Address("0.0.0")); // false
        System.out.println(isIpV4Address("255.255.255.300")); // false
        System.out.println(isIpV4Address("255.255.a.255")); // false
        System.out.println(isIpV4Address("255.255.255.255")); // true

        // \\s - пробельные символы
        // \\w - символ слова
        // \\d - цифры

        System.out.println("=== разбиение ===");
        // разбейте на слова
        String line = "to be     or  not        to      be";
        System.out.println(Arrays.toString(line.split("\\s+"))); //[to, be, or, not, to, be]

        System.out.println(getExtension("hello.png")); // png
        System.out.println(getExtension("my.resume.1.doc")); // doc
        System.out.println(getExtension("hello")); // null

        System.out.println("=== () группировка ====");
        String people = "Max Semenov     Lena Petrova  Igor Semin";
        //                                                   1 group     2 group
        Pattern firstLastNamePattern = Pattern.compile("(\\w+)\\s+(\\w+)"); // 0 group = 1 group + 2 group
        //                                                    |    0 group    |  т.е. 0 group - это весь regex
        Matcher namesMatcher = firstLastNamePattern.matcher(people);
        while (namesMatcher.find()) {
            System.out.printf("name: %s, surname: %s\n", namesMatcher.group(1), namesMatcher.group(2));
            // name: Max, surname: Semenov
            // name: Lena, surname: Petrova
            // name: Igor, surname: Semin
        }

        String employeeData = "michael;levanov|34|34000";
        // разбейте на части по ; и по | и распечатайте составные части
        System.out.println(Arrays.toString(employeeData.split("[;|]")));

        System.out.println("=== замена ===");
        String temperature = "Today's temperature is 18 degrees centigrade";
        temperature = temperature.replaceAll("\\d+", "45")
                                 .replaceAll("centi", "milli");
        System.out.println(temperature); // Today's temperature is 45 degrees milligrade

        String numbers = "one two three four zero";
        numbers = numbers.replaceAll("(t\\w+)", "_$1_");
        System.out.println(numbers); // one _two_ _three_ four zero



    } // main

    // функця должна возвращать расширение файла: hello.png -> png; my.resume.1.doc -> doc
    public static String getExtension (String filename){
        if (filename.contains(".") && filename.length() > 0) {
            String[] array = filename.split("\\.");
            return array[array.length - 1];
        }
        return null;
    }
    // Проверка на ip - етыре цифры разделенные точками (1.2.3.4), где каждая цифра 0-255
    public static boolean isIpV4Address(String s) {
        //                0-9 00-99 100-199 200-249 250-255
        String octet = "(\\d|\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])";
        return s.matches(octet+"\\." + octet+"\\." +octet+"\\." +octet);
    }
    // напишите функцию которая проверяет, является ли переданная в нее строка шестнадцатеричным номером:
    // 0x12AB; 0XB - цифры могут быть 0...9 a-f A-F
    public static boolean isHexNumber (String str){
        return str.matches("0(x|X)[0-9a-fA-F]+");
    }

    // напишите функцию которая проверяет, является ли переданная в нее строка номером телефона
    // номер телефона состоит из + и одной или более цифр
    public static boolean isPhoneNumber (String str){
        return str.matches("\\+[0-9]+");
    }
}