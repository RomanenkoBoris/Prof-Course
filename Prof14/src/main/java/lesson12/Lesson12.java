package lesson12;

import java.util.*;

public class Lesson12 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(reversePolishCalculator("3 4 + 2 - 6 *")); // 30

        System.out.println(checkBrackets("{()[]{}}")); // true
        System.out.println(checkBrackets("{(]}")); // false
        System.out.println(checkBrackets("[{()}]")); // true
        System.out.println(checkBrackets("{(}")); // false
        System.out.println(checkBrackets("}")); // false

        System.out.println(convert(255,16)); //FF
        System.out.println(convert(255,2)); //11111111

    }

    public static String convert(int number, int base)
    {
        String digits = "0123456789ABCDEF";
        Stack<String> stack = new Stack<>();
        while (number > 0)
        {
            int index = number % base; // индекс цифры
            stack.push(digits.substring(index, index + 1));
            number /= base;
        }
        String r = "";
        while (!stack.empty())
            r += stack.pop();
        return r;
    }

    public static boolean isPalindrome(String w) {
        Deque<Character> word = new ArrayDeque<>();
        for (char c : w.toCharArray()) {
            word.addLast(c);
        }
        while (word.size() > 1) {
            if (word.getFirst().equals(word.getLast())) {
                word.removeFirst();
                word.removeLast();
            } else {
                return false;
            }
        }
        return true;
    }

    public static int reversePolishCalculator(String s) {
        int r = 0;
        Queue<String> t = new LinkedList<>(Arrays.asList(s.split(" ")));
        int operand1 = 0;
        if (!t.isEmpty())
            operand1 = Integer.parseInt(t.poll());
        while (t.size() >= 2) {
            int operand2 = Integer.parseInt(t.poll());
            String operation = t.poll();
            switch (operation) {
                // + - * / - возможные значения operation
                case "+":
                    r = operand1 + operand2;
                    break;
                case "-":
                    r = operand1 - operand2;
                    break;
                case "*":
                    r = operand1 * operand2;
                    break;
                case "/":
                    r = operand1 / operand2;
                    break;
            }
            System.out.printf("%d %s %d = %d\n", operand1, operation, operand2, r);
            operand1 = r;
        }
        return r;
    }

    // напишем функцию для проверки правильности расстановки скобок
    // {([
    // {()[]{}} - true
    // {(]} - false
    // [{()}] - true
    // {(} - false
    // }{ - false
    public static boolean checkBrackets(String w) {
        Stack<Character> brackets = new Stack<>();
        for (char c : w.toCharArray()) {
            // если символ это открывающая скобка, заносим ее в stack

            if ( (c == '}' || c == ']' || c == ')' ) && brackets.empty())
                return false;

            if (c == '{' || c == '[' || c == '(')
                brackets.push(c);
                // если символ это закрывающая скобка, то убираем из вершины стэка
                //      символ только в том случае если это соответсвующая открывающая скобка
            else if (
                    (c == '}' && brackets.peek() == '{') ||
                            (c == ']' && brackets.peek() == '[') ||
                            (c == ')' && brackets.peek() == '(')
            ) {
                brackets.pop();
            }
        }
        return brackets.size() == 0;
    }
}
