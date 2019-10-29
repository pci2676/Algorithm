package programers.winter2018.cookie;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 2, 3}) == 3);
        System.out.println(solution.solution(new int[]{1, 2, 4, 5}) == 0);
        System.out.println(solution.solution(new int[]{1, 1}) == 1);
        System.out.println(solution.solution(new int[]{1, 0}) == 0);
        System.out.println(solution.solution(new int[]{3, 1, 4}) == 4);
    }

}

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;

        int length = cookie.length;

        for (int i = 0; i < length; i++) {
            int preIndex = i;
            int postIndex = i + 1;
            if (postIndex >= length) {
                continue;
            }

            int preSum = cookie[preIndex];
            int postSum = cookie[postIndex];


            while (true) {

                if (preSum == postSum) {
                    answer = Math.max(answer, preSum);
                }

                if (preSum <= postSum) {
                    preIndex--;
                    if (preIndex < 0) {
                        break;
                    }
                    preSum += cookie[preIndex];
                    continue;
                }

                if (postSum <= preSum) {
                    postIndex++;
                    if (postIndex >= length) {
                        break;
                    }
                    postSum += cookie[postIndex];
                }

            }

        }

        return answer;
    }
}
