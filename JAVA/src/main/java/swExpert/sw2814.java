package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sw2814 {

    static class Node {
        int idx;

        boolean isVisit = false;

        List<Integer> conList = new ArrayList<>();

        Node(int idx) {
            this.idx = idx;
        }

    }

    static Node[] graph;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.valueOf(br.readLine());

        for (int t = 1; t <= test; t++) {
            String line = br.readLine();
            int[] arr = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int n = arr[0];
            int m = arr[1];

            graph = new Node[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                line = br.readLine();
                arr = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                int idx = arr[0];
                int conn = arr[1];

                graph[idx].conList.add(conn);
                graph[conn].conList.add(idx);
            }

            answer = 1;
            if (m != 0) {
                for (int i = 1; i <= n; i++) {
                    dfs(graph[i], 1);
                }
            }

            System.out.println(String.format("#%d %d", t, answer));
        }
    }

    private static void dfs(Node node, int length) {
        if (!node.isVisit) {
            if (answer < length) {
                answer = length;
            }
            node.isVisit = true;

            for (int idx : node.conList) {
                dfs(graph[idx], length + 1);
            }
            node.isVisit = false;
        }
    }
}
