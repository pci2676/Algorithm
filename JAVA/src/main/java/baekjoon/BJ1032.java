package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1032 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int amount = Integer.parseInt(br.readLine());
        String[] words = new String[amount];
        for (int i = 0; i < amount; i++) {
            words[i] = br.readLine();
        }

        int length = words[0].length();

        String[][] patterns = new String[amount][length];

        for (int i = 0; i < amount; i++) {
            patterns[i] = words[i].split("");
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isAllEqual = true;
            String word = patterns[0][i];
            for (int j = 1; j < amount; j++) {
                String compare = patterns[j][i];
                if (isNotEqual(word, compare)) {
                    isAllEqual = false;
                    break;
                }
            }
            if (isAllEqual) {
                answer.append(word);
            } else {
                answer.append("?");
            }
        }
        System.out.println(answer.toString());
    }

    private static boolean isNotEqual(String word, String compare) {
        return !word.equals(compare);
    }
}
