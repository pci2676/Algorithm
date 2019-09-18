package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1182 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Integer> numbers;

    private static int n;
    private static int s;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            for (int targetAmount = 1; targetAmount <= n; targetAmount++) {
                dfs(i, targetAmount, 1, numbers.get(i));
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int targetAmount, int amount, int sum) {
        if (targetAmount == amount) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        for (int nextIndex = index + 1; nextIndex < n; nextIndex++) {
            dfs(nextIndex, targetAmount, amount + 1, sum + numbers.get(nextIndex));
        }
    }
}
