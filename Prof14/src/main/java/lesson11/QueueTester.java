package lesson11;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {
    public static void main(String[] args) {
        // Queue - очередь - добавляет элемент в конец и позволяет обрабатывать элементы из начала

        // добавление
        // boolean add(E) - выбрасывает IllegalStateException если нет места в очереди
        // boolean offer(E) - возвращает true если элемент вставлен

        // получение элемента из начала
        // E remove() - убирает и возвращает первый элемент из очереди
        //      и выбрасывает NoSuchElementException если очередь пуста
        // E poll() - убирает и возвращает первый элемент и null если очередь пуста

        // инспепекция
        // E element() // возвращает первый элемент либо выбрасывает NoSuchElementException
        // E peek() // возвращает элемент либо null если очередь пуста

        Queue<String> bankQueue = new LinkedList<>();
        // добавьте в очередь несколько человек
        bankQueue.offer("Max Katkov");
        bankQueue.offer("Sveta Ivanova");
        bankQueue.offer("Semen Dezhnev");
        bankQueue.offer("Sergey Belyh");

        // в цикле получите этих людей из очереди и распечатайте
        while (!bankQueue.isEmpty()){
            System.out.println(bankQueue.poll());
        }
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("One");
        priorityQueue.add("Two");
        priorityQueue.add("Three");
        priorityQueue.add("Four");
        priorityQueue.add("Five");
        while (!priorityQueue.isEmpty())
        {
            System.out.println(priorityQueue.poll());
        }


    }
}