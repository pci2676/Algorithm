package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class sw3752_R {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Integer> numbers;

    public static void main(String[] args) throws Exception {

        int testCaseAmount = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseAmount; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] visit = new boolean[10001];

            String[] numberStrings = br.readLine()
                    .split(" ");
            int[] numbers = Arrays.stream(numberStrings)
                    .mapToInt(Integer::valueOf)
                    .toArray();

            visit[0] = true;

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            for (int number : numbers) {
                for (int i = sum; i >= 0; i--) {
                    if (visit[i]) {
                        visit[number + i] = true;
                    }
                }
            }

            int answer = 0;
            for (boolean maybe : visit) {
                if (maybe) {
                    answer++;
                }
            }

            System.out.println(String.format("#%d %d", t, answer));
        }
    }

}
