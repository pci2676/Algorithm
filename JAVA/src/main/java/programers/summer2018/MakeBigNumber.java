package programers.summer2018;

public class MakeBigNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer1 = solution.solution("1924", 2);
        System.out.println(answer1);

        String answer2 = solution.solution("1231234", 3);
        System.out.println(answer2);

        String answer3 = solution.solution("4177252841", 4);
        System.out.println(answer3);
    }

    static class Solution {
        public String solution(String number, int k) {
            String answer = "";

            String[] arr = number.split("");


            return answer;
        }
    }
}
