package self;

import java.util.Arrays;

public class Typhoon {

    public static void main(String[] args) {
//        threeByThree();
//        fourByFour();
//        rightSingleTurn();
        doubleTurn();
    }

    private static void doubleTurn() {
        int[][] pairTyphoon = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        boolean right = true;
        boolean left = false;
        print(pairTyphoon);
        System.out.println();
        print(doubleSingleTurn(pairTyphoon, right));
        System.out.println();
        print(doubleSingleTurn(pairTyphoon, left));
        System.out.println();
        System.out.println("===========================");
    }


    private static void threeByThree() {
        int[][] typhoon = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(typhoon);
        System.out.println();
        print(right(typhoon));
        System.out.println();
        print(left(typhoon));
        System.out.println();
        System.out.println("===========================");
    }

    private static void fourByFour() {

        int[][] pairTyphoon = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(pairTyphoon);
        System.out.println();
        print(right(pairTyphoon));
        System.out.println();
        print(left(pairTyphoon));
        System.out.println();
        System.out.println("===========================");
    }

    public static int[][] doubleSingleTurn(int[][] typhoon, boolean right) {
        int size = typhoon.length;
        for (int i = 0; i < size / 2; i++) {
            int fx = i;
            int fy = i;
            int ex = size - 1 - i;
            int ey = size - 1 - i;

            int temp = typhoon[fy][fx];

            if (right) {
                right = !right;
                for (int n = fy + 1; n <= ey; n++) {
                    typhoon[n - 1][fx] = typhoon[n][fx];
                }
                for (int n = fx + 1; n <= ex; n++) {
                    typhoon[ey][n - 1] = typhoon[ey][n];
                }
                for (int n = ey; n > fy; n--) {
                    typhoon[n][ex] = typhoon[n - 1][ex];
                }
                for (int n = ex; n > fx; n--) {
                    typhoon[fy][n] = typhoon[fy][n - 1];
                }
                typhoon[fy][fx + 1] = temp;
            } else {
                right = !right;
                for (int n = fx + 1; n <= ex; n++) {
                    typhoon[fy][n - 1] = typhoon[fy][n];
                }
                for (int n = fy + 1; n <= ey; n++) {
                    typhoon[n - 1][ex] = typhoon[n][ex];
                }
                for (int n = ex; n > fx; n--) {
                    typhoon[ey][n] = typhoon[ey][n - 1];
                }
                for (int n = ey; n > fy; n--) {
                    typhoon[n][fx] = typhoon[n - 1][fx];
                }

                typhoon[fy + 1][fx] = temp;
            }

        }
        return typhoon;
    }

    public static int[][] rightSingleTurn(int[][] typhoon) {
        int size = typhoon.length;

        for (int i = 0; i < size / 2; i++) {
            int fx = i;
            int fy = i;
            int ex = size - 1 - i;
            int ey = size - 1 - i;

            int temp = typhoon[fy][fx];

            for (int n = fy + 1; n <= ey; n++) {
                typhoon[n - 1][fx] = typhoon[n][fx];
            }
            for (int n = fx + 1; n <= ex; n++) {
                typhoon[ey][n - 1] = typhoon[ey][n];
            }
            for (int n = ey; n > fy; n--) {
                typhoon[n][ex] = typhoon[n - 1][ex];
            }
            for (int n = ex; n > fx; n--) {
                typhoon[fy][n] = typhoon[fy][n - 1];
            }
            typhoon[fy][fx + 1] = temp;
        }

        return typhoon;
    }

    public static int[][] leftSingleTurn(int[][] typhoon) {
        int size = typhoon.length;

        for (int i = 0; i < size / 2; i++) {
            int fx = i;
            int fy = i;
            int ex = size - 1 - i;
            int ey = size - 1 - i;

            int temp = typhoon[fy][fx];

            for (int n = fx + 1; n <= ex; n++) {
                typhoon[fy][n - 1] = typhoon[fy][n];
            }
            for (int n = fy + 1; n <= ey; n++) {
                typhoon[n - 1][ex] = typhoon[n][ex];
            }
            for (int n = ex; n > fx; n--) {
                typhoon[ey][n] = typhoon[ey][n - 1];
            }
            for (int n = ey; n > fy; n--) {
                typhoon[n][fx] = typhoon[n - 1][fx];
            }

            typhoon[fy + 1][fx] = temp;
        }

        return typhoon;
    }

    private static void rightSingleTurn() {
        int[][] oddTyphoon = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] pairTyphoon = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(oddTyphoon);
        System.out.println();
//        print(rightSingleTurn(oddTyphoon));
        print(leftSingleTurn(oddTyphoon));
        System.out.println();
        System.out.println("===========================");
    }

    private static void print(int[][] typhoon) {
        for (int i = 0; i < typhoon.length; i++) {
            System.out.println(Arrays.toString(typhoon[i]));
        }
    }

    public static int[][] right(int[][] typhoon) {
        int size = typhoon.length;
        int[][] newTyphoon = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                newTyphoon[y][x] = typhoon[size - 1 - x][y];
            }
        }
        return newTyphoon;
    }

    public static int[][] left(int[][] typhoon) {
        int size = typhoon.length;
        int[][] newTyphoon = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                newTyphoon[y][x] = typhoon[x][size - 1 - y];
            }
        }
        return newTyphoon;
    }

}
