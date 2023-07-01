package lesson5;

import java.util.Arrays;

public class ArrayTester {
    public static void main(String[] args) {
        int [] a = new int[] {1,7,5,3,-20};

        String [] movies = new String[] {"Apocalypse now", "Taxi Driver", "Tango and Cache"};
        String [] groups = {"Guns and Roses", "Aerosmith", "Rolling Stones"};

        System.out.println("groups length: " + groups.length); // длина массива

        System.out.println(Arrays.toString(movies));

        System.out.println(movies[2]); // обращение к элементу
        movies[2] = "Hateful Eight"; // изменение значения элемена масива

        // movies[3] = "Space Odyssey";

        System.out.println(format(a, "<", ",", ">"));
        System.out.println(multiply(a));
        System.out.println(Arrays.toString(a));
        reverse(a);
        System.out.println(Arrays.toString(a));
        System.out.println(compareArrays(new int [] {5,7,8,9}, new int [] {5,7,10,9}));


    }

    // {1,2}, "<", ", ", ">" -> "<1, 2>"
    public static String format(int [] a, String prefix, String delimiter, String suffix){
        String result = "" +prefix;
        for (int i = 0; i < a.length; i++){
            result += a[i];
            if (i != a.length-1){
                result += delimiter;
            }
        }
        result += suffix;
        return result;
    }

    public static int multiply (int [] c){
        int result = c[0];
        for (int i = 1; i<c.length; i++){
            result *= c[i];
        }
        return result;
    }

    public static void reverse (int [] array){

        for (int i =0; i < array.length/2; i++){
            int temp = array [i];
            array [i] = array [array.length-1-i];
            array [array.length-1-i] = temp;

        }
    }

    public static boolean compareArrays (int[]array1, int []array2){
        int length1 = array1.length;
        int length2 = array2.length;
        int i =0;
        while (i < length1 && i < length2){
            if (array1[i] == array2[i]){
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
