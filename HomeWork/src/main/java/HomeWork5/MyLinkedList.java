package HomeWork5;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public class Node {
        private int value;
        private Node previous;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(int value) {
        Node n = head;
        while (n != null) {
            if (n.getValue() == value) {
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;
    }

    public void set(int index, int value) throws IndexOutOfBoundsException {
        if (index < 0 || size() == 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0 && size == 1) {
            head.setValue(value);
        } else if (index == size() - 1 && size() > 1) {
            tail.setValue(value);
        } else if (index < size() / 2) {
            int pointer = 1;
            Node n = head.getNext();
            while (pointer <= index) {
                if (pointer == index) {
                    n.setValue(value);
                } else {
                    n = n.getNext();
                    pointer++;
                }
            }
        } else {
            int pointer = size() - 2;
            Node n = tail.getPrevious();
            while (pointer >= index) {
                if (pointer == index) {
                    n.setValue(value);
                } else {
                    n = n.getPrevious();
                    pointer--;
                }
            }
        }
    }

    public void add(int value) {
        if (size() == 0) {
            head = new Node(value);
            tail = head;
            size++;
        } else if (size() == 1) {
            tail = new Node(value);
            tail.setPrevious(head);
            head.setNext(tail);
            size++;
        } else {
            Node n = tail;
            tail = new Node(value);
            tail.setPrevious(n);
            size++;
        }
    }

    public Node getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || size() == 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node n = head;
        if (index < size() / 2) {
            int pointer = 0;
            while (pointer <= index) {
                if (index == 0) {
                    break;
                }
                n = n.getNext();
                pointer++;
            }
        } else {
            n = tail;
            int pointer = size() - 1;
            while (pointer >= index) {
                if (index == size() - 1) {
                    break;
                }
                n = n.getPrevious();
                pointer--;
            }
        }
        return n;
    }

    public void add(int index, int value) throws IndexOutOfBoundsException {
        if (index < 0 || size() == 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            Node n = head;
            head = new Node(value);
            head.setNext(n);
            size++;
        } else if (index == size() - 1) {
            Node n = tail;
            tail = new Node(value);
            tail.setPrevious(n);
            size++;
        } else {
            Node n = getNodeByIndex(index);
            Node tmp = new Node(value);
            n.getPrevious().setNext(tmp);
            tmp.setPrevious(n.getPrevious());
            n.setPrevious(tmp);
            tmp.setNext(n);
            size++;
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || size() == 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = head.getNext();
            size--;
        } else if (index == size() - 1) {
            tail = tail.getPrevious();
            size--;
        } else {
            Node n = getNodeByIndex(index);
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
            size--;
        }
    }

    public int get(int index) {
        return getNodeByIndex(index).value;
    }

    public void addFirst(int value) {
        add(0, value);
    }

    public int getFirst() {
        return getNodeByIndex(0).value;
    }

    public void addLast(int value) {
        add(value);
    }

    public int getLast() {
        return getNodeByIndex(size() - 1).value;
    }

    public int removeFirst() {
        int temp = getFirst();
        remove(0);
        return temp;
    }

    public int removeLast() {
        if (size() == 0) {
            System.out.println("This collection is empty."); ;
        }
        Node n = tail;
        tail = tail.getPrevious();
        size--;
        return n.value;
    }

}
