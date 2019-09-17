package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ2309 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            heights.add(Integer.parseInt(br.readLine()));
        }

        boolean flag = false;

        for (int i = 0; i < 8; i++) {
            List<Integer> maybe;
            for (int j = i + 1; j < 9; j++) {
                maybe = new ArrayList<>(heights);
                maybe.remove(j);
                maybe.remove(i);
                int sum = maybe.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

                if (sum == 100) {
                    flag = true;
                    heights = maybe;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        heights.sort(Integer::compareTo);
        heights.forEach(System.out::println);

    }
}
