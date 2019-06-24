package programers.tipsTown2017;

import java.util.Stack;

public class Pair {
    public static void main(String[] args) {
        String s = "baabaa";
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] inputs = s.split("");


        if (s.length() % 2 == 0) {
            for (String input : inputs) {
                if (stack.isEmpty()) {
                    stack.push(input);
                } else {

                    if (stack.peek().equals(input)) {
                        stack.pop();
                    } else {
                        stack.push(input);
                    }
                }
            }

            if (stack.empty()) {
                answer = 1;
            }
        }


        System.out.println(answer);
    }

    class Solution {
        public int solution(String s) {
            int answer = 0;

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}
