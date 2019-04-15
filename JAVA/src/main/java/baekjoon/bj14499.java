//package baekjoon;
//
//import java.util.Scanner;
//
//public class bj14499 {
//    private static Scanner sc = new Scanner(System.in);
//
//    private static int[] dice = new int[7];
//
//    private static int n; //세로
//    private static int m; //가로
//    private static int x; //주사위 x
//    private static int y; //주사위 y
//    private static int k; //시도횟수
//
//    private static int[][] map = new int[100][100];
//    private static int[] dx = {1, -1, 0, 0};//0동서북남
//    private static int[] dy = {0, 0, -1, 1};
//
//    public static void main(String[] args) {
//
//        init();
//        initMap();
//        getAnswer();
//
//    }
//
//    private static void getAnswer() {
//
//        for (int i = 0; i < k; i++) {
//            int direction = sc.nextInt();
//
//            //이동한곳의 좌표
//            int moved_x = x + dx[direction - 1];
//            int moved_y = y + dy[direction - 1];
//
//            if (!isIn(moved_x, moved_y)) {
//                continue;
//            }
//
//            //주사위 이동
//            moveDice(direction);
//
//            //이동한곳이 0인지 확인
//            if (map[moved_y][moved_x] == 0) {
//                //주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다
//                map[moved_y][moved_x] = dice[6];
//            } else {
//                //0이 아니면
//                //칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
//                dice[6] = map[moved_y][moved_x];
//                map[moved_y][moved_x] = 0;
//            }
//
//            x = moved_x;
//            y = moved_y;
//
//            System.out.println(dice[1]);
//        }
//
//    }
//
//    private static void moveDice(int direction) {
//        //동서북남 순으로
//        int[] temp = dice.clone();
//        switch (direction) {
//            case 1:
//                //동-북남 고정
//                // 위->동
//                dice[1] = temp[4];
//                dice[3] = temp[1];
//                dice[4] = temp[6];
//                dice[6] = temp[3];
//                break;
//            case 2:
//                //서-북남고정
//                dice[1] = temp[3];
//                dice[3] = temp[6];
//                dice[4] = temp[1];
//                dice[6] = temp[4];
//                break;
//            case 3:
//                //북-동서고정
//                dice[1] = temp[5];
//                dice[2] = temp[1];
//                dice[5] = temp[6];
//                dice[6] = temp[2];
//                break;
//            case 4:
//                //남-동서고정
//                dice[1] = temp[2];
//                dice[2] = temp[6];
//                dice[5] = temp[1];
//                dice[6] = temp[5];
//                break;
//        }
//    }
//
//    //지도밖으로 나가는지 확인
//    private static boolean isIn(int moved_x, int moved_y) {
//        return (moved_x >= 0 && moved_y >= 0 && moved_x < m && moved_y < n);
//    }
//
//    private static void initMap() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//    }
//
//    private static void init() {
//        n = sc.nextInt(); //세로
//        m = sc.nextInt(); //가로
//        y = sc.nextInt(); //주사위 y
//        x = sc.nextInt(); //주사위 x
//        k = sc.nextInt();
//    }
//}
