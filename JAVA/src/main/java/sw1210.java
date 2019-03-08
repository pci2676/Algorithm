//import java.util.Scanner;
//
//public class sw1210 {
//
//    static int map[][];
//    static int startingPoint = 0;
//    final static int[] dx = {-1, 1};
//
//    public static void main(String args[]) {
//
//        Scanner scanner = new Scanner(System.in);
//        int answer[] = new int[10];
//
//        for (int t = 0; t < 10; t++) {
//            scanner.nextInt();
////            System.out.println("testNumber: "+t);
//            //테스트케이스 입력
//            map = new int[102][100];
//            for (int i = 0; i < 100; i++) {
//                map[0][i] = 0;
//                map[101][i] = 0;
//            }
//            for (int i = 0; i < 100; i++) {
//                for (int j = 1; j < 101; j++) {
//                    map[j][i] = scanner.nextInt();
//                }
//            }
//
//            //사다리 타는 로직
//            int dest = getDest();
//            move(dest, 98, 3);
//            //정답을 저장하는 로직
//            answer[t] = startingPoint;
////            System.out.println("T : " + t + " dest: " + dest + " start: " + answer[t]);
//        }
//
//        //정답을 출력하는 부분
//        for (int i = 0; i < 10; i++)
//            System.out.println("#" + (i + 1) + " " + answer[i]);
//    }
//
//
//    //도착지점 찾기
//    private static int getDest() {
//        for (int i = 1; i < 101; i++) {
//            if (map[i][99] == 2) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private static void move(int col, int row, int flag) {
//
////        System.out.println("x :"+col+" y: "+row);
//
//        if (row == 0) {
//            startingPoint = col - 1;
//            return;
//        }
//        //수평이동중이었다면
//        if (flag == 0 || flag == 1) {
//            int x = col + dx[flag];
//            if (map[x][row] == 1) {
//                move(x, row, flag);
//                return;
//            }
//        } else { //수직이동중이었다면
//            for (int i = 0; i < 2; i++) {
//                int x = col + dx[i];
//                if (map[x][row] == 1) {
//                    move(x, row, i);
//                    return;
//                }
//            }
//        }
//        move(col, row - 1, 3);
//        return;
//    }
//
//}
