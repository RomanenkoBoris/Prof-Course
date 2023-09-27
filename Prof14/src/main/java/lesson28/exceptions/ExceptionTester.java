package lesson28.exceptions;

public class ExceptionTester {
    public static void main(String[] args) {
        solution(0); // ArithmeticException: / by zero
        solution(2); // ArrayIndexOutOfBoundsException: 5
        System.out.println("hello, world!");
    }
    public static void solution(int n)
    {
        // запустите и добавьте обработчик исключений
        try {
            int x = 10/n;
            int [] array = new int [n];
            array[x] = 10;
        }
        catch (ArithmeticException e)
        {
            System.err.println("ArithmeticException: " + e.getMessage() );
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
