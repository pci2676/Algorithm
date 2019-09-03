package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9465 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {

            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < n; col++) {
                    stickers[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            dp[0][1] = dp[1][0] + stickers[0][1];
            dp[1][1] = dp[0][0] + stickers[1][1];

            for (int col = 2; col < n; col++) {
                dp[0][col] = Math.max(dp[1][col - 1], dp[1][col - 2]) + stickers[0][col];
                dp[1][col] = Math.max(dp[0][col - 1], dp[0][col - 2]) + stickers[1][col];
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
