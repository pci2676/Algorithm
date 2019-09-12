package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int N = 0;
    private static final int E = 1;
    private static final int S = 2;
    private static final int W = 3;

    private static final int[] fx = {0, 1, 0, -1};
    private static final int[] fy = {-1, 0, 1, 0};

    private static int[][] map;
    private static boolean[][] visit;

    private static int nowX;
    private static int nowY;
    private static int nowDirection;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        init();

        int x = nowX;
        int y = nowY;
        int direction = nowDirection;

        bfs(x, y, direction);

        System.out.println(answer);
    }

    //왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
    //왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
    //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
    //네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
    private static void bfs(int x, int y, int direction) {
        int turnCount = 0;

        if (!visit[x][y]) {
            visit[x][y] = true;
            answer++;
        }

        for (int i = 0; i < 4; i++) {

            int nextDirection = turnLeft(direction);
            int nextX = x + fx[nextDirection];
            int nextY = y + fy[nextDirection];

            if (map[nextX][nextY] < 1 && !visit[nextX][nextY]) {
                bfs(nextX, nextY, nextDirection);
                return;
            } else {
                turnCount++;
                direction = nextDirection;

                if (turnCount == 4) {
                    int backX = x - fx[direction];
                    int backY = y - fy[direction];
                    if (map[backX][backY] < 1) {
                        bfs(backX, backY, direction);
                    }
                    return;
                }
            }

        }

    }

    private static int forwardY(int y, int direction) {
        return y + fy[direction];
    }

    private static int forwardX(int x, int direction) {
        return x + fx[direction];
    }

    private static int turnLeft(int direction) {
        switch (direction) {
            case N:
                return W;
            case E:
                return N;
            case S:
                return E;
            case W:
                return S;
            default:
                throw new RuntimeException("Wrong direction!");
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nowY = Integer.parseInt(st.nextToken());
        nowX = Integer.parseInt(st.nextToken());
        nowDirection = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] == 1) {
                    visit[j][i] = true;
                }
            }
        }
    }

}
