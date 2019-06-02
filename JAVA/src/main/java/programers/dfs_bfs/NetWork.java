package programers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 간단한 BFS 문제였는데 BFS 구현방법을 까먹어서 시간을 많이 잡아먹었다..
 */

public class NetWork {

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visit;

    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};

        visit = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }

            answer++;

            bfs(computers, i);
        }

        System.out.println(answer);
    }

    private static void bfs(int[][] computers, int now) {

        if (visit[now]) {
            System.out.println("visited " + now);
            return;
        }

        visit[now] = true;

        for (int j = 0; j < computers[now].length; j++) {
            if (computers[now][j] == 1 && (now != j)) {
                queue.add(j);
            }
        }
        while(!queue.isEmpty()){
            bfs(computers,queue.poll());
        }
    }
}
