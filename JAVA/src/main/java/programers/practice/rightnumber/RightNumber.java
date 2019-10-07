package programers.practice.rightnumber;

import java.util.Stack;

public class RightNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("()())"));
        System.out.println(solution.solution(")()()"));
    }

}

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char some = s.charAt(i);
            if (some == '(') {
                stack.push(some);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
