package lesson3.animals;

// наследование от интерфейса применяется если мы хотим
// в производных классах иметь набор из методов для реализации
// и не нужно никакое базовое состояние и базовая логика
public interface Animal {
    // интерфейс не может иметь состояния
    // public String name;
    void move();
    void voice();
}
