package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> printer = new LinkedList<>();
            Queue<Integer> priority = new PriorityQueue<>(BJ1966::compare);

            initPrinter(printer, priority, n);

            int answer = 0;

            if (printer.size() == 1) {
                System.out.println(1);
                continue;
            }

            while (true) {
                if (printer.peek().equals(priority.peek())) {
                    answer++;

                    printer.poll();
                    priority.poll();

                    if (m == 0) {
                        break;
                    }

                } else {
                    int temp = printer.poll();
                    printer.offer(temp);
                }

                m--;

                if (m < 0) {
                    m = printer.size() - 1;
                }
            }

            System.out.println(answer);
        }
    }

    private static void initPrinter(Queue<Integer> printer, Queue<Integer> priority, int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            printer.offer(number);
            priority.offer(number);
        }
    }

    private static int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
