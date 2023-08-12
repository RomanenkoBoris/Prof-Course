package lesson8;

import lesson6.list.MyList;

import java.util.Iterator;

// ArrayList - на основе массива
// LinkedList - каждый элемент хранит ссылки на следующий и предыдущий

// доступ по индексу
// ArrayList O(1)
// LinkedList O(N)

// работа с первым и последним элементом - добавление, изменение, удаление
// ArrayList O(N)
// LinkedList O(1)

public class MyLinkedList implements MyList {

    private Node head; // голова списка - первый узел
    private int size = 0; // количество элементов в списке

    @Override
    public String toString() {
        // [1,2,3]
        String r = "[";
        Node n = head;
        while (n != null) {
            r += n.getValue();
            n = n.getNext();
            if (n != null) {
                r += ", ";
            }
        }
        r += "]";
        return r;
    }

    private class Node {
        private int value; // значение элемента
        private Node next; // ссылка на следующий узел

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.getValue() == value)
                return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public void set(int index, int value) {

    }

    @Override
    public void add(int value) {
        size++;
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(new Node(value));
    }

    // получение узла по его индексу
    private Node getNodeByIndex(int index) {
        Node n = head;
        for (int i = 0; i < index; i++) {
            if (n != null)
                n = n.getNext();
            else
                throw new IndexOutOfBoundsException();
        }
        return n;
    }

    @Override
    public void add(int index, int value) {
        if (index == 0) {
            Node prevHead = head;
            head = new Node(value, prevHead);
        } else {
            Node prev = getNodeByIndex(index - 1);
            Node next = prev.getNext();
            Node newNode = new Node(value, next);
            prev.setNext(newNode);
        }
        size++;

    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            if (head == null)
                return;
            head = head.getNext();
            size--;
            return;
        }
        Node prev = getNodeByIndex(index - 1);
        if (prev != null) {
            Node current = prev.getNext();
            if (current != null) {
                prev.setNext(current.getNext());
            }
            size--;
        }
    }

    @Override
    public int get(int index) {
        Node n = getNodeByIndex(index);
        if (n == null) {
            throw new IndexOutOfBoundsException();
        }
        return n.getValue();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Iterator<Integer> backward() {
        return null;
    }
    // добавление элемента в начало списка

    void addFirst(int e) {
        add(0, e);
    }

    // получение значения первого элемента
    int getFirst() {
        return get(0);

    }

    // удаление первого элемента с возвращением его "старого" значения
    int removeFirst(){
        // если элементов нет, то IndexOutOfBoundsException
        if(head == null)
            throw new IndexOutOfBoundsException();
        // сохраняем значение первого элемента во временную переменную
        int temp = get(0);
        // удаляем первый элемент
        remove(0);
        // возвращаем сохраненное значение
        return  temp;
    }


}
