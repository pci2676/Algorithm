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


    private static final int[] lx = {-1, 0, 1, 0};
    private static final int[] ly = {0, -1, 0, 1};

    private static final int[] fx = {0, 1, 0, -1};
    private static final int[] fy = {-1, 0, 1, 0};

    private static final int[] bx = {0, -1, 0, 1};
    private static final int[] by = {1, 0, -1, 0};


    private static int[][] map;
    private static boolean[][] clean;

    private static int nowX;
    private static int nowY;
    private static int nowDirection;
    private static int turnCount = 0;

    private static int answer = 0;

    public static void main(String[] args) throws IOException {

        init();

        System.out.println("start\n");
        while (true) {
            System.out.println("now : " + nowX + " " + nowY);
            System.out.println("direction : " + nowDirection);
            System.out.println("count : " + turnCount);
            System.out.println("answer : " + answer);

            if (canMoveLeft() && isNotCleanLeft()) {    //1 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                System.out.println(1);
                turnLeft();
                forwardRobot();
                clearPosition();
            } else {    //2 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
                System.out.println(2);
                turnLeft();
            }

            if (checkAllDirectionClear()) {   //3 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                if (canNotBackward()) {    //4 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                    System.out.println(4);
                    break;
                }
                System.out.println(3);
                backwardRobot();
                clearBack();
            }
            System.out.println();
        }

        System.out.println("\nanswer");
        System.out.println(answer);
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nowX = Integer.parseInt(st.nextToken());
        nowY = Integer.parseInt(st.nextToken());
        nowDirection = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        clean = new boolean[m][n];
        clearPosition();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] == 1) {
                    clean[j][i] = true;
                }
            }
        }
    }

    private static boolean canMoveLeft() {
        int leftX = -1;
        int leftY = -1;

        for (int i = 0; i < 4; i++) {
            if (i == nowDirection) {
                leftX = nowX + lx[i];
                leftY = nowY + ly[i];
            }
        }

        System.out.println("left : " + leftX + " " + leftY);
        if (map[leftX][leftY] < 1) {
            System.out.println("can move to left : " + leftX + " " + leftY);
        } else {
            System.out.println("can not move to left : " + leftX + " " + leftY);
        }

        return map[leftX][leftY] < 1;
    }

    private static boolean isNotCleanLeft() {
        int leftX = -1;
        int leftY = -1;

        for (int i = 0; i < 4; i++) {
            if (i == nowDirection) {
                leftX = nowX + lx[i];
                leftY = nowY + ly[i];
            }
        }
        if (!clean[leftX][leftY]) {
            System.out.println("left is not clean");
        } else {
            System.out.println("left is clean");
        }

        return !clean[leftX][leftY];
    }

    private static void turnLeft() {
        turnCount++;
        switch (nowDirection) {
            case N:
                nowDirection = W;
                break;
            case E:
                nowDirection = N;
                break;
            case S:
                nowDirection = E;
                break;
            case W:
                nowDirection = S;
                break;
            default:
                throw new RuntimeException("Wrong Direction Exception!");
        }
    }

    private static void clearPosition() {
        turnCount = 0;
        if (!clean[nowX][nowY]) {
            answer++;
            clean[nowX][nowY] = true;
        }
    }

    private static void forwardRobot() {
        for (int i = 0; i < 4; i++) {
            if (i == nowDirection) {
                nowX = nowX + fx[i];
                nowY = nowY + fy[i];
            }
        }
    }

    private static boolean checkAllDirectionClear() {
        if (turnCount == 4) {
            turnCount = 0;
            return true;
        }
        return false;
    }

    private static boolean canNotBackward() {
        int backX = -1;
        int backY = -1;

        for (int i = 0; i < 4; i++) {
            if (i == nowDirection) {
                backX = nowX + bx[i];
                backY = nowY + by[i];
            }
        }
        return map[backX][backY] == 1;
    }

    private static void backwardRobot() {
        for (int i = 0; i < 4; i++) {
            if (i == nowDirection) {
                nowX = nowX + bx[i];
                nowY = nowY + by[i];
            }
        }
    }

    private static void clearBack() {
        if (!clean[nowX][nowY]) {
            clearPosition();
        }
    }


}
