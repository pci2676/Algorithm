package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4948 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int MAX = 123456 * 2;

    private static int[] all;

    public static void main(String[] args) throws Exception {
        all = new int[246912+1];

        int number = getNumber();
        long answer;

        getPrime();

        while (!isZero(number)) {

            answer = getCount(number);
            System.out.println(answer);

            number = getNumber();
        }
    }

    private static void getPrime() {

        for(int i = 2;i<=MAX;i++){
            all[i]=i;
        }

        for (int i = 2; i <= MAX; i++) {
            if (all[i] == 0) {
                continue;
            }
            for (int j = i * 2; j <= MAX; j = j + i) {
                all[j] = 0;
            }
        }
    }

    private static int getNumber() throws Exception {
        return Integer.valueOf(br.readLine());
    }

    private static boolean isZero(int number) {
        return number == 0;
    }

    private static long getCount(int number) {
        int count = 0;
        for (int i = number + 1; i <= number * 2; i++) {
            if (all[i] != 0) {
                count++;
            }
        }
        return count;
    }
}
