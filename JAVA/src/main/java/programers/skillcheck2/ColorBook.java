package programers.skillcheck2;

import java.util.Arrays;

public class ColorBook {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}), new int[]{4, 5}));
    }

    static class Solution {

        private static final int BLANK = 0;
        private static final int[] dx = {0, 1, 0, -1};
        private static final int[] dy = {1, 0, -1, 0};
        private static int rowRange;
        private static int colRange;


        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            rowRange = m;
            colRange = n;

            Board board = new Board(m, n, picture);

            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    int targetColor = picture[y][x];
                    if (board.isVisit(x, y) || board.getColor(x, y) == BLANK) {
                        continue;
                    }
                    numberOfArea++;
                    board.initSize();
                    dfs(x, y, board, targetColor);
                }
            }
            maxSizeOfOneArea = board.getMaxSize();

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        private void dfs(int x, int y, Board board, int targetColor) {
            if (board.getColor(x, y) == BLANK) {
                return;
            }
            if (board.isVisit(x, y)) {
                return;
            }
            if (board.getColor(x, y) != targetColor) {
                return;
            }

            board.visit(x, y);
            board.changeMax();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                if (nextX < 0 || nextY < 0 || nextX >= colRange || nextY >= rowRange) {
                    continue;
                }
                dfs(nextX, nextY, board, targetColor);
            }

        }
    }

    static class Board {
        private int[][] picture;
        private boolean[][] visit;
        private int maxSize = 0;
        private int temp = 0;

        public Board(int m, int n, int[][] picture) {
            this.picture = picture;
            this.visit = new boolean[m][n];
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getColor(int x, int y) {
            return picture[y][x];
        }

        public boolean isVisit(int x, int y) {
            return visit[y][x];
        }

        public void visit(int x, int y) {
            this.visit[y][x] = true;
        }

        public void initSize() {
            this.temp = 0;
        }


        public void changeMax() {
            temp++;
            if (temp > maxSize) {
                maxSize = temp;
            }
        }
    }

}
