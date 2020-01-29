package kakao2018.secretmap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}), new String[]{"#####", "# # #", "### #", "#  ##", "#####"}));
        System.out.println(Arrays.equals(solution.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}), new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}));
    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //OR 연산
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = arr1[i] | arr2[i];
        }
        //2진수 변환
        for (int i = 0; i < n; i++) {
            //스트링 변환
            answer[i] = BinaryConverter.convert(new StringBuilder(), map[i]);
            //부족한 앞부분 채우기
            answer[i] = BinaryConverter.add(n, answer[i]);
        }
        return answer;
    }
}

class BinaryConverter {
    private static final String BLOCK = "#";
    private static final String BLANK = " ";

    public static String convert(StringBuilder answer, int number) {
        if (number / 2 >= 1) {
            convert(answer, number / 2);
        }
        answer.append(in(number % 2));
        return answer.toString();
    }

    private static String in(int number) {
        if (number == 0) {
            return BLANK;
        }
        return BLOCK;
    }

    public static String add(int n, String answer) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - answer.length(); i++) {
            stringBuilder.append(BLANK);
        }
        stringBuilder.append(answer);
        return stringBuilder.toString();
    }
}