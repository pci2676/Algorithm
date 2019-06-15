package programers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tower {
    public static void main(String[] args) {
        int[] heights = {3, 9, 9, 3, 5, 7, 2};
        int[] answer = {};

        List<Integer> accept = new LinkedList<>();
        accept.add(0);

        for (int i = 1; i < heights.length; i++) {
            int now = heights[i];
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                int left = heights[j];
                if (left > now) {
                    flag = true;
                    accept.add(j + 1);
                    break;
                }
            }
            if (!flag) {
                accept.add(0);
            }
        }

        answer = new int[accept.size()];
        for (int i = 0; i < accept.size(); i++) {
            answer[i] = accept.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    class Solution {
        public int[] solution(int[] heights) {
            int[] answer = {};
            return answer;
        }
    }
}
