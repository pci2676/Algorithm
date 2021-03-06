package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2231 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int target = Integer.parseInt(br.readLine());
        int min = 1000000;
        for (int i = target % 10; i < target; i++) {
            if (isConstructor(i, target)) {
                if (min > target) {
                    min = i;
                    System.out.println(min);
                    return;
                }
            }
        }
        System.out.println(0);

    }

    private static boolean isConstructor(int maybeConstructor, int target) {
        String[] maybeString = String.valueOf(maybeConstructor).split("");
        int maybeTarget = maybeConstructor;
        for (String s : maybeString) {
            maybeTarget += Integer.parseInt(s);
            if (maybeTarget > target) {
                return false;
            }
        }
        return target == maybeTarget;
    }
}
