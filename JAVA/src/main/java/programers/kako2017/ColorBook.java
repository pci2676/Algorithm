package programers.kako2017;

import java.util.Arrays;

public class ColorBook {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution.solution(m, n, picture)));
    }

    static class Solution {

        private static int[] dx = {0, 1, 0, -1};
        private static int[] dy = {-1, 0, 1, 0};
        private static boolean[][] isVisit;


        public int[] solution(int m, int n, int[][] picture) {
            isVisit = new boolean[m][n];
            Answer answerVO = new Answer();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (picture[i][j] == 0 || isVisit[i][j]) {
                        continue;
                    }
                    answerVO.initSize();
                    int targetColor = picture[i][j];
                    dfs(picture, answerVO, targetColor, m, n, j, i);
                    answerVO.addNumberOfArea();
                    answerVO.changeMaxSizeOfOneArea();

                }
            }

            int[] answer = new int[2];
            answer[0] = answerVO.getNumberOfArea();
            answer[1] = answerVO.getMaxSizeOfOneArea();
            return answer;
        }

        private void dfs(int[][] picture, Answer answerVO, int targetColor, int m, int n, int x, int y) {

            if (x < 0 || x >= n || y < 0 || y >= m) {
                return;
            }

            if (picture[y][x] == 0 || isVisit[y][x]) {
                return;
            }

            if (picture[y][x] != targetColor) {
                return;
            }

            answerVO.addSize();
            isVisit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                dfs(picture, answerVO, targetColor, m, n, x + dx[i], y + dy[i]);
            }

        }

    }

    static class Answer {
        private int numberOfArea = 0;
        private int maxSizeOfOneArea = 0;
        private int size = 0;

        public int getNumberOfArea() {
            return numberOfArea;
        }

        public int getMaxSizeOfOneArea() {
            return maxSizeOfOneArea;
        }

        public void addNumberOfArea() {
            this.numberOfArea++;
        }

        public void addSize() {
            this.size++;
        }

        public void initSize() {
            this.size = 0;
        }

        public void changeMaxSizeOfOneArea() {
            if (size > maxSizeOfOneArea) {
                maxSizeOfOneArea = size;
            }
        }
    }

}
