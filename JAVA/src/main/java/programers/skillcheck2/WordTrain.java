package programers.skillcheck2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordTrain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}), new int[]{3, 3}));
        System.out.println(Arrays.equals(solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}), new int[]{1, 3}));
    }

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            Queue<String> queue = Arrays.stream(words)
                    .collect(Collectors.toCollection(LinkedList::new));

            Set<String> Dictionary = new HashSet<>();

            int order = 1;
            int who = 1;
            int turn = 1;

            String before = queue.poll();
            Dictionary.add(before);

            while (!queue.isEmpty()) {

                String now = queue.poll();

                if (!checkRule(before, now) || !Dictionary.add(now)) {
                    who = cycle(who + 1, n);
                    answer[0] = who;
                    answer[1] = turn;
                    break;
                }

                who = cycle(who + 1, n);
                order++;

                if (order % n == 0) {
                    turn++;
                }

                before = now;
            }

            return answer;
        }

        private boolean checkRule(String before, String now) {
            return before.charAt(before.length() - 1) == now.charAt(0);
        }

        private int cycle(int who, int n) {
            if (who == n + 1) {
                return 1;
            }
            return who;
        }
    }

}
