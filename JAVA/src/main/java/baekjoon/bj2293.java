package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        dp[0] = 1;

        for (int i = 0; i < amount; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - values[i] >= 0) {
                    dp[j] = dp[j] + dp[j - values[i]];
                }
            }
        }

        System.out.println(dp[target]);
    }
}
