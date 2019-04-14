//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//
//public class bj2750 {
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws Exception {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
//
//        int n = Integer.valueOf(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int number = Integer.valueOf(br.readLine());
//            priorityQueue.add(number);
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(priorityQueue.poll());
//        }
//    }
//}
