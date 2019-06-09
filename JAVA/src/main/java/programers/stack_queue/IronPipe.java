package programers.stack_queue;

import java.util.Stack;


/**
 *  Stack을 쓰는 기본적인 문제이다.
 *  규칙을 찾아서 그에 해당하는 값을 더해주면 되는 문제였다.
 */
public class IronPipe {
    class Solution {
        public int solution(String arrangement) {
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        Character before = null;

        for (int i = 0; i < arrangement.length(); i++) {
            Character now = arrangement.charAt(i);

            if (now == ')') {
                stack.pop();
                if (before == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            } else {
                stack.push(now);
            }

            before = now;
        }

        System.out.println(answer);
    }
}
