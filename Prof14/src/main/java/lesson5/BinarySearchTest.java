package lesson5;

import java.util.Arrays;

public class BinarySearchTest {
        public static void main(String[] args) {
            int[] r = {1, 4, 14, 33, 37, 41, 50};
            // двоичный поиск == binary search требует наличия
            // уже отсортированного контейнер

            // 0 1 2  3   4 5  6
            // 1,4,14,33,37,41,50     41 -> 5   O(n) ~ log(N)
            // 1,4,14,33,37,41,50     46
            // 1,4,14,33,37,41,46,50  46   -6-1=-7


            // 1,4,14,33,37,41,50     -12  0-1 =-1

            System.out.println(
                    Arrays.binarySearch(r, 41)
            );

            System.out.println(
                    Arrays.binarySearch(r, -12)
            );

            String capitals [] = {"Berlin", "Warsaw", "Prague", "Riga", "Budapest"};
            Arrays.sort(capitals);
            int position = 0 - Arrays.binarySearch(capitals, "Lisbon");
            System.out.println(position -= 1);

        }
    }


