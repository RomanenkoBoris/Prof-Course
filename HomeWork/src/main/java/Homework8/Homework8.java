package Homework8;

import java.util.*;
import java.util.stream.Collectors;


public class Homework8 {
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
        System.out.println("=== average age ===");
        employees.stream()
                .mapToDouble(e -> e.getAge())
                .average()
                .ifPresent(System.out::println);

        // Посчитайте количество программистов мужчин - имя не оканчивается на "а"
        System.out.println(employees.stream()
                .filter(e -> e.getPosition().equals("programmer"))
                .map(s -> s.getName().split(" "))
                .filter(s -> s[0].endsWith("a"))
                .count());

        // Посчитайте сумму возраста работников
        int ageSum2 = employees.stream()
                .map(e -> e.getAge())
                .reduce(0, (sum, age) -> sum + age);

        // Разделите всех работников на 2 группы: старшие (более 40) и младшие (менее = 40)
        Map<String, List<Employee>> employeesMap = new HashMap<>(employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()<= 40? "young":"old")));
        System.out.println(employeesMap);

        // разделите всех работников на 2 группы - старше 40 лет (true) и младше 40 лет (false)
        System.out.println("=== age > 40 ===");
        System.out.println(
                employees.stream()
                        .collect(Collectors.partitioningBy(e -> e.getAge() > 40)) // Ключом являеься только boolean
                        // .collect(Collectors.partitioningBy(e -> e.getAge() > 40))
        );

        // Найдите профессию самого старшего из молодых
        employeesMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals("young"))
                .flatMap(entry -> entry.getValue().stream())
                .max(Comparator.comparingInt(Employee::getAge))
                .ifPresent(e -> System.out.println(e.getPosition()));

        // Сгрупперуйте всех работников по профессии
        Map<String, List<Employee>> professions = new HashMap<>(employees.stream()
                .collect(Collectors.groupingBy(e -> e.getPosition())));

        System.out.println(professions);

        // Посчитайте количество людей в профессии
        System.out.println(professions.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry(entry.getValue().size(), entry.getKey()))
                .collect(Collectors.toMap(pair -> pair.getKey(), pair -> pair.getValue())));


        System.out.println("=== number of people in position ===");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.getPosition()))
                        .entrySet().stream()
                        .collect(
                                Collectors.toMap(
                                        pair -> pair.getKey(),
                                        pair -> pair.getValue().size()
                                )
                        )
        );
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getPosition,
                                Collectors.counting()
                        ))
        );

        // Вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a" -
        // в виде Map<Boolean, Double> - ключ "true" соответствует женщинам
        System.out.println("=== men women average age");
        employees.stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getName().endsWith("a"),
                                Collectors.averagingDouble(e -> e.getAge())
                        )
                );


        // Распечатать работников с самым часто встречающимся возрастом
        System.out.println("=== most common age ===");
        employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()))
                .entrySet().stream()
                .max((e1, e2) -> Integer.compare(e1.getValue().size(), e2.getValue().size()))
                .map(pair -> pair.getValue())
                .ifPresent(l -> System.out.println(l));

    } // main
}
