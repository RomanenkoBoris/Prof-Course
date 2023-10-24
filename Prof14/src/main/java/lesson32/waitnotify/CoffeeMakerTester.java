package lesson32.waitnotify;

public class CoffeeMakerTester {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        new Thread(() -> machine.makeCoffee()).start();
        new Thread(() -> machine.reload()).start();
    }
}
//    Делаем чашку кофе из капсулы 1
//    Делаем чашку кофе из капсулы 2
//    Делаем чашку кофе из капсулы 3
//    Делаем чашку кофе из капсулы 4
//    Делаем чашку кофе из капсулы 5
//    Делаем чашку кофе из капсулы 6
//    Делаем чашку кофе из капсулы 7
//    Делаем чашку кофе из капсулы 8
//    Делаем чашку кофе из капсулы 9
//    Делаем чашку кофе из капсулы 10
//    Капсулы закончились
//    Добавляем новые капсулы
//    Количество капсул 10
