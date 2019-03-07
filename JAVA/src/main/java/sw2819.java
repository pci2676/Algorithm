import java.util.HashSet;
import java.util.Scanner;

public class sw2819 {

    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {1, -1, 0, 0};

    static int testCase[][];
    static HashSet<Integer> hashSet;

    public static void main(String ars[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] answer = new int[T];
        for (int t = 0; t < T; t++) {
            testCase = new int[4][4];
            hashSet = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    testCase[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, testCase[i][j], 1);
                }
            }

            answer[t] = hashSet.size();
        }

        for (int t = 0; t < T; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }

    private static void dfs(int row, int col, int sum, int count) {
        if (count == 7) {
            hashSet.add(sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (x >= 0 && y >= 0 && x <= 3 && y <= 3) {
                dfs(x, y, (sum*10+testCase[x][y]), count+1);
            }
        }
    }

}
