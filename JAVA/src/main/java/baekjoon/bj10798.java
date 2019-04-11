package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj10798 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        String[][] arr = new String[5][];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            arr[i] = line.split("");
        }

        for (int x = 0; x < 15; x++) {

            for (int y = 0; y < 5; y++) {
                int arr_max_x = arr[y].length;
                if (x >= arr_max_x) {
                    continue;
                }
                System.out.print(arr[y][x]);
            }
        }
    }
}
