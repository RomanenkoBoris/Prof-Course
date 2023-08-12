package HomeWork5;

public class MyStack extends MyLinkedList {

    public MyStack() {
    }

    public boolean empty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int peek() {
        return getLast();
    }

    public int pop() {
        return removeLast();
    }

    public void push(int value) {
        add(value);
    }

    public int search(int value) {
        int position = 0;
        Node n = getNodeByIndex(size() - 1);
        while (n != null) {
            if ( n.getValue() == value){
                return position;
            } else {
                n = n.getPrevious();
            }
            position++;
        }
        return -1;
    }

}
