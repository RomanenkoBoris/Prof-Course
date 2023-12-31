package HomeWork4.Task5_6;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList implements MyList, Iterable<Integer>{

    @Override
    public Iterator<Integer> reversIterator() {
        return new Iterator<Integer>() {

            private int position = size();
            @Override
            public boolean hasNext() {
                return --position >= 0;
            }

            @Override
            public Integer next() {
                return get(position);
            }
        };
    }

    @Override
    public Iterator<Integer> valueIterator(){
        int [] array = new int[this.size()];
        Iterator<Integer> iterator = this.iterator();
        int pointer = 0;
        while (iterator.hasNext()){
            array[pointer] = iterator.next();
            pointer++;
        }
        Arrays.sort(array);


        return new Iterator<Integer>() {
            int position = -1;
            @Override
            public boolean hasNext() {
                return ++position < array.length;
            }

            @Override
            public Integer next() {
                return array[position];
            }
        };
    }

    public Iterator<Integer> iterator(){
      return new Iterator<Integer>() {
          // номер текущего элемента
          private int position = -1;
          @Override
          public boolean hasNext() {
              return ++position < size;
          }

          @Override
          public Integer next() {
              return get(position);
          }

          @Override
          public void remove(){
              MyArrayList.this.remove(position--);
          }
      };
    };

    // количество заполненных элементов, видимый пользователю размер контейнера
    private int size = 0;
    private int [] data; // массив в котором будут храниться элементы
    private static final int INITIAL_CAPACITY = 4; // начальный размер массива

    public MyArrayList(){
        data = new int[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size(); i++)
        {
            if(data[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public void set(int index, int value) {
        // проверить что index находится в диапазоне 0 <= index < size
        // если не так, выбросим исключение
        if(index <0 || index >= size)
            throw new IndexOutOfBoundsException();
        // изменить значение по индексу index
        data[index] = value;
    }

    @Override
    public void add(int value) {
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
        int[] array = new int [data.length*2];
        for (int i = 0; i<data.length; i++){
            array[i]=data[i];
        }
        data = array;
    }

    @Override
    public void add(int index, int value) {
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
    public int get(int index) {
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
