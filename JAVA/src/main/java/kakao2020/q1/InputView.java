package kakao2020.q1;


import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean inputAddCardQuestion() {
        Coin coin = new Coin(scanner.nextLine());
        return coin.isContinue();
    }

}

class Coin {
    private static final String CONTINUE = "y";
    private static final String STOP = "n";

    private String input;

    public Coin(String input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(String input) {
        if (input.equals(CONTINUE) || input.equals(STOP)) {
            return;
        }
        throw new IllegalArgumentException("y, n 만 입력");
    }

    public boolean isContinue() {
        return this.input.equals(CONTINUE);
    }
}