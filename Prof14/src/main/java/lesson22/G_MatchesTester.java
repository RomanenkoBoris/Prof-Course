package lesson22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class G_MatchesTester {
    // считаем из matches.txt все результаты в виде строк, разобьем строку по ", " на куски
    // из кусков соберем Match, Match добавим в список
    public static void main(String[] args) {
        List<Match> matches = new ArrayList<>();
        try (Reader reader = new FileReader("matches.txt");
             BufferedReader bufferedReader = new BufferedReader(reader);) {
            String line = bufferedReader.readLine();
            while (line != null) {
                // разобьем строку по ", " на куски
                String[] t = line.split(", ");
                // из кусков соберем Match
                // Match добавим в список
                Calendar calendar = new GregorianCalendar(
                        Integer.parseInt(t[0]),
                        Integer.parseInt(t[1]),
                        Integer.parseInt(t[2])
                );
                Match match = new Match(calendar, t[3], t[4], t[5], t[6], Integer.parseInt(t[7]));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        // посчитайте суммарное количество посетителей
        System.out.println(matches.stream().mapToInt(Match::getWatcher).sum());
        // посчитайте среднее количество посетителей
        System.out.println(matches.stream().mapToDouble(Match::getWatcher).average().orElse(0));
    }
}
