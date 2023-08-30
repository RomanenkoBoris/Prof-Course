package lesson17;

// функциональный интерфейс - содержит ТОЛЬКО ОДИН абстрактный метод
// абстрактный метод функионального интерфейса можно заменить на лямбда выражение

@FunctionalInterface // выдаст ошибку, если содержится болле одного АБСТРАКТНОГО метода
public interface NoArgsReturnDouble {
    double produce(); // единственный абстрактный метод
    default void hello(){ }
    static void print() {}
}


