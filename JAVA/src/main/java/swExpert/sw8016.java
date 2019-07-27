package swExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw8016 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.valueOf(br.readLine());

        for (int t = 1; t <= T; t++) {

            long left = (t - 1) * (t - 1) * 2 + 1;
            long right = t * t * 2 - 1;


            System.out.println(String.format("#%d %d %d", t, left, right));
        }
    }
}
