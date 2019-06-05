package programers.bruteForce;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int brown = 16;
        int red = 9;
        int[] answer;

        //일렬로 깔고
        //일치하지 않으면 행을 늘려가자.
        int row = 1;
        int col = red / row;

        while (row <= col) {

            int maybeBrown = row * 2 + col * 2 + 4;

            if (maybeBrown == brown) {
                break;
            }

            for (int i = row + 1; i < red; i++) {
                if (red % i == 0) {
                    row = i;
                    break;
                }
            }
            col = red / row;
        }

        answer = new int[2];
        answer[0] = col + 2;
        answer[1] = row + 2;

        System.out.println(Arrays.toString(answer));

    }

    class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = {};
            return answer;
        }
    }
}
