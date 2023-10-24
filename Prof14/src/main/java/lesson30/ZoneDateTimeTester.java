package lesson30;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeTester {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt); // 2023-10-02T21:48:54.009+02:00[Europe/Berlin]

        System.out.println(zdt.toInstant().atZone(ZoneId.of("Pacific/Midway")));
        //2023-10-02T08:51:02.939-11:00[Pacific/Midway]

        ZonedDateTime t = ZonedDateTime.parse("2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]");
        System.out.println(t); // 2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]
    }
}
