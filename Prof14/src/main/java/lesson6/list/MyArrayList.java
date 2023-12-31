package lesson6.list;

import java.util.Iterator;

public class MyArrayList <T> implements MyList <T>, Iterable<T>{

    public Iterator<T> iterator(){
      return new Iterator<T>() {
          // номер текущего элемента
          private int position = -1;
          @Override
          public boolean hasNext() {
              return ++position < size;
          }

          @Override
          public T next() {
              return get(position);
          }

          @Override
          public void remove(){
              MyArrayList.this.remove(position--);
          }
      };
    }

    @Override
    public Iterator<T> backward() {
        return null;
    }

    ;

    // количество заполненных элементов, видимый пользователю размер контейнера
    private int size = 0;
    private T [] data; // массив в котором будут храниться элементы
    private static final int INITIAL_CAPACITY = 4; // начальный размер массива

    public MyArrayList(){
        data = (T[]) new Object [INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i++)
        {
            if(data[i] == value)
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
        // изменить значение по индексу index
        data[index] = value;
    }

    @Override
    public void add(T value) {
        // добавление элемента в конец
        // если size() == data.length то нужно
        if (size() == data.length) {
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
        T [] array = (T[]) new Object [data.length*2];
        for (int i = 0; i<data.length; i++){
            array[i]=data[i];
        }
        data = array;
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
        if(index <0 || index >= size)
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
