package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class bj5585 {

    private static final int DEFAULT = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.valueOf(br.readLine());
        int count = 0;

        List<Integer> exchanges = Arrays.asList(500, 100, 50, 10, 5, 1);

        money = DEFAULT - money;

        for (int exchange : exchanges) {
            if (exchange <= money) {
                count += (money / exchange);
                money = money - (money / exchange) * exchange;
            }
        }

        System.out.println(count);

    }
}
