package programers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelop {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = {};

        Queue<Integer> progressQueue = new LinkedList<>();
        for (int progress : progresses) {
            progressQueue.offer(progress);
        }

        List<Integer> answers = new LinkedList<>();
        int index = 0;
        int day = 1;

        while (!progressQueue.isEmpty()) {
            int count = 0;

            int addProgress = speeds[index] * day;
            while (progressQueue.peek() + addProgress >= 100) {
                count++;
                index++;
                progressQueue.poll();
                if (index == speeds.length) {
                    break;
                }
                addProgress = speeds[index] * day;
            }
            if (count != 0) {
                answers.add(count);
            }
            day++;
        }
        answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        System.out.println(Arrays.toString(answer));
    }

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            return answer;
        }
    }

}
