package programers.heap;

import java.util.LinkedList;
import java.util.List;

public class MoreSpicy {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scovile = {1, 2, 3, 9, 10, 12};
        System.out.println(solution.solution(scovile, 7));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            List<Integer> scovilles = new LinkedList<>();
            for (int each : scoville) {
                scovilles.add(each);
            }
            Mixer mixer = new Mixer();

            while (!isReach(scovilles, K)) {
                answer++;
                mixer.mix(scovilles);

                if (scovilles.size() == 1) {
                    return -1;
                }
            }

            return answer;
        }

        private boolean isReach(List<Integer> scoville, int K) {
            for (Integer sco : scoville) {
                if (sco < K) {
                    return false;
                }
            }
            return true;
        }


    }

    static class Mixer {

        public void mix(List<Integer> scovilles) {
            Integer mostOfLower = scovilles.get(0);
            Integer nextLower = scovilles.get(1);
            Integer mixed = mostOfLower + nextLower * 2;
            scovilles.remove(mostOfLower);
            scovilles.remove(nextLower);
            addMixed(scovilles, mixed);
        }

        private void addMixed(List<Integer> scovilles, Integer mixed) {
            for (int i = 0; i < scovilles.size(); i++) {
                if (scovilles.get(i) < mixed) {
                    scovilles.add(i, mixed);
                    return;
                }
            }
        }

    }
}
