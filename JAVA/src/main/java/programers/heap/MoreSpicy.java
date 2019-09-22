package programers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scovile = {1, 2, 3, 9, 10, 12};
        System.out.println(solution.solution(scovile, 7));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {

            int answer = 0;
            Queue<Integer> scovilles = new PriorityQueue<>();
            for (int each : scoville) {
                scovilles.offer(each);
            }

            while (!isReach(scovilles, K)) {
                if (scovilles.size() == 1) {
                    return -1;
                }
                mix(scovilles);
                answer++;
            }

            return answer;
        }

        private void mix(Queue<Integer> scovilles) {
            Integer min = scovilles.poll();
            Integer nextMin = scovilles.poll();
            Integer mixed = min + nextMin * 2;
            scovilles.offer(mixed);
        }

        private boolean isReach(Queue<Integer> scovilles, int K) {
            return scovilles.peek() >= K;
        }
    }


}
