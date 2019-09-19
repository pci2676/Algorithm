package codility;

import java.util.Arrays;

public class BinaryGap {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15));
    }

    static class Solution {
        public int solution(int N) {

            String binary = getBinary(N);
            if (!binary.contains("0")) {
                return 0;
            }
            System.out.println(binary);
            System.out.println(Arrays.toString(binary.split("1")));
            String[] gaps = binary.split("1");
            int length = gaps.length;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length - 1; i++) {
                if (gaps[i].length() > max) {
                    max = gaps[i].length();
                }
            }
            if (binary.endsWith("1")) {
                int last = gaps[length - 1].length();
                if (last > max) {
                    max = last;
                }
            }

            return max;
        }

        private String getBinary(int n) {
            StringBuilder binary = new StringBuilder();

            bin(binary, n);

            return binary.toString();
        }

        private void bin(StringBuilder binary, int n) {
            if (n / 2 > 0) {
                bin(binary, n / 2);
            }
            binary.append(n % 2);
        }
    }

}
