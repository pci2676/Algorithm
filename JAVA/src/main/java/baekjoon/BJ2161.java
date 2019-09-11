package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2161 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new LinkedList<>();
        Queue<Integer> abandon = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            cards.offer(i);
        }

        while (true) {
            if (cards.size() == 1) {
                break;
            }
            int card = cards.poll();
            abandon.offer(card);
            if (cards.size() == 1) {
                break;
            }
            card = cards.poll();
            cards.offer(card);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n; i++) {
            answer.append(abandon.poll()).append(" ");
        }
        answer.append(cards.poll());
        System.out.println(answer.toString());
    }
}
