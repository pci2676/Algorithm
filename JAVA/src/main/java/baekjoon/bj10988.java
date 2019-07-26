package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10988 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        String[] arr = line.split("");

        int length = arr.length;

        int answer = 1;

        for (int i = 0; i < length / 2; i++) {
            if (!arr[i].equals(arr[length - 1 - i])) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }
}
