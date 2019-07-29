package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2293 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int amount = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());
        int[] values = new int[amount];
        long[] dp = new long[target + 1];

        for (int i = 0; i < amount; i++) {
            values[i] = Integer.valueOf(br.readLine());
        }
        dp[values[0]] = 1;

        for (int i = values[0]; i <= target; i++) {

            int range;
            if (i % 2 == 0) {
                range = i / 2 + 1;
            } else {
                range = i / 2;
            }

            for (int j = 1; j < range; j++) {
                dp[i] = dp[j] + dp[i - j];
            }

            if (Arrays.asList(values).contains(dp[i])) {
                dp[i]++;
            }
        }

        System.out.println(dp[target]);
    }
}
