package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9625 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            b = (b * (-1) + a * (-1)) * (-1);
            a = temp;
            temp = b;
        }
        System.out.println(a + " " + b);
    }

}
