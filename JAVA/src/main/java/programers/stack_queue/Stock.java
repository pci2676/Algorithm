package programers.stack_queue;

import java.util.Arrays;

public class Stock {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer;

        answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                if (price > prices[j] || j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = {};
            return answer;
        }
    }
}
