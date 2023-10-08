package HomeWork12;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Homework12 {
    public static void main(String[] args) {

        List<String> countries = new ArrayList<>(Arrays.asList("Cuba", "Equador", "Brazil", "Canada"));
        System.out.println(getElements(countries, 1, 2));

//        2. Создайте LocalDateTime с какой-нибудь датой, например с днем рождения
//        Воспользуйтесь DateTimeFormatter чтобы вывести эту дату в виде
//        01 January 1970, Thursday
//        Выведите то-же самое, но по-французски
//        01 janvier 1970, jeudi

        LocalDateTime ldt = LocalDateTime.of(LocalDate.of(2000,01,01), LocalTime.now());
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("dd LLLL yyyy, EEEE")));
        Locale fr = new Locale("fr","Fr");
        System.out.printf(fr, ldt.format(DateTimeFormatter.ofPattern("dd LLLL yyyy, EEEE\n"))); //?

//        3. Создайте Instant из строки "2023-07-13T19:34:00.00Z"
//        Переведите этот момент времени во временную зону "Pacific/Honolulu" и распечатайте
        ZonedDateTime zdt = ZonedDateTime.parse("2023-07-13T19:34:00.00Z");
        System.out.println(zdt.toInstant().atZone(ZoneId.of("Pacific/Honolulu")));



    }
    /* 1. Напишите шаблонную функцию, которая принимает на вход список и varargs из целых.
    Нужно вернуть коллекцию из элементов, номера которых и передаются в виде varargs */
    public static <T> Collection<T> getElements(List<T> list, int...elements){
        return Arrays.stream(elements)
                .filter(e -> e < list.size())
                .mapToObj(e -> list.get(e))
                .collect(Collectors.toList());
    }


}
