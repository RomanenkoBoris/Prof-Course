package lesson5;

public class MultiDimensionalArrayTester {
    public static void main(String[] args) {
        int [] a = {1,2,3}; // одномерный массив

        int [] [] c = new int[][] {
                {1,   3,  5},      // 0
                {4},               // 1
                {-10, 20, -40, 5}  // 2
        };

        // -40
        System.out.println(c[2][2]); // -40
        System.out.println(c[2][3]); // 5

        System.out.println(c.length); // 3
        System.out.println(c[2].length); // 4

        System.out.println(sum(c));

    }
    public static int sum(int [] [] array){
        int result = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                result += array[i][j];
            }
        }
        return result;
    }
}
