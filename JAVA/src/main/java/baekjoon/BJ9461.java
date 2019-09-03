package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long test = Long.parseLong(br.readLine());
        for (long t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] p = new long[n + 11];
            init(p);
            for (int i = 10; i <= n; i++) {
                p[i] = p[i - 1] + p[i - 5];
            }
            System.out.println(p[n]);
        }
    }

    private static void init(long[] p) {
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;
        p[6] = 3;
        p[7] = 4;
        p[8] = 5;
        p[9] = 7;
        p[10] = 9;
    }
}
