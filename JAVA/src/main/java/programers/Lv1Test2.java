package programers;

public class Lv1Test2 {

    public static void main(String[] args) {
        int[][] answer;
        int[][] arr1 = {{1, 2, 3}, {1, 2, 3}};
        int[][] arr2 = {{1, 2, 3}, {0, 0, 0}};

        int row = arr1.length;
        int col = arr1[0].length;
        answer = new int[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                answer[j][i] = arr1[j][i] + arr2[j][i];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.println(answer[j][i]);
            }
        }
    }
}
