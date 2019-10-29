package programers.practice.bigRectangle;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[][]{
                {0, 0, 0, 1}
        }) == 1);

        System.out.println(solution.solution(new int[][]{
                {0, 0, 0, 0}
        }) == 0);

        System.out.println(solution.solution(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 1, 1}}) == 4);

        System.out.println(solution.solution(new int[][]{
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 1, 1, 0}}) == 9);

        System.out.println(solution.solution(new int[][]{
                {0, 0, 0},
                {0, 0, 1}}) == 1);

        System.out.println(solution.solution(new int[][]{
                {1, 0, 0},
                {0, 0, 0}}) == 1);

        System.out.println(solution.solution(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}}) == 9);

        System.out.println(solution.solution(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}}) == 9);

        System.out.println(solution.solution(new int[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}}) == 9);

        System.out.println(solution.solution(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}}) == 9);
    }
}

class Solution {


    public int solution(int[][] board) {
        int answer = 0;
        int yRange = board.length;
        int xRange = board[0].length;

        for (int y = 0; y < yRange; y++) {

            for (int x = 0; x < xRange; x++) {

                answer = changeMax(board[y][x], answer);

                if (x - 1 < 0 || y - 1 < 0) {
                    continue;
                }

                if (board[y][x] == 0) {
                    continue;
                }

                int up = board[y - 1][x];
                int left = board[y][x - 1];
                int upLeft = board[y - 1][x - 1];

                if (up == 0 || left == 0 || upLeft == 0) {
                    continue;
                }

                board[y][x] = Math.min(Math.min(up, left), upLeft) + 1;

                answer = changeMax(board[y][x], answer);
            }
        }
        return answer * answer;
    }

    private int changeMax(int candidate, int max) {
        return Math.max(candidate, max);
    }

}