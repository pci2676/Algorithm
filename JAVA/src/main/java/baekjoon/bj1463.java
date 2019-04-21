package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1463 {

    //이전 시도 +1회
    private static int TRY = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1000001];

        int n = Integer.valueOf(br.readLine());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + TRY;

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + TRY) {
                    dp[i] = dp[i / 3] + TRY;
                }
            }

            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + TRY) {
                    dp[i] = dp[i / 2] + TRY;
                }
            }

        }


        System.out.println(dp[n]);
    }

}
