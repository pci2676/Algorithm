package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14502 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    private static int[][] map;
    private static int[][] tempMap;

    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[col][row];

        for (int y = 0; y < row; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < col; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int fy = 0; fy < row; fy++) {
            for (int fx = 0; fx < col; fx++) {

                for (int sy = 0; sy < row; sy++) {
                    for (int sx = 0; sx < col; sx++) {

                        for (int ty = 0; ty < row; ty++) {
                            for (int tx = 0; tx < col; tx++) {
                                if (isSamePoint(fx, fy, sx, sy) || isSamePoint(fx, fy, tx, ty) || isSamePoint(sx, sy, tx, ty)) {
                                    continue;
                                }
                                int[][] lab = getOriginal();
                                if (isNotBlank(lab, fx, fy) || isNotBlank(lab, sx, sy) || isNotBlank(lab, tx, ty)) {
                                    continue;
                                }
                                lab[fx][fy] = 1;
                                lab[sx][sy] = 1;
                                lab[tx][ty] = 1;
                                int safeCount = getSafeCount(lab);
                                if (max < safeCount) {
                                    max = safeCount;
                                }
                            }
                        }

                    }
                }

            }
        }

        System.out.println(max);
    }

    private static int[][] getOriginal() {
        int[][] lab = new int[col][row];
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                lab[x][y] = map[x][y];
            }
        }
        return lab;
    }

    private static boolean isNotBlank(int[][] lab, int x, int y) {
        return lab[x][y] == 1 || lab[x][y] == 2;
    }

    private static boolean isSamePoint(int x, int y, int xx, int yy) {
        if (x == xx) {
            return y == yy;
        }
        return false;
    }

    private static int getSafeCount(int[][] lab) {
        int[][] dirtyLab = spreadDirty(lab);
        int count = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (dirtyLab[x][y] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] spreadDirty(int[][] lab) {
        tempMap = lab;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (lab[x][y] == 2) {
                    spread(x, y);
                }
            }
        }
        return tempMap;
    }

    private static void spread(int x, int y) {
        for (int direction = 0; direction < 4; direction++) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx > -1 && nx < col && ny > -1 && ny < row) {
                spreadOut(nx, ny);
            }
        }
    }

    private static void spreadOut(int x, int y) {
        if (tempMap[x][y] == 1 || tempMap[x][y] == 2) {
            return;
        }
        if (tempMap[x][y] == 0) {
            tempMap[x][y] = 2;
        }
        spread(x, y);
    }

}
