package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2563 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());
        int[][] map = new int[101][101];
        int[] x = new int[count];
        int[] y = new int[count];
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");
            x[i] = Integer.valueOf(arr[0]);
            y[i] = Integer.valueOf(arr[1]);
        }

        for (int i = 0; i < count; i++) {
            for (int sero = 0; sero < 10; sero++) {
                for (int garo = 0; garo < 10; garo++) {
                    map[x[i] + garo][y[i] + sero] = 1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[j][i] == 1)
                    answer++;
            }

        }
        System.out.println(answer);
    }
}
