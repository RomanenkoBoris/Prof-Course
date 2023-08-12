package HomeWork5;

import java.util.*;

public class HomeWork5 {
    public static void main(String[] args) {
        List<String> counties = new ArrayList<>(Arrays.asList("Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"));
        List<String> words = new ArrayList<>(Arrays.asList("Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod", "Avangard", "Cuba"));
        System.out.println(findFirstCountries(counties, words));

        System.out.println(numberOfUniqueTokens("1234123456"));

        Integer [] array = {8,12,10,5};
        System.out.println(areThereMultipliers(array, 60));

        Set <Integer> set = new HashSet<>(Arrays.asList(1,5,6,-6,9,4,-5,-47,96,-56));
        deleteNegatives(set);
        System.out.println(set);

    }

    // нужно получить список всех стран из списка слов, начинающихся на "A"
    public static List<String> findFirstCountries(List<String> countries, List<String> words) {
        List<String> result = new ArrayList<>();
        for (String s : countries) {
            if (words.contains(s) && s.charAt(0) == 'A') {
                result.add(s);
            }
        }
        return result;
    }

    // Напишите метод, который принимает на вход строку и возвращает количество уникальных символов в ней
    public static int numberOfUniqueTokens(String inputString) {
        char[] array = inputString.toCharArray();
        Set<Character> uniqueTokens = new HashSet<>();
        for (char temp : array) {
            if (!uniqueTokens.contains(temp)) {
                uniqueTokens.add(temp);
            } else {
                uniqueTokens.remove(temp);
            }
        }
        return uniqueTokens.size();
    }

    // Напишите функцию, принимающую на вход массив целых и целое число. Функция должна возвращать true если среди чисел массива есть пара, произведение которых дает второй аргумент
    public static boolean areThereMultipliers(Integer [] array, int number) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        for (Integer firstMultiplier : arrayList) {
            int secondMultiplier = number / firstMultiplier;
            if (number % firstMultiplier == 0 && arrayList.contains(secondMultiplier)){
                return true;
            }
        }
        return false;
    }

    // Напишите программу, которая удаляет все отрицательные числа из заданного сета
    public static void deleteNegatives (Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer tmp = iterator.next();
            if (tmp < 0){
                iterator.remove();
            }
        }
    }

}
