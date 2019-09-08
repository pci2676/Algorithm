package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2455 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int[][] station = new int[4][2];
        int[] train = new int[4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());
            station[i][1] = Integer.parseInt(st.nextToken());
            train[i] = station[i][1] - station[i][0];
        }
        for (int i = 1; i < 4; i++) {
            train[i] = train[i - 1] + train[i];
        }

        System.out.println(Arrays.stream(train).max().orElse(0));
    }
}
