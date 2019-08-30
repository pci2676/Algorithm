package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1463_3 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[n + 1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            Integer minByOne = dp[i - 1];
            Integer divideMin = Divide.getMin(dp, i);

            dp[i] = getMin(minByOne, divideMin) + 1;
        }

        System.out.println(dp[n]);
    }

    private static Integer getMin(Integer min1, Integer min2) {
        if (min1 > min2) {
            return min2;
        }
        return min1;
    }

    enum Divide {
        THREE(3),
        TWO(2);

        private Integer divideValue;

        Divide(Integer divideValue) {
            this.divideValue = divideValue;
        }

        public static Integer getMin(Integer[] dp, int target) {
            return Arrays.stream(values())
                    .filter(divideEnum -> divideEnum.canDivide(target))
                    .map(divideEnum -> divideEnum.execute(target))
                    .map(before -> dp[before])
                    .min(Integer::compareTo)
                    .orElse(9999999);
        }

        private boolean canDivide(Integer target) {
            return target % this.divideValue == 0;
        }

        private Integer execute(Integer target) {
            return target / this.divideValue;
        }

    }

}