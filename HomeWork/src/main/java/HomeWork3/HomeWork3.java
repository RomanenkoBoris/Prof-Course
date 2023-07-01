package HomeWork3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {

        // Realisation of task N1:
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(concat(array1, array2)));

        // Realisation of task N2:
        int[][] array3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9},
                {10, 11,},
                {12, 13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(flatten(array3)));

        // Realisation of task N3*:
        int[] array4 = {10, 5, 7, 9, 3, 4, 5, 6, 12, 36, 19, 8};
        int[] array5 = {5, 9, 6, 78, 85, 10, 3, 12, 8, 12};
        System.out.println(Arrays.toString(findDuplicates(array4, array5)));

        // Realisation of task N4*:
        int[] array6 = {10, 5, 7, 9, 3, 4, 5, 6, 12, 36, 19, 8};
        int[] array7 = {5, 9, 6, 78, 85, 10, 3, 12, 8, 12};
        System.out.println(Arrays.toString(findUnique(array6, array7)));
    }

    // Task N1
    public static int[] concat(int[] array1, int[] array2) {
        int length = array1.length + array2.length;
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < array1.length) {
                resultArray[i] = array1[i];
            } else {
                resultArray[i] = array2[i - array1.length];
            }
        }
        return resultArray;
    }

    // Task N2

    public static int[] flatten(int[][] array) {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            length += array[i].length;
        }
        int[] resultArray = new int[length];
        int currentLength = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                resultArray[currentLength + j] = array[i][j];
            }
            currentLength += array[i].length;
        }
        return resultArray;
    }

    // Task N3*

    public static int[] findDuplicates(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int length = 0;
        for (int i = 0; i < array1.length; i++) {
            boolean isItRepeat = i == 0 || array1[i] != array1[i - 1];
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j] && isItRepeat) {
                    length++;
                    break;
                }
            }
        }
        int[] resultArray = new int[length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            boolean isItRepeat = i == 0 || array1[i] != array1[i - 1];
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j] && isItRepeat) {
                    resultArray[index] = array1[i];
                    index++;
                    break;
                }
            }
        }

        return resultArray;
    }

    // Task N4*

    public static int[] findUnique(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int numberOfEven = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    if (i == 0 || (array1[i] != array1[i - 1] && array2[j] != array2[j - 1])) {
                        numberOfEven += 2;
                    } else {
                        numberOfEven++;
                    }
                }
            }
        }
        int length = array1.length + array2.length - numberOfEven;
        int[] resultArray = new int[length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            boolean isItUniq = true;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    isItUniq = false;
                }
            }
            if (isItUniq) {
                resultArray[index] = array1[i];
                index++;
            }
        }
        for (int i = 0; i < array2.length; i++) {
            boolean isItUniq = true;
            for (int j = 0; j < array1.length; j++) {
                if (array2[i] == array1[j]) {
                    isItUniq = false;
                }
            }
            if (isItUniq) {
                resultArray[index] = array2[i];
                index++;
            }
        }
        return resultArray;
    }
}



