package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ14888 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<String> numbers = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            numbers.offer(st.nextToken());
        }

        List<String> ops = new ArrayList<>();
        initOps(ops);

        calculateCombination(ops);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String each : set) {
            Queue<String> eachQueue = Arrays.stream(each.split(""))
                    .collect(Collectors.toCollection(LinkedList::new));
            int sum = getSum(new LinkedList<>(numbers), eachQueue);
            if (sum > max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculateCombination(List<String> ops) {

        for (int i = 0; i < n - 1; i++) {
            String result = ops.get(i);
            List<String> nextOps = new ArrayList<>(ops);
            nextOps.remove(i);
            dfs(result, new ArrayList<>(nextOps));
        }

    }

    private static void dfs(String result, List<String> ops) {
        if (result.length() == n - 1) {
            set.add(result);
            return;
        }

        for (int i = 0; i < ops.size(); i++) {
            List<String> nextOps = new ArrayList<>(ops);
            String nextResult = result + nextOps.get(i);
            nextOps.remove(i);
            dfs(nextResult, new ArrayList<>(nextOps));
        }

    }


    private static void initOps(List<String> ops) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multi = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        for (int i = 0; i < plus; i++) {
            ops.add("+");
        }
        for (int i = 0; i < minus; i++) {
            ops.add("-");
        }
        for (int i = 0; i < multi; i++) {
            ops.add("*");
        }
        for (int i = 0; i < mod; i++) {
            ops.add("%");
        }
    }

    private static int getSum(Queue<String> numbers, Queue<String> ops) {

        int sum = Integer.parseInt(numbers.poll());

        while (!numbers.isEmpty()) {
            String op = ops.poll();
            int next = Integer.parseInt(numbers.poll());

            switch (op) {
                case "+":
                    sum += next;
                    break;
                case "-":
                    sum -= next;
                    break;
                case "*":
                    sum *= next;
                    break;
                case "%":
                    sum /= next;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return sum;
    }

}
