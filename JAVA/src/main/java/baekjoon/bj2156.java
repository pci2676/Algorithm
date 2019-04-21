package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2156 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        long[] grape = new long[n + 2];
        long[] dp = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            grape[i] = Integer.valueOf(br.readLine());
        }

        dp[1] = grape[1];
        dp[2] = grape[1] + grape[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + grape[i - 1]) + grape[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }

}