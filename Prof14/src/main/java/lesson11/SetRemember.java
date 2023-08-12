package lesson11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetRemember {
    public static void main(String[] args) {
        // HashSet, LinkedHashSet, ThreeSet
        Set<String> countries = new HashSet<>();
        // добавление
        countries.add("Brazil");
        countries.add("Chile");
        // добавление из коллекции
        countries.addAll(Arrays.asList("Monaco", "France", "Belgium"));
        // количество
        System.out.println(countries.size()); // 5
        // проверка на наличие
        System.out.println(countries.contains("France")); //true
        // удаление элемента
        countries.remove("Monaco");
        countries.add("Belgium");
        System.out.println(countries.size()); // 4
        // удаление всех элементов из коллекции
        countries.removeAll(Arrays.asList("France", "Belgium"));
        System.out.println(countries); // [Brazil, Chile]

        Computer c1 = new Computer("XXX-25", "IBM Thinkpad 4", 1200);
        Computer c2 = new Computer("RETCB-22-15", "Olivetti Primo", 1290);
        Computer c3 = new Computer("XXX-25", "Apple MacBook Pro 16 2022", 1900);

        Set <Computer> computerSet = new HashSet<>();
        computerSet.add(c1);
        computerSet.add(c2);
        computerSet.add(c3);

        for (Computer comp: computerSet) {
            System.out.println(comp);
        }

        String line = "один раз это один раз и один раз отмерь и один раз отрежь";
        // выведите уникальные слова из этой строки
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(line.split(" ")));
        System.out.println(uniqueWords);

        // посчитать количество вхождений в строку каждого из уникальных слов
        // один:4
        // раз:4
        // ...
        Set<Word> words = new HashSet<>();
        for(String w: line.split(" ")) {
            Word currentWord = findWord(new Word(w), words);
            currentWord.setCount(currentWord.getCount() + 1);
            words.add(currentWord);
        }
    }
    public static Word findWord(Word word, Set<Word> words)
    {
        for(Word currentWord : words)
        {
            if(currentWord.equals(word))
                return currentWord;
        }
        return word;
    }

}

class Word {
    private String word;
    private int count; // 0

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
