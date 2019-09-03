package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2579_2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1] + stairs[0];
        dp[2] = Math.max(stairs[2] + stairs[0], stairs[2] + stairs[1]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);
        }

        System.out.println(dp[n - 1]);

    }
}
