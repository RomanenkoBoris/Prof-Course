package lesson29;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class HamcrestIntro {
    @Test
    public void testArray() {
        String[] words = {"hello", "world", "equator", "sun"};
        assertThat(words, arrayWithSize(4));
        assertThat(words, hasItemInArray("sun"));
    }

    @Test
    public void testList() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, hasSize(3));
        assertThat(list, contains(5, 2, 4)); // именно в таком порядке
        assertThat(list, containsInAnyOrder(2, 4, 5));
        assertThat(list, everyItem(greaterThan(1)));
    }

    @Test
    public void stringListTest() {
        List<String> strings = Arrays.asList("Hell", "Hello");
        LambdaMatcher<String> lengthTester = new LambdaMatcher<>(s -> s.length() > 3);
        assertThat(
                strings,
                everyItem(
                        allOf(
                                startsWith("H"),
                                containsString("ll"),
                                lengthTester)));
    }

    @Test
    public void mapTest() {
        Map<String, Integer> people = new HashMap<>();
        people.put("Max", 23);
        people.put("Masha", 26);

        // Полверить что размер мапы равен 2
        // assertThat(people, hasSize(2)); - hasSize работает только с коллекциями, а Мар коллекцией не является
        assertEquals(people.size(), 2);

        // Проверить что Мар содержит запись "Max"-23
        assertThat(people, hasEntry("Max", 23)); // метод библиотеки Hamcrest для работы с Мар

        // Проверить что есть запись с ключом Masha и что есть запись со значением 26
        assertThat(people, hasKey("Masha")); // метод библиотеки Hamcrest для работы с Мар
        assertThat(people, hasValue(26)); // метод библиотеки Hamcrest для работы с Мар

        // все ключи начинаются с "Ma"
        assertThat(people.keySet(), everyItem(startsWith("Ma")));

        // Убудиться что все значения меньше 30 и больше 20
        assertThat(people.values(), allOf(everyItem(greaterThan(20)), everyItem(lessThan(30))));


    }
}