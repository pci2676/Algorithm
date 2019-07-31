package swExpert;

import java.util.Scanner;

public class sw1226 {

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static String[][] map;
    static int maxDistance[] = new int[10];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            map = new String[16][16];
            maxDistance[t] = 0;
            int testCaseNumber = scanner.nextInt();

            for (int i = 0; i < 16; i++) {
                String line = scanner.next();
                String[] splitted = line.split("");
                for (int j = 0; j < 16; j++) {
                    map[j][i] = splitted[j];
                }
            }

            dfs(1, 1, t);

            System.out.println("#" + testCaseNumber + " " + maxDistance[t]);
        }
    }

    private static void dfs(int col, int row, int t) {

        if (map[col][row].equals("3")) {
            maxDistance[t] = 1;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int x = col + dx[i];
                int y = row + dy[i];
                if (!map[x][y].equals("1")) {
                    map[col][row] = "1";
                    dfs(x, y, t);
                    map[col][row] = "0";
                }
            }
        }
    }
}
