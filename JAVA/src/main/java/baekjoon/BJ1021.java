package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ1021 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        Queue<String> targets = Arrays.stream(br.readLine().split(" "))
                .collect(Collectors.toCollection(LinkedList::new));

        int answer = 0;
        while (true) {
            if (targets.size() == 0) {
                break;
            }
            int target = Integer.parseInt(targets.poll());

            //왼쪽으로 가는 비용 구하기
            Result leftResult = getLeftCost(new LinkedList<>(deque), target);
            //오른쪽으로 가는 비용 구하기
            Result rightResult = getRightCost(new LinkedList<>(deque), target);

            if (leftResult.getCost() > rightResult.getCost()) {
                answer += rightResult.getCost();
                deque = rightResult.getDeque();
            } else {
                answer += leftResult.getCost();
                deque = leftResult.getDeque();
            }

        }

        System.out.println(answer);
    }

    private static Result getLeftCost(Deque<Integer> deque, int target) {
        int cost = 0;

        while (true) {
            if (deque.peekFirst() == target) {
                deque.pollFirst();
                return new Result(cost, deque);
            }
            int left = deque.pollFirst();
            deque.offerLast(left);
            cost++;
        }
    }

    private static Result getRightCost(Deque<Integer> deque, int target) {
        int cost = 0;

        while (true) {
            if (deque.peekFirst() == target) {
                deque.pollFirst();
                return new Result(cost, deque);
            }
            int right = deque.pollLast();
            deque.offerFirst(right);
            cost++;
        }
    }

    static class Result {
        private int cost;
        private Deque<Integer> deque;

        public Result(int cost, Deque<Integer> deque) {
            this.cost = cost;
            this.deque = deque;
        }

        public int getCost() {
            return cost;
        }

        public Deque<Integer> getDeque() {
            return deque;
        }
    }
}
