package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2193 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        long[] dp = new long[n + 4];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            for (int j = 2; i - j >= 1; j++) {
                dp[i] += dp[i - j];
            }
            dp[i]++;
        }

        System.out.println(dp[n]);
    }

}
