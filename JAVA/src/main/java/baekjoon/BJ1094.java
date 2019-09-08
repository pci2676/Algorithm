package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1094 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int FIRST_STICK = 64;

    public static void main(String[] args) throws Exception {
        int x = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int sum = 0;
        int stick = FIRST_STICK;
        if (x == FIRST_STICK) {
            System.out.println(1);
            return;
        }

        while (sum != x && sum + stick != x) {
            stick = stick / 2;

            if (sum + stick <= x) {
                list.add(stick);
                sum += stick;
            }
        }

        System.out.println(list.size());
    }

}