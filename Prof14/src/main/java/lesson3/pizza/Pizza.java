package lesson3.pizza;

import javax.swing.*;

public class Pizza {
    private int peperoni;
    private int mashroom;
    private int cheese;

    private PizzaSize size;

    public Pizza(int peperoni, int mashroom, int cheese, PizzaSize size) {
        this.peperoni = peperoni;
        this.mashroom = mashroom;
        this.cheese = cheese;
        this.size = size;
    }

    public double price() {
        double price = 0;
//        if (size.equals("Small"))
//            price += 10;
//        else if (size.equals("Medium"))
//            price += 12;
//        else
//            price += 14;
        switch (size)
        {
            case SMALL:
                price += 10;
                break;
            case MEDIUM:
                price += 12;
                break;
            case BIG:
                price += 14;
                break;
        }
        price += (peperoni + cheese + mashroom) * 2;
        return price;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza(2,1,3, PizzaSize.MEDIUM);
    }

}
