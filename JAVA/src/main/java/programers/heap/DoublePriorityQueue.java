package programers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(new String[]{"I 16", "D 1"}), new int[]{0, 0}));
        System.out.println(Arrays.equals(solution.solution(new String[]{"I 7", "I 5", "I -5", "D -1"}), new int[]{7, 5}));
    }

    static class Solution {
        public int[] solution(String[] operations) {

            CustomPriorityQueue customPriorityQueue = new CustomPriorityQueue();

            for (String operation : operations) {
                customPriorityQueue.execute(operation);
            }

            return customPriorityQueue.getResult();
        }
    }

    static class ValueObject {
        private int value;

        public ValueObject(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int sortASC(ValueObject vo) {
            if (value > vo.value) {
                return 1;
            }
            return -1;
        }

        public int sortDESC(ValueObject vo) {
            if (value < vo.value) {
                return 1;
            }
            return -1;
        }
    }

    static class CustomPriorityQueue {
        private Queue<ValueObject> ascQueue = new PriorityQueue<>(ValueObject::sortASC);
        private Queue<ValueObject> descQueue = new PriorityQueue<>(ValueObject::sortDESC);

        public void execute(String input) {
            String[] cmd = input.split(" ");
            String op = cmd[0];
            int value = Integer.parseInt(cmd[1]);
            if ("I".equals(op)) {
                offer(value);
                return;
            }
            remove(value);
        }

        private void offer(int value) {
            ValueObject vo = new ValueObject(value);
            ascQueue.offer(vo);
            descQueue.offer(vo);
        }

        private void remove(int value) {
            if (value == 1) {
                //remove max
                ValueObject removeObject = descQueue.poll();
                ascQueue.remove(removeObject);
            } else {
                //remove min
                ValueObject removeObject = ascQueue.poll();
                descQueue.remove(removeObject);
            }
        }

        private boolean isEmpty() {
            return ascQueue.isEmpty();
        }

        public int[] getResult() {
            if (isEmpty()) {
                return new int[]{0, 0};
            }
            return new int[]{getMax(), getMin()};
        }

        private int getMax() {
            return descQueue.poll().getValue();
        }

        private int getMin() {
            return ascQueue.poll().getValue();
        }

    }
}
