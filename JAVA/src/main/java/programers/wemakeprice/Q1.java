package programers.wemakeprice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1 {
    public static void main(String[] args) {

    }

    class Solution {
        Set<Integer> duplicateCheck = new HashSet<>();
        List<Integer> checked = new ArrayList<>();

        public int[] solution(int[] waiting) {
            int[] answer;

            for (int i = 0; i < waiting.length; i++) {
                int waitId = waiting[i];
                if (isDuplicate(waitId)) {
                    continue;
                }
                addId(waitId);
            }

            answer = new int[checked.size()];
            for (int i = 0; i < checked.size(); i++) {
                answer[i] = checked.get(i);
            }

            return answer;
        }

        private boolean isDuplicate(int id) {
            return duplicateCheck.contains(id);
        }

        private void addId(int id) {
            checked.add(id);
            duplicateCheck.add(id);
        }
    }
}
