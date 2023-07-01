package lesson4.Animals;

public class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woow");
    }

    @Override
    public void greets(Dog dog) {
        System.out.println("Woooow");
    }

    // перегруженный метод не получится вызвать по ссылке на базовый класс
    // Перегрузка не является переопределением (??), поэтому @Override нет
    public void greets(BigDog bigDog) {
        System.out.println("Wooow");
    }

}
