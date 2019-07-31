package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class sw1238 {

    static Node[] node;
    static HashSet<Integer> set;
    static Queue<Integer> queue;
    static int maxDistance;
    static int answerIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            String line = br.readLine();
            String secondLine = br.readLine();
            String[] lineArr = line.split(" ");
            String[] secondLineArr = secondLine.split(" ");

            int startIdx = Integer.parseInt(lineArr[1]);
            int loop = Integer.parseInt(lineArr[0]);

            queue = new LinkedList<>();
            node = new Node[101];
            set = new HashSet<>();
            maxDistance = 0;
            answerIdx = 0;

            for (int i = 0; i < loop; i = i + 2) {
                int idx = Integer.parseInt(secondLineArr[i]);
                int otherIdx = Integer.parseInt(secondLineArr[i + 1]);

                if (set.contains(idx)) {
                    node[idx].lines.add(otherIdx);
                } else {
                    node[idx] = new Node(idx, otherIdx);
                }

                if (!set.contains(otherIdx)) {
                    node[otherIdx] = new Node(otherIdx);
                }
                set.add(idx);
                set.add(otherIdx);
            }

            queue.offer(startIdx);
            bfs();
            findIdx();

            System.out.println("#" + t + " " + answerIdx);
        }
    }

    private static void findIdx() {
        for (int idx : set) {
            if (node[idx].distance == maxDistance) {
                if (answerIdx < idx) {
                    answerIdx = idx;
                }
            }
        }
    }

    private static void bfs() {
        int length;

        while (!queue.isEmpty()) {

            int idx = queue.poll();
            if (node[idx].isVisit) {
                continue;
            }
            length = node[idx].distance;

            node[idx].isVisit = true;
            node[idx].distance = length;

            if (node[idx].distance > maxDistance) {
                maxDistance = node[idx].distance;
                answerIdx = idx;
            }

            length++;
            for (int connectedNodeIdx : node[idx].lines) {
                queue.offer(connectedNodeIdx);
                if (!node[connectedNodeIdx].isVisit)
                    node[connectedNodeIdx].distance = length;
            }

        }
    }

    static class Node {
        int idx;
        int distance = 0;
        boolean isVisit = false;
        HashSet<Integer> lines = new HashSet<>();

        public Node(int idx, int other) {
            this.idx = idx;
            lines.add(other);
        }

        public Node(int idx) {
            this.idx = idx;
        }
    }


}
