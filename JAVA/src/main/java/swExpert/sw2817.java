package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw2817 {

    static int[] q;
    static int n, k;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.valueOf(br.readLine());

        for (int t = 1; t <= test; t++) {
            String line = br.readLine();
            int[] arr = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            n = arr[0];
            k = arr[1];

            line = br.readLine();
            q = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            answer = 0;

            //모든숫자를 꼭 포함하면서 루프를 돌도록
            for (int i = 0; i < n; i++) {
                dfs(i, q[i]);
            }

            System.out.println(String.format("#%d %d", t, answer));
        }
    }

    private static void dfs(int idx, int sum) {
        if (sum == k) {
            answer++;
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            dfs(i, sum + q[i]);
        }
    }
}
