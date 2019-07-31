package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj14501_DP {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int end = Integer.valueOf(br.readLine());
        int T[] = new int[end + 15];
        int P[] = new int[end + 15];
        int dp[] = new int[end + 15];

        for (int day = 1; day <= end; day++) {
            String line = br.readLine();
            int[] dayAndWork = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            T[day] = dayAndWork[0];
            P[day] = dayAndWork[1];
        }

        for (int day = end; day >= 1; day--) {
            int totalDay = day + T[day];

            if (totalDay <= end + 1) {
                dp[day] = Math.max(P[day] + dp[totalDay], dp[day + 1]);
            } else {
                dp[day] = dp[day + 1];
            }
        }

        int answer = dp[1];

        System.out.println(answer);
    }
}