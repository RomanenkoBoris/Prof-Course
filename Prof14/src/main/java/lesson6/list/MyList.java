package lesson6.list;

import java.util.Iterator;

// интерфейс это шаблон - набор методов, которые должны
// реализовываться его потомками его методы по умолчанию public
// поэтому нет даже смысла прописывать модификаторы доступа
public interface MyList <T> extends Iterable<T> {
    int size(); // размер
    boolean contains(T value); // содержится ли в листе такое значение
    void set(int index, T value); // изменение значения элемента по индексу
    void add(T value); // добавление элемента в конец
    void add(int index, T value); // вставка элемента
    void remove(int index); // удаление элемента по индексу
    T get(int index); // получение значения по индексу

    Iterator<T> iterator();

    Iterator<T> backward();
}
