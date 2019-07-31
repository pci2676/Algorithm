package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11052 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int N = Integer.valueOf(br.readLine());
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        long[] P = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = Integer.valueOf(st.nextToken());
        }

        long[] dp = new long[N + 1];

        dp[1] = P[1];
        dp[2] = Math.max(dp[1] * 2, P[2]);

        for (int i = 3; i <= N; i++) {
            long max = P[i];

            int mid = i / 2;
            if (i % 2 == 1) {
                mid++;
            }

            for (int j = i - 1; j >= mid; j--) {
                long temp = dp[j] + dp[i - j];
                max = Math.max(max, temp);
            }

            dp[i] = max;
        }

        System.out.println(dp[N]);

    }
}
