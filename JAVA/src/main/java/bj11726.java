import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11726 {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        dp = new long[n + 2];

        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);
    }

}
