package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10844 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //길이 n
        Integer n = Integer.valueOf(br.readLine());

        //길이 + 1 만큼의 배열 생성
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        dp[1][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % 1000000000);
    }

}
