package programers.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 우선순위 큐로 하려다가 틀렸다.
 * 결국 다른 사람의 답을 보고 풀었다.
 * comparator에 대해서 배웠다.
 */

public class BiggestNumber_R {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        String[] numberString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numberString, new MyNumber());

        String answer = String.join("", numberString);
        if (numberString[0].equals("0")) {
            answer = "0";
        }
    }

    static class MyNumber implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int combine1 = Integer.valueOf(o1 + o2);
            int combine2 = Integer.valueOf(o2 + o1);
            return combine2 - combine1;
        }
    }

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            return answer;
        }
    }


}
