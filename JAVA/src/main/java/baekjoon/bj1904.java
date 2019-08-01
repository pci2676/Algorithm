package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1904 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        //길이 n
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 100];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;

        for (int i = 6; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[n]);

    }

}
