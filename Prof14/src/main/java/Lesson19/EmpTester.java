package Lesson19;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpTester {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Max Petrov", 22, "programmer"),
                new Employee("Ivan Shapovalov", 33, "analyst"),
                new Employee("Semen Deznev", 55, "manager"),
                new Employee("Oleg Petrov", 19, "intern"),
                new Employee("Katerina Drogova", 31, "programmer"),
                new Employee("Nicolas Spivakov", 23, "analyst"),
                new Employee("Boris Moiseev", 48, "manager"),
                new Employee("Petr Sveshnikov", 37, "programmer"),
                new Employee("Alex Con", 33, "analyst"),
                new Employee("Olga Filimonova", 27, "programmer")
        );

        // найдите самого молодого
        System.out.println(employees.stream()
                .min(Comparator.comparingInt((Employee e) -> e.getAge()))
                .orElse(null)); // избавляемся от Optional
        // .ifPresent(System.out::println); - избавляемся от Optional
        // E{n='Oleg Petrov', a=19, p='intern'}

        // Посчитать количество различных позиций в компании
        System.out.println(employees.stream()
                .map(employee -> employee.getPosition())
                .distinct()
                .count()); // 4

        // Распечатайте фамилии всех жунщин,оканчивающиеся на "а"
        employees.stream()
                .filter(employee -> employee.getName().endsWith("a"))
                .map(employee -> employee.getName().split(" "))
                .forEach(strings -> System.out.println(strings[1]));

        // Распечатайте только имена всех работников
        employees.stream()
                .map(s -> s.getName().split(" "))
                .forEach(strings -> System.out.println(strings[0]));

        // найдите средний возраст
        int ageSum = employees.stream()
                .map(e -> e.getAge())
                .reduce(0, (sum, age) -> sum + age); // метод работате только с числовым потоком!!!

        long quantity = employees.stream()
                .count();

        System.out.println("Средний возраст равен " + ageSum / quantity);

        // Посчитайте количество программистов мужчин - имя не оканчивается на "а"
        System.out.println(employees.stream()
                .filter(e -> e.getPosition().equals("programmer"))
                .map(s -> s.getName().split(" "))
                .filter(s -> s[0].charAt(s.length - 1) != 'a')
                .count());

        // Посчитайте сумму возраста работников
        int ageSum2 = employees.stream()
                .map(e -> e.getAge())
                .reduce(0, (sum, age) -> sum + age);

        // Разделите всех работников на 2 группы: старшие (более 40) и младшие (менее = 40)
        List<Employee> youngEmployees = employees.stream()
                .filter(e -> e.getAge() <= 40)
                .collect(Collectors.toCollection(ArrayList::new));

        List<Employee> oldEmployees = employees.stream()
                .filter(e -> e.getAge() > 40)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(youngEmployees);
        System.out.println(oldEmployees);

        // Найдите профессию самого старшего из молодых
        youngEmployees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(e -> System.out.println(e.getPosition()));

        // Сгрупперуйте всех работников по профессии
        Map<String, List<Employee>> professions = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getPosition()));

        System.out.println(professions);

        // Посчитайте количество людей в профессии
        Map<Integer, List<List<Employee>>> quantityEmployeesProProfession =professions.values().stream()
                .collect(Collectors.groupingBy(l -> l.size()));


        // Вернуть средний возраст мужчин и женщин в виде Map <Boolean, Double>,
        // где ключ true соответствует женщинам
        int womenAgeSum = employees.stream()
                .filter(e -> e.getName().charAt(e.getName().length() - 1) == 'a')
                .map(e -> e.getAge())
                .reduce(0, (total, empl) -> total + empl);

        // Т.е. мы не можем добавлять к одной ссылке потока различные терминальные операции и получать разный результат?!!!
        long quantityOfWomen = employees.stream()
                .filter(e -> e.getName().charAt(e.getName().length() - 1) == 'a')
                .count();

        int menAgeSum = ageSum - womenAgeSum;
        long quantityOfMen = quantity - quantityOfWomen;
        double menAverageAge = menAgeSum / quantityOfMen;
        double womenAverageAge = womenAgeSum / quantityOfWomen;

//        Map<Boolean, Double> ageAverageMap = new HashMap<>(employees.stream()
//                .collect(Collectors.toMap(e -> e.getName().charAt(e.getName().length() - 1) == 'a',
//                        e -> e.getName().charAt(e.getName().length() - 1) == 'a'? womenAverageAge: menAverageAge)));
//
//        System.out.println(ageAverageMap);
//
//        // Выдает ошибку. Не понимаю почему - должно работать. Пора изучить дебаггер.
//
//        System.out.println(ageAverageMap);


        // Распечатать работников с самым частовстречающимся возрастом
        Map<Integer, List<Employee>> ageMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));
        ageMap.values().stream()
                .max(Comparator.comparingInt((List<Employee> l) -> l.size()))
                .ifPresent(l -> System.out.println(l));

    } // main

}
