package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj6359 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int t = Integer.valueOf(br.readLine());

        for (int test = 1; test <= t; test++) {
            int answer = 0;
            int room = Integer.valueOf(br.readLine());

            for (int i = 1; i <= room; i++) {
                int yaksu = 0;
                for (int j = 1; j <= i / j; j++) {
                    if (i % j != 0) {
                        continue;
                    }
                    yaksu = yaksu + 2;
                    if ((i / j) == j) {
                        yaksu--;
                    }
                }
                if (yaksu % 2 != 0) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
