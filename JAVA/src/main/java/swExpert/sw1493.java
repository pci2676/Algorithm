package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw1493 {

    static int[][] map = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initMap();

        int t = Integer.valueOf(br.readLine());

        for (int test = 1; test <= t; test++) {
            int p, q;
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            p = arr[0];
            q = arr[1];
            System.out.println(String.format("#%d %d", test, starOperation(p, q)));
        }
    }

    private static void initMap() {
        map[1][1] = 1;
        for (int y = 1; y <= 999; y++) {
            map[1][y + 1] = map[1][y] + y;
        }
        for (int x = 2; x <= 1000; x++) {
            map[x][1] = map[x - 1][1] + x;
        }

        for (int y = 2; y <= 1000; y++) {
            for (int x = 1; x <=999; x++) {
                map[x + 1][y] = map[x][y] + y + x;
            }
        }
    }

    private static int sharpOperation(int x, int y) {
        return map[x][y];
    }

    private static int andOperationX(int p) {
        int answer = 0;

        for (int y = 1; y <= 1000 && answer == 0; y++) {
            for (int x = 1; x <= 1000 && answer == 0; x++) {
                if (map[x][y] == p) {
                    answer = x;
                    break;
                }
                if (map[x][y] > p) {
                    break;
                }
            }
        }
        return answer;
    }

    private static int andOperationY(int p, int px) {
        int answer = 0;

        for (int y = 1; y <= 1000 && answer == 0; y++) {
            if (map[px][y] == p) {
                answer = y;
            }
        }
        return answer;
    }

    private static int starOperation(int p, int q) {
        int px, py;
        int qx, qy;
        px = andOperationX(p);
        py = andOperationY(p, px);
        qx = andOperationX(q);
        qy = andOperationY(q, qx);

        int pqx = px + qx;
        int pqy = py + qy;

        return sharpOperation(pqx, pqy);
    }
}
