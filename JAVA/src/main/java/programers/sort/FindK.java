package programers.sort;

import java.util.Arrays;

/*
    간단한 정렬 문제인데 개삽질함 ㅠㅠ
    Arrays.sort 보다 더 빠른 성능을 보여준다.
 */

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
}

public class FindK {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answers = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answers[i] = getAnswer(array, commands[i]);
        }

        System.out.println(Arrays.toString(answers));
    }

    private static int getAnswer(int[] array, int[] command) {
        int i = command[0];
        int j = command[1];
        int k = command[2];

        int size = j - i + 1;
        int[] src = new int[size];

        int offset = i - 1;

        for (int post = 0; post < size; post++) {
            src[post] = array[offset + post];
            int pivot = post;
            for (int pre = pivot - 1; pre >= 0; pre--) {
                if (src[pre] > src[pivot]) {
                    int temp = src[pivot];
                    src[pivot] = src[pre];
                    src[pre] = temp;
                    pivot--;
                } else{
                    break;
                }
            }
        }

        return findAnswer(src, k);
    }


    private static int findAnswer(int[] src, int target) {
        return src[target - 1];
    }
}
