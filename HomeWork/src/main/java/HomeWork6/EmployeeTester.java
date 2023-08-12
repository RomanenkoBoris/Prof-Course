package HomeWork6;

import java.util.*;

public class EmployeeTester {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(548, 21, "Vladimir", 1580.60),
                new Employee(544, 19, "Anna", 1945.75),
                new Employee(156, 31, "Elena", 1648.98),
                new Employee(795, 45, "Aleksander", 2456.12),
                new Employee(325, 54, "Maksim", 2100.36),
                new Employee(023, 49, "Nikolay", 1856.91),
                new Employee(179, 24, "Nina", 3125.65),
                new Employee(987, 19, "Leonid", 1956.23),
                new Employee(007, 36, "James Bond", 7000.00),
                new Employee(411, 47, "Ekaterina", 4234.63)
        ));

        System.out.println(employeeList);

        Collections.sort(employeeList); // сотрировка по ID, согласно Comparable
        System.out.println(employeeList);

        employeeList.sort(Employee.ageComparator); // сотрировка по возрасту
        System.out.println(employeeList);

        employeeList.sort(Employee.nameComparator.reversed()); // сотрировка по имени по убыванию
        System.out.println(employeeList);

        List <Comparator> comparatorList = new ArrayList<>(Arrays.asList(Employee.ageComparator, Employee.nameComparator, Employee.salaryComparator));
        sortEmployees(employeeList, comparatorList);
        System.out.println(employeeList);
    }

    // Напишите статическую функцию, которая принимает на вход:
    //    коллекцию для сортировки
    //    список компараторов
    //и сортирует переданную коллекцию составным компаратором из переданного списка
    public static void sortEmployees(List <Employee> employees, List <Comparator> comparators){
        Comparator<Employee> compositComparator = comparators.get(0);
        for (int i = 1; i< comparators.size(); i++){
            compositComparator = compositComparator.thenComparing(comparators.get(i));
        }
        employees.sort(compositComparator);
    }
}
