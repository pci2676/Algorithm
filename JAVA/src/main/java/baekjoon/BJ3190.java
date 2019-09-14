package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3190 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int N = 0;
    private static final int E = 1;
    private static final int S = 2;
    private static final int W = 3;

    private static int[][] board;

    public static void main(String[] args) throws Exception {

        // 첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)
        // 다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n + 2][n + 2];

        for (int y = 0; y < n + 2; y++) {
            for (int x = 0; x < n + 2; x++) {
                if (x == 0) {
                    board[x][y] = 1;
                }
                if (x == n + 1) {
                    board[x][y] = 1;
                }
                if (y == 0) {
                    board[x][y] = 1;
                }
                if (y == n + 1) {
                    board[x][y] = 1;
                }
            }
        }

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[x][y] = 3;
        }

        // 다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)
        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> timeMap = new HashMap<>();

        // 다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데,  정수 X와 문자 C로 이루어져 있으며.
        // 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다.
        // X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            timeMap.put(time, direction);
        }

        //1,1 오른쪽 시작
        Snake snake = new Snake(E, 1, 1);

        int time = 0;

        while (true) {
            time++;

            Coordinate nextStep = snake.getNextStep();

            if (!nextStep.canMove(n + 1)) {
                break;
            }
            if (snake.isHitSelf(nextStep)) {
                break;
            }

            snake.move(nextStep);


            snake.shrink();

            if (timeMap.containsKey(time)) {
                String direction = timeMap.get(time);
                snake.changeDirection(direction);
            }
        }

        System.out.println(time);
    }

    static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canMove(int range) {
            return !(x == 0 || x == range || y == 0 || y == range);
        }
    }

    static class Snake {
        private static int[] dx = {0, 1, 0, -1};
        private static int[] dy = {-1, 0, 1, 0};
        Queue<Coordinate> tails = new LinkedList<>();
        private int direction;
        private int length = 1;
        private int x;
        private int y;

        public Snake(int direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
            this.tails.offer(new Coordinate(1, 1));
            board[x][y] = 2;
        }

        public void changeDirection(String turn) {
            if (turn.equals("L")) {
                this.direction = (this.direction + 3) % 4;
            } else {
                this.direction = (this.direction + 1) % 4;
            }
        }

        public Coordinate getNextStep() {
            int x = this.x + dx[this.direction];
            int y = this.y + dy[this.direction];
            return new Coordinate(x, y);
        }

        public void move(Coordinate nextStep) {
            if (board[nextStep.x][nextStep.y] == 3) {
                this.eatApple();
            }
            this.x = nextStep.x;
            this.y = nextStep.y;
            this.tails.offer(nextStep);
            board[x][y] = 2;
        }

        public void eatApple() {
            this.length++;
        }

        public boolean isHitSelf(Coordinate nextStep) {
            int x = nextStep.x;
            int y = nextStep.y;
            return board[x][y] == 2;
        }

        public void shrink() {
            if (tails.size() > length) {
                Coordinate coordinate = tails.poll();
                board[coordinate.x][coordinate.y] = 0;
            }
        }
    }

}
