package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9095 {

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());

        for (int i = 1; i <= t; i++) {
            answer = 0;
            int n = Integer.valueOf(br.readLine());
            dfs(0, n);

            System.out.println(answer);
        }

    }

    private static void dfs(int now, int n) {
        if (now > n) {
            return;
        }
        if (now == n) {
            answer++;
            return;
        }

        dfs(now + 1, n);
        dfs(now + 2, n);
        dfs(now + 3, n);

    }
}
