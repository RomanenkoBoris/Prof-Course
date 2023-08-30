package HomeWork7.Task3;

import java.util.*;

public class CarManager {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car("Toyota", "Corolla", 26_593.98),
                new Car("Toyota", "Prius", 25_050.50),
                new Car("Toyota", "Yaris", 18_506.95),
                new Car("VW", "Polo", 12_598.65),
                new Car("VW", "Golf", 25_698.98),
                new Car("VW", "Tiguan", 30_956.58),
                new Car("Skoda", "Fabia", 10_569.56),
                new Car("Skoda", "Octavia", 18_986.55),
                new Car("Mercedes Benz", "A", 12_547.63),
                new Car("Mercedes Benz", "B", 20_500.87),
                new Car("Mercedes Benz", "C", 35_478.87),
                new Car("Renault", "Clio", 13_417.91),
                new Car("Renault", "Espace", 29_547.47),
                new Car("Volvo", "XC60", 35_478.11),
                new Car("Volvo", "XC90", 45_478.54)
        ));
        System.out.println(sortCars(cars));

    }
    /* Есть класс автомобиль с полями марка модель цена.
    Написать метод который принимает список авто и возвращает TreeMap
    в котором ключами являются марки аатомобилей, а значениями будут списки автомобилей,
    отсортированные относительно цены и модели (дешевые вперед) */

    public static TreeMap<String, List<Car>> sortCars(List<Car> cars) {
        TreeMap<String, List<Car>> sortedCars = new TreeMap<>();
        Comparator<Car> carPriseComparator = (c1, c2) -> Double.compare(c1.getPrise(), c2.getPrise());
        Comparator<Car> carModelNameComparator = (c1, c2) -> c1.getModel().compareTo(c2.getModel());
        for (Car currentCar: cars) {
           if (!sortedCars.containsKey(currentCar.getBrand())){
               sortedCars.put(currentCar.getBrand(), new ArrayList<>(Arrays.asList(currentCar)));
           } else {
               List<Car> temp = sortedCars.get(currentCar.getBrand());
               temp.add(currentCar);
               Collections.sort(temp, carPriseComparator.thenComparing(carModelNameComparator));
               sortedCars.put(currentCar.getBrand(), temp);
           }
        }
        return sortedCars;
    }
}
