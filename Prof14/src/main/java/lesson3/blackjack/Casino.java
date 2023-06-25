package lesson3.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Dealer d = new Dealer();
        Scanner scanner = new Scanner(System.in);
        List<Card> hand = new ArrayList<>();
        do {
            Card c = d.getCard();
            hand.add(c);
            System.out.println("Карта: " + c);
            int score = 0;
            for(Card card : hand)
            {
                score += card.getValue();
            }
            System.out.println("Ваш счет: " + score);
            System.out.println("Нажмите N для окончания игры");

        } while (!scanner.next().equals("N"));
    }
}
