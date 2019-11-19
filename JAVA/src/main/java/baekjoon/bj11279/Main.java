package baekjoon.bj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < count; i++) {
            long input = Long.parseLong(br.readLine());
            if (input == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(priorityQueue.poll());
                continue;
            }
            priorityQueue.offer(input);
        }
    }
}
