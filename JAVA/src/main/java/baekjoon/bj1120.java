package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1120 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String[] arrA = a.split("");
        String[] arrB = b.split("");

        int size = b.length() - a.length() + 1;

        int answer = 50;
        for (int i = 0; i < size; i++) {
            int min = 0;
            for (int j = i, k = 0; j < i + a.length(); j++, k++) {
                if (!arrA[k].equals(arrB[j])) {
                    min++;
                }
            }
            if (answer > min) {
                answer = min;
            }
        }
        System.out.println(answer);
    }
}
