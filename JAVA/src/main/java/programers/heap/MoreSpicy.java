package programers.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoreSpicy {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scovile = {0, 0, 3, 9, 10, 12};
        System.out.println(solution.solution(scovile, 13));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {

            int answer = 0;
            List<Integer> scovilles = new LinkedList<>();
            Arrays.sort(scoville);
            for (int each : scoville) {
                scovilles.add(each);
            }

            Mixer mixer = new Mixer();

            while (!isReach(scovilles, K)) {
                if (scovilles.size() == 1) {
                    return -1;
                }
                System.out.println(scovilles);
                answer++;
                mixer.mix(scovilles);
            }
            System.out.println(scovilles);

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
            for (int i = scovilles.size() - 1; i >= 0; i--) {
                if (scovilles.get(i) < mixed) {
                    scovilles.add(i + 1, mixed);
                    return;
                }
            }
            scovilles.add(0, mixed);
        }

    }
}
