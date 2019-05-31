package programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lv1Test1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        System.out.println(result);
    }
}
