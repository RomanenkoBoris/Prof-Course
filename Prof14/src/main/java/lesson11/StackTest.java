package lesson11;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        // Stack - элементы добавляются и получаются с одной стороны
        // LIFO - Last in First Out

        // T push(T) - добавление элемента в верх стека
        // T pop() - удаление и возвращение элемента с вершины стэка
        // T peek() - возвращение элемента с вершины стэка без удаления
        // boolean empty()
        // int size()

        Stack<String> names = new Stack<>();
        names.add("Max");
        names.add("Dina");
        names.add("Dasha");
        names.add("Masha");

        //  возвращает на какой глубине находится элемент
        System.out.println(names.search("Max")); // 4 (-1 when the element not exists)

        while (!names.empty()) {
            System.out.println(names.pop());
        }

        String line = "однажды в студеную зимнюю пору я из лесу вышел";
        Stack<String> revers = new Stack<>();
        String[] array = line.split(" ");
        for (String s : array) {
            revers.push(s);
        }
        while (!revers.empty()) {
            System.out.print(revers.pop() + " ");
        }
    }

}
