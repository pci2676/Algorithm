import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2579 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stair = Integer.valueOf(br.readLine());
        int[] stairs = new int[stair + 1];
        int[] dp = new int[stair + 1];

        for (int i = 1; i <= stair; i++) {
            stairs[i] = Integer.valueOf(br.readLine());
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        for (int i = 4; i <= stair; i++) {
            dp[i] = Math.max(stairs[i]+stairs[i-1]+dp[i-3],stairs[i]+dp[i-2]);
        }

        System.out.println(dp[stair]);
    }
}
