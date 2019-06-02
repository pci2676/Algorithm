package programers.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiveUpMath {
    static class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            int[][] supoja = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
            int[] count = {0, 0, 0};

            for (int i = 0; i < answers.length; i++) {
                for (int who = 0; who < 3; who++) {
                    int target = i % supoja[who].length;
                    if (answers[i] == supoja[who][target]) {
                        count[who]++;
                    }
                }
            }

            int max = Arrays.stream(count)
                    .max()
                    .getAsInt();

            List<Integer> answerIndex = new ArrayList<>();

            for (int i = 0; i < count.length; i++) {
                if (max == count[i]) {
                    answerIndex.add(i + 1);
                }
            }

            answer = new int[answerIndex.size()];
            for (int i = 0; i < answerIndex.size(); i++) {
                answer[i] = answerIndex.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] answers = {1, 2, 3, 4, 5};
        solution.solution(answers);
        answers = new int[]{1, 3, 2, 4, 2};
        solution.solution(answers);
    }
}
