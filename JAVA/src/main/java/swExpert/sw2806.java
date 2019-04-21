package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw2806 {

    static int[][] map;
    static int n;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.valueOf(br.readLine());

        for (int t = 1; t <= test; t++) {
            answer = 0;
            n = Integer.valueOf(br.readLine());

            map = new int[n][n];

            fillMap(0,0,0);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void printMap() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    //1. 가로로 이동하면서 찍고 확인하기
    //2. 가로로 전부 이동하거나 찍은게 유효하면 아래부터 다시시작
    //3. y가 n일때 count가 n이면 answer추가 후 리턴

    private static void fillMap(int x, int y, int count) {
        if (y == n) {
            printMap();
            if (count == n) {
                answer++;
            }
            return;
        }

        if (isValid(x, y)) {
            map[x][y] = 1;
            fillMap(0, y + 1, count + 1);
            map[x][y] = 0;

        }
        if (x + 1 == n) {
            return;
        }
        fillMap(x + 1, y, count);

    }


    private static boolean isValid(int x, int y) {

        //위로
        for (int i = y; i >= 0; i--) {
            if (map[x][i] == 1) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            //왼위로
            if (x - i >= 0 && y - i >= 0) {
                if (map[x - i][y - i] == 1)
                    return false;
            }
            //오위로
            if (x + i < n && y - i >= 0) {
                if (map[x + i][y - i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
