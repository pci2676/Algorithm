package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9095_2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.valueOf(br.readLine());

        long[] answers = new long[12];

        answers[1] = 1;
        answers[2] = 2;
        answers[3] = 4;

        for (int test = 1; test <= T; test++) {
            int target = Integer.valueOf(br.readLine());

            int cache = 4;
            for (int i = cache; i <= target; i++, cache++) {
                answers[i] = answers[i - 1] + answers[i - 2] + answers[i - 3];
            }

            System.out.println(answers[target]);
        }
    }
}
