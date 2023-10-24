package lesson30;

import java.util.Date;
import java.util.Locale;

// Date хранить время с точностью до милисекунды
// хранит время в милисекундах с эпохи
// 1 января 1970 - неофициальный др юникса
public class DateTester {
    public static void main(String[] args) {
        Date current = new Date(); // текущая дата и время, Comparable - можно сравнивать
        System.out.println(current); // Mon Oct 02 21:13:46 CEST 2023
        System.out.println(current.getTime()); // милисекунды с эпохи (1696274096668)

        Date d1 = new Date(1974, 0, 1); // месяцы в Date  с нуля
        System.out.println(d1.after(current)); // true

        // формат строки Formatter
        System.out.printf("%tY\n", current); // 2023
        System.out.printf("%tY-%tm-%td\n", current, current, current); // 2023-10-02

        Locale fr = new Locale("fr", "CA");
        System.out.printf(fr, "%tc", current); // lun. oct. 02 21:23:34 CEST 2023
    }
}
