package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2908 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        int[] a = Arrays.stream(first.split(""))
                .mapToInt(Integer::valueOf)
                .toArray();
        int[] b = Arrays.stream(second.split(""))
                .mapToInt(Integer::valueOf)
                .toArray();

        int aa = 0;
        int bb = 0;

        for (int i = 2; i >= 0; i--) {
            aa = aa * 10 + a[i];
            bb = bb * 10 + b[i];
        }
        if (aa > bb) {
            System.out.println(aa);
        } else {
            System.out.println(bb);
        }
    }
}
