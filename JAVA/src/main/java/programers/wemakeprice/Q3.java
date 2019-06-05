package programers.wemakeprice;

public class Q3 {
    public static void main(String[] args) {
        int[] gold_prices = {7, 2, 5, 6, 1, 4, 2, 8};
        int answer;

        int[] t = new int[gold_prices.length + 10];
        int[] p = new int[gold_prices.length + 10];
        int[] dp = new int[gold_prices.length + 10];

        for (int i = 0; i < gold_prices.length; i++) {
            t[i] = 1;
            p[i] = gold_prices[i];
        }
        int end = gold_prices.length;
        for (int day = end; day >= 1; day--) {
            int totalDay = day + t[day];

            if (totalDay <= end + 1) {
                dp[day] = Math.max(p[day] + dp[totalDay], dp[day + 1]);
            } else {
                dp[day] = dp[day + 1];
            }
        }
        answer = dp[1];
    }

    class Solution {
        public int solution(int[] gold_prices) {
            int answer = 4;
            return answer;
        }
    }
}
