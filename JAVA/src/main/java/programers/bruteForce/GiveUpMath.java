package programers.bruteForce;

import java.util.Arrays;

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

            String answerIndex = "";

            for (int i = 0; i < count.length; i++) {
                if (max == count[i]) {
                    answerIndex += i+1;
                }
            }

            answer = Arrays.stream(answerIndex.split(""))
                    .mapToInt(Integer::valueOf)
                    .toArray();

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
