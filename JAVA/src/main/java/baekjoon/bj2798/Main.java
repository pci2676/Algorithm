package baekjoon.bj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken()); // m
        List<Card> cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .map(Card::new)
                .collect(Collectors.toList());

        BlackJackGame game = new BlackJackGame(target);

        for (int i = 0; i < cards.size() - 2; i++) {
            List<Card> userCards = new ArrayList<>();
            userCards.add(cards.get(i));
            game.start(userCards);
            pickAnother(game, cards, i);
        }

        System.out.println(game.getMax());
    }

    private static void pickAnother(BlackJackGame game, List<Card> cards, int beforeIndex) {
        if (game.isReachTarget()) {
            return;
        }

        if (game.hasThree()) {
            game.changeMax();
            return;
        }

        for (int i = beforeIndex + 1; i < cards.size(); i++) {
            Card nextCard = cards.get(i);
            game.addCard(nextCard);
            pickAnother(game, cards, i);
            game.abandonCard(nextCard);
        }
    }

}

class Card {

    private Integer number;

    public Card(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

}

class BlackJackGame {

    private Integer target;
    private Integer max = -1;
    private List<Card> userCards;

    public BlackJackGame(Integer target) {
        this.target = target;
    }

    public Integer getMax() {
        return max;
    }

    public void start(List<Card> cards) {
        this.userCards = cards;
    }

    public boolean hasThree() {
        return userCards.size() == 3;
    }

    private int getSum() {
        return userCards.stream()
                .mapToInt(Card::getNumber)
                .sum();
    }

    private boolean isOver() {
        int sum = getSum();
        return sum > target;
    }

    public void changeMax() {
        int sum = getSum();
        if (isOver()) {
            return;
        }
        if (sum > this.max) {
            max = sum;
        }
    }

    public void addCard(Card nextCard) {
        this.userCards.add(nextCard);
    }

    public void abandonCard(Card nextCard) {
        this.userCards.remove(nextCard);
    }

    public boolean isReachTarget() {
        return this.target.equals(this.max);
    }
}


