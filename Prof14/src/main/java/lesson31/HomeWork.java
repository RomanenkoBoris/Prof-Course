package lesson31;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Cuba", "Ecuador", "Brazil", "Canada");
        System.out.println(
                getElements(countries, 1,2)
        );

        LocalDateTime ldt = LocalDateTime.of(2002, Month.NOVEMBER, 20, 0, 0);

        System.out.println("Is friday? " + (ldt.getDayOfWeek() == DayOfWeek.FRIDAY));

        // 01 January 1970, Thursday
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE ");

        System.out.println(ldt.format(dtf));

        // 01 janvier 1970, jeudi
        Locale fr = new Locale("fr", "CA");
        DateTimeFormatter french = DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE ", fr);
        System.out.println(ldt.format(french));

        // Создайте Instant из строки "2023-07-13T19:34:00.00Z"
        // Переведите этот момент времени во временную зону "Pacific/Honolulu" и распечатайте

        Instant i = Instant.parse("2023-07-13T19:34:00.00Z");
        System.out.println(
                i.atZone(ZoneId.of("Pacific/Honolulu"))
        );
    }
    public static <T> Collection<T> getElements(List<T> list, int ... elements) {
        return Arrays.stream(elements)
                .filter(e -> e < list.size())
                .mapToObj(i -> list.get(i))
                .collect(Collectors.toList());
        /*
        List<T> result = new ArrayList<>();
        for(int i = 0; i < elements.length; i++)
        {
            if(elements[i] < list.size())
                result.add(list.get(elements[i]));
        }
        return result;
         */
    }
}
