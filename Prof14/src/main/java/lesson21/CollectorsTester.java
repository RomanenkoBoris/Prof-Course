package lesson21;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTester {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );
        // Collectors предназначение: сгруппировать элементы, обсчитать статистику,
        // сохранить элементы потока в коллекции на ваш выбор.

        // соберите студентов у которых в фамилии есть буква s в любом регистре в список

        Collection<Student> filteredStudents =
                students.stream()
                        .filter(s -> s.getLastName().toLowerCase().contains("s"))
                        //.collect(Collectors.toList()); // ArrayList
                        // .collect(Collectors.toSet()) // HashSet
                        // .collect(Collectors.toUnmodifiableList()); // Read-only list
                        // .collect(Collectors.toUnmodifiableSet()); // Read-only set
                        .collect(Collectors.toCollection(LinkedList::new));

        // соберите уникальные фамилии студентов в коллекцию по возрастанию Collection<String> uniqueLastNames
        students.stream()
                .map(s -> s.getLastName())
                .collect(Collectors.toCollection(TreeSet::new));

        // сгруппируйте студентов по гендеру
        Map<Boolean, List<Student>> studentsByGender = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getLastName().endsWith("a")));

        // разбейте студентов на тех кто старше и младше 20 лет
        Map<Boolean, List<Student>> studentsOlderThan20 = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() <= 20));

        // разбейте студентов на группы по возрасту
        Map<Integer, List<Student>> studentsByAge = students.stream()
                .collect(Collectors.groupingBy(s -> s.getAge()));

        // разбейте студентов по первой букве их имени
        Map<Character, List<Student>> studentsByFirstNameLetter = students.stream()
                .collect(Collectors.groupingBy(s -> s.getFirstName().charAt(0)));

        Map<Integer, Set<Student>> studentByAgeSet = students.stream()
                .collect(Collectors.groupingBy(s -> s.getAge(), Collectors.toSet()));

        // сбор статистики
        Long numberOfStudents = students.stream()
                // .count();
                .collect(Collectors.counting());

        Map<Integer, Long> studentsByAgeNumber =
                students.stream()
                        .collect(Collectors.groupingBy(s -> s.getAge(), Collectors.counting()));

        DoubleSummaryStatistics ageStatistics = students.stream()
                .collect(Collectors.summarizingDouble(s -> s.getAge()));

        System.out.println("max age: " + ageStatistics.getMax());
        System.out.println("min age: " + ageStatistics.getMin());
        System.out.println("average age: " + ageStatistics.getAverage());
        System.out.println("count of age: " + ageStatistics.getCount());

        // определим максимум
        Optional<Student> maxAgeStudent =
                students.stream()
                        .collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));

        // Collectors.toMap
        Map<String, String> firstToLast =
                students.stream()
                        .collect(Collectors.toMap(s -> s.getFirstName(), s -> s.getLastName()));

        Map<String, Integer> nameToAge = students.stream()
                .collect(Collectors.toMap(s -> s.getFirstName() + " " + s.getLastName(), s -> s.getAge()));


        studentsByGender.entrySet().stream()
                .map(pair -> new AbstractMap.SimpleEntry(pair.getValue(), pair.getKey()))
                .collect(Collectors.toMap(pair -> pair.getKey(), pair -> pair.getValue()));

        // создайте из мапы  Map<Boolean, List<Student>> studentsByGender Map<Boolean, Double> genderToAverageAge
        studentsByGender.entrySet().stream()
                .map(pair -> new AbstractMap.SimpleEntry<>(
                                pair.getKey(), pair.getValue().stream()
                                .mapToDouble(Student::getAge)
                                .average().orElse(0)))
                .collect(Collectors.toMap(pair -> pair.getKey(), pair -> pair.getValue()));

        // joining
        System.out.println(
                // Daria, Max ... -> {Daria, Max, ... }
                students.stream()
                        .map(s -> s.getFirstName())
                        .collect(Collectors.joining(", ", "{", "}")));


    } // main
}
