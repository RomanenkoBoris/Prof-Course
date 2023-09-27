package lesson24;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class D_Cars {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader fileReader = new FileReader("cars.txt");) {
            Type listType = new TypeToken<ArrayList<Car>>() {
            }.getType();
            List<Car> cars = gson.fromJson(fileReader, listType);
            System.out.println(cars);
            // посчитайте суммарную стоимость всех машин Peugeot
            cars.stream()
                    .filter(c -> c.getMaker().equals("Peugeot"))
                    .mapToDouble(c -> c.getPrice())
                    .sum();
            // найдите самую дорогую машину их тех что стоят меньще 30000
            cars.stream()
                    .filter(c -> c.getPrice() < 30_000)
                    .max(Comparator.comparing(Car::getPrice))
                    .ifPresent(System.out::println);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        // [C{m='BMW', m='Z3', p=84344.33}, C{m='Nissan', m='Patrol', p=24333.23}, C{m='Peugeot', m='207', p=135000.0},
        // C{m='Peugeot', m='407', p=18000.0}, C{m='Toyota', m='Tundra', p=26012.22}]


    }
}