package programers.greedy.makebignumber;

import java.util.Stack;

public class MakeBigNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("231156", 2));
        System.out.println(solution.solution("1111", 2));
    }


}

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char no = number.charAt(i);
            while (!stack.isEmpty() && no > stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(no);
        }

        while (stack.size() > number.length() - k) {
            stack.pop();
        }

        for (Character no : stack) {
            answer.append(no);
        }

        return answer.toString();
    }
}

/**
 * 2 3 1 1 5 6
 * 2
 * <p>
 * 3 1 5 6
 */
