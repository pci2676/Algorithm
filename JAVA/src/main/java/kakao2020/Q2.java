package kakao2020;

import java.util.Stack;


public class Q2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(()())()").equals("(()())()"));
        System.out.println(solution.solution(")(").equals("()"));
        System.out.println(solution.solution("()))((()").equals("()(())()"));
        System.out.println(solution.solution("))((()").equals("(())()"));
    }
}

class Solution {

    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        if (Bracket.isCorrect(p)) {
            return p;
        }

        Bracket bracket = new Bracket(p);
        return bracket.makeCorrect();
    }

}

class Bracket {
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    private String u;//균형잡힌 문자열 더이상 분리 불가능한 가장 작은 균형잡힌 녀석
    private String v;//빈 문자열 가능

    public Bracket(String w) {
        this.u = findSmall(w);
        this.v = findNotSmall(w, u);
        if (this.v == null) {
            this.v = "";
        }
    }

    public static boolean isCorrect(String w) {
        Stack<String> stack = new Stack<>();
        String[] split = w.split("");
        for (String bracket : split) {
            if (bracket.equals(LEFT)) {
                stack.push(bracket);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    private String findSmall(String w) {
        int left = 0;
        int right = 0;
        String[] split = w.split("");

        StringBuilder small = new StringBuilder();

        for (String bracket : split) {
            small.append(bracket);
            if (bracket.equals(LEFT)) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                break;
            }
        }
        return small.toString();
    }

    private String findNotSmall(String w, String small) {
        return w.substring(small.length());
    }

    public String makeCorrect() {
        if (u.isEmpty()) {
            return u;
        }
        if (isCorrect(u)) {
            Bracket bracket = new Bracket(v);
            return u + bracket.makeCorrect();
        }

        StringBuilder correct = new StringBuilder("(");

        Bracket bracket = new Bracket(v);
        correct.append(bracket.makeCorrect());
        correct.append(")");

        //u 앞 뒤 떼고 바꿔서 붙이기
        String[] split = u.split("");
        for (int i = 1; i < split.length - 1; i++) {
            if (split[i].equals(LEFT)) {
                correct.append(RIGHT);
            } else {
                correct.append(LEFT);
            }
        }

        return correct.toString();
    }
}

//'(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
//그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
//예를 들어, "(()))("와 같은 문자열은 균형잡힌 괄호 문자열 이지만 올바른 괄호 문자열은 아닙니다.
//반면에 "(())()"와 같은 문자열은 균형잡힌 괄호 문자열 이면서 동시에 올바른 괄호 문자열 입니다.
//
//'(' 와 ')' 로만 이루어진 문자열 w가 균형잡힌 괄호 문자열 이라면 다음과 같은 과정을 통해 올바른 괄호 문자열로 변환할 수 있습니다.
//
//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.

//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//  4-3. ')'를 다시 붙입니다.
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//  4-5. 생성된 문자열을 반환합니다.
//균형잡힌 괄호 문자열 p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 올바른 괄호 문자열로 변환한 결과를 return 하도록 solution 함수를 완성해 주세요.

//p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
//문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
//만약 p가 이미 올바른 괄호 문자열이라면 그대로 return 하면 됩니다.

//입출력 예에 대한 설명
//입출력 예 #1
//이미 올바른 괄호 문자열 입니다.
//
//입출력 예 #2
//
//두 문자열 u, v로 분리합니다.
//u = ")("
//v = ""
//u가 올바른 괄호 문자열이 아니므로 다음과 같이 새로운 문자열을 만듭니다.
//v에 대해 1단계부터 재귀적으로 수행하면 빈 문자열이 반환됩니다.
//u의 앞뒤 문자를 제거하고, 나머지 문자의 괄호 방향을 뒤집으면 ""이 됩니다.
//따라서 생성되는 문자열은 "(" + "" + ")" + ""이며, 최종적으로 "()"로 변환됩니다.
//입출력 예 #3
//
//두 문자열 u, v로 분리합니다.
//u = "()"
//v = "))((()"
//문자열 u가 올바른 괄호 문자열이므로 그대로 두고, v에 대해 재귀적으로 수행합니다.
//다시 두 문자열 u, v로 분리합니다.
//u = "))(("
//v = "()"
//u가 올바른 괄호 문자열이 아니므로 다음과 같이 새로운 문자열을 만듭니다.
//v에 대해 1단계부터 재귀적으로 수행하면 "()"이 반환됩니다.
//u의 앞뒤 문자를 제거하고, 나머지 문자의 괄호 방향을 뒤집으면 "()"이 됩니다.
//따라서 생성되는 문자열은 "(" + "()" + ")" + "()"이며, 최종적으로 "(())()"를 반환합니다.
//처음에 그대로 둔 문자열에 반환된 문자열을 이어 붙이면 "()" + "(())()" = "()(())()"가 됩니다.