package lesson1;

import lesson1.japan.JapaneseEmployee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JapaneseSalaryTest {
    @Test // метит метод как тестовый
    public void testSalary() {
        JapaneseEmployee e = new JapaneseEmployee("Yukio", 100_000, 5);
        assertEquals(
                "Тестируем зарплату",
                350_000, // что должно быть
                e.calculateSalary(), // вызов теструемого метода
                0.001 // дельта для double так как double это не точный тип
        );
    }

    @Test
    public void testGreetings() {
        JapaneseEmployee y = new JapaneseEmployee("Yukio", 100_000, 10);
        JapaneseEmployee h = new JapaneseEmployee("Haruki", 80_000, 3);

        assertEquals("Тестируем приветствие", "Good day, Yukio", y.greetings());
        assertEquals("Тестируем приветствие", "Hello, Haruki", h.greetings());
    }
}
