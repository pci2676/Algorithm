package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj6603 {

    static List<Integer> answer;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] test = new int[1];
        test[0] = 1;

        while (test[0] != 0) {
            String line = br.readLine();
            String[] arr = line.split(" ");
            test = Arrays.stream(arr)
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int length = test[0];
            int[] numbers = new int[length];
            for (int i = 1; i <= length; i++) {
                numbers[i - 1] = test[i];
            }

            for (int i = 0; i < length; i++) {
                if (length - i == 5) {
                    break;
                }
                answer = new ArrayList<>();
                dfs(numbers, i, length);
            }
            System.out.println();
        }
    }

    private static void dfs(int[] numbers, int index, int length) {
        answer.add(numbers[index]);

        if (answer.size() == 6) {
            sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(answer.get(i));
                sb.append(" ");
            }
            System.out.println(sb.toString());
        } else {
            for (int i = 1; i < length; i++) {
                if (i + index >= length) {
                    break;
                }
                dfs(numbers, index + i, length);
            }

        }
        deleteEnd();
    }

    private static void deleteEnd() {
        int last = answer.size() - 1;
        answer.remove(last);
    }
}
