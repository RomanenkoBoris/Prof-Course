package lesson11;

public class CustomDequeImpl implements CustomDeque {

    private int[] source; // содержимое
    private int size = 0; // начальный размер
    private int firstElementIndex = 0; // иднекс первого элемента

    private static final int CAPACITY = 4; // начальный размер массива

    public CustomDequeImpl() {
        source = new int[CAPACITY];
    }

    @Override
    public String toString() {
        // [1, 2, 3]
        String r = "[";
        for (int i = 0; i < size(); i++) {
            int v = source[(firstElementIndex + i) % source.length];
            r += v;
            if (i < size() - 1)
                r += ", ";
        }
        r += "]";
        return r;
    }

    @Override
    public void addFirst(int i) {
        // нужно проверить не равен ли size размеру массива
        if (size == source.length) {
            // если да, то нужно пересоздать массив и скопировать в него элементы
            increaseCapacity();
        }

        // поменять firstElementIndex
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        // добавить элемент в нужное место
        source[firstElementIndex] = i;
        // увеличить size
        size++;
    }

    private void increaseCapacity() {
        int[] newSource = new int[source.length * 2];
        for (int i = 0; i < size(); i++) {
            int v = source[(firstElementIndex + i) % source.length];
            newSource[i] = v;
        }
        firstElementIndex = 0;
        source = newSource;
    }

    @Override
    public int getFirst() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        int tmp = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size -= 1;
        return tmp;
    }

    @Override
    public void addLast(int i) {
        if (size() == source.length) {
            increaseCapacity();
        }
        source[(firstElementIndex + size()) % source.length] = i;
        size++;
    }

    @Override
    public int getLast() throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return source[(firstElementIndex + size() - 1) % source.length];
    }

    @Override
    public int removeLast() throws IndexOutOfBoundsException {
        /*
        // выбросить исключение если есть необходимость
        if(size() == 0)
            throw new IndexOutOfBoundsException();
        // определить индекс последнего элемента
        int lastElementIndex = (firstElementIndex + size() - 1) % source.length;
        // сохранить значение последнего элемента во временную переменную
        int v = source[lastElementIndex];
        // уменьшить размер
        size--;
        // вернуть сохраненное значение
        return v;
         */
        int v = getLast();
        size--;
        return v;
    }

    @Override
    public int size() {
        return size;
    }
}
