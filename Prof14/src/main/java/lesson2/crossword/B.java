package lesson2.crossword;

public class B extends A {
protected void world (){
    super.world();
    System.out.println("World from B");
}

    @Override
    public void hello() {
        System.out.println("Hello, Hello from B!!!");
    }
}
