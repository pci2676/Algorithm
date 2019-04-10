//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//
//public class bj1931 {
//
//    static class Room implements Comparable<Room> {
//        int id;
//        int start;
//        int end;
//
//        public Room(int id, String start, String end) {
//            this.id = id;
//            this.start = Integer.valueOf(start);
//            this.end = Integer.valueOf(end);
//        }
//
//        @Override
//        public int compareTo(Room room) {
//            if (this.end > room.end) {
//                return 1;
//            } else if (this.end < room.end) {
//                return -1;
//            } else {
//                if (this.start > room.start) {
//                    return 1;
//                } else if (this.start < room.start) {
//                    return -1;
//                }
//                return 0;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.valueOf(br.readLine());
//
//        PriorityQueue<Room> priorityQueue = new PriorityQueue();
//        for (int t = 0; t < n; t++) {
//            String line = br.readLine();
//            String arr[] = line.split(" ");
//            priorityQueue.offer(new Room(t, arr[0], arr[1]));
//        }
//
//        int count = 1;
//        Room room = priorityQueue.poll();
//        while (!priorityQueue.isEmpty()) {
//            if (room.end <= priorityQueue.peek().start) {
//                count++;
//                room = priorityQueue.poll();
//            } else {
//                priorityQueue.poll();
//            }
//        }
//
//        System.out.println(count);
//    }
//}
