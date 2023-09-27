package lesson26.string;

import java.util.Random;

public class StringTester {
    public static void main(String[] args) {
        String max = "Max";
        String anotherMax = "Max";
        String max2 = new String("Max");
        System.out.println(anotherMax == max); // true | false
        System.out.println(max == max2); // false

        System.out.println(max.equals(max2)); // true

        StringBuilder b = new StringBuilder();
        b.append("Anna");
        b.append(" ");
        b.append("Vasilieva");
        System.out.println(b.toString());
        concatManyDoublesUsingString();


    }

    public static void concatManyDoublesUsingString()
    {
        long before = System.currentTimeMillis();
        String r = "";
        Random random = new Random();
        for (int i = 0; i < 100000; i++){
            r += random.nextDouble();
        }
        long after = System.currentTimeMillis();
        System.out.println("time concatManyDoublesUsingString: " + (after - before));
    }

    public static void concatManyDoublesUsingStringBilder()
    {
        long before = System.currentTimeMillis();
        StringBuilder r = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            r.append(random.nextDouble());
        }
        long after = System.currentTimeMillis();
        System.out.println("time concatManyDoublesUsingString: " + (after - before));
    }
}
