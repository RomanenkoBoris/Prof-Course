package lesson28.generic.list;

public class MyGenericArrayList <T> implements MyGenericList<T>  {


    // количество заполненных элементов, видимый пользователю размер контейнера
    private int size = 0;
    private T [] data; // массив в которому будут храниться элементы
    // начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    public MyGenericArrayList(){
        data = (T[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i++)
        {
            if(data[i].equals(value))
                return true;
        }
        return false;
    }

    @Override
    public void set(int index, T value) {
        // проверить что index находится в диапазоне 0 <= index < size
        // если не так, выбросим исключение
        if(index <0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public void add(T value) {
        // добавление элемента в конец
        // если size() == data.length то нужно
        if(size() == data.length) {
            //      создать массив большего размера
            //      скопировать туда все элементы из старого
            increaseCapacity();
        }
        // добавить в конец элемент value
        data[size] = value;
        // увеличить size
        size++;
    }

    private void increaseCapacity()
    {
        // нужно создать массив в 2 раза больше
        T [] newData = (T[]) new Object[data.length * 2];
        // скопировать элементы от 0 до data.length из старого массива в новый
        for(int i = 0; i < data.length; i++)
        {
            newData[i] = data[i];
        }
        // присвоить data ссылку на новый массив
        data = newData;
    }

    @Override
    public void add(int index, T value) {
        if(index <= 0 || index >= size())
            throw new IndexOutOfBoundsException();
        if(size() == data.length)
            increaseCapacity();
        for(int i = size() - 1; i >= index; i--)
        {
            data[i+1] = data[i];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        for (int i = index + 1; i < size(); i++)
        {
            data[i-1] = data[i];
        }
        size--;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public String toString() {
        String r = "[";
        for(int i = 0; i < size(); i++)
        {
            if(i != 0)
                r += ", ";
            r += data[i];
        }
        r += "]";
        return r;
    }
}
