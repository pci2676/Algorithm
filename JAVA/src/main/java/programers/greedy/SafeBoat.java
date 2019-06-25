package programers.greedy;

import java.util.Arrays;

public class SafeBoat {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        Arrays.sort(people);
        boolean[] moved = new boolean[people.length];

        int small = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            if (moved[i]) {
                continue;
            }
            int first = people[i];
            moved[i] = true;

            for (int j = small; j < people.length; j++) {
                if (moved[j]) {
                    continue;
                }
                int second = people[j];
                if (first + second > limit) {
                    break;
                }
                small++;
                moved[j] = true;
                break;
            }
            answer++;
        }

        System.out.println(answer);

    }

    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            return answer;
        }
    }
}
