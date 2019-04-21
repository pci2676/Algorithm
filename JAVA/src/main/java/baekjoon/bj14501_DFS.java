package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj14501_DFS {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int NEED_DAY = 0;
    private static final int PAYMENT = 1;

    static int end;
    static int[][] works;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        end = Integer.valueOf(br.readLine());
        works = new int[end + 1][2];

        for (int day = 1; day <= end; day++) {
            String line = br.readLine();
            int[] dayAndWork = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            works[day][0] = dayAndWork[0];
            works[day][1] = dayAndWork[1];
        }

        dfs(1, 0);

        System.out.println(answer);
    }

    private static void dfs(int now, int pay) {
        if (now == end + 1) {
            if (pay > answer) {
                answer = pay;
            }
            return;
        }

        //상담안함
        dfs(now + 1, pay);
        //상담할수있으면 상담함
        if (now + works[now][NEED_DAY] <= end + 1) {
            dfs(now + works[now][NEED_DAY], pay + works[now][PAYMENT]);
        }
    }
}
