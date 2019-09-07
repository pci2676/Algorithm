package kakao2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Solution solution = new Solution();
        String answer = solution.solution(input);
        System.out.println(answer);
    }

    static class Solution {
        public String solution(String p) {
            if (isCorrectString(p)) {
                return p;
            }
            return getAnswer(p);
        }

        private String getAnswer(String w) {
            if (w.length() == 0) {
                return "";
            }

            int splitIndex = getSplitIndex(w);
            String u = w.substring(0, splitIndex + 1);
            String v = w.substring(splitIndex + 1);

            if (isCorrectString(u)) {
                return u + getAnswer(v);
            }

            u = sort(u);

            return u + getAnswer(v);
        }

        //균형잡힌 문자열 경계점 구하기
        private Integer getSplitIndex(String p) {
            String[] inputs = p.split("");

            int leftCount = 0;
            int rightCount = 0;

            for (int i = 0; i < inputs.length; i++) {
                String word = inputs[i];
                if (word.equals(LEFT)) {
                    leftCount++;
                } else {
                    rightCount++;
                }

                if (leftCount == rightCount) {
                    return i;
                }
            }
            return inputs.length - 1;
        }

        //올바른 문자열인지 체크
        private boolean isCorrectString(String p) {
            String[] gwalHos = p.split("");
            Stack<String> stack = new Stack<>();
            stack.push(gwalHos[0]);

            boolean answer = true;

            for (int i = 1; i < gwalHos.length; i++) {
                String gwalHo = gwalHos[i];
                if (gwalHo.equals(LEFT)) {
                    stack.push(gwalHo);
                }
                if (gwalHo.equals(RIGHT)) {
                    if (stack.empty()) {
                        answer = false;
                        break;
                    }
                    if (stack.pop().equals(RIGHT)) {
                        answer = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                answer = false;
            }
            return answer;
        }

        private String sort(String u) {
            StringBuilder temp = new StringBuilder(LEFT);
            String[] leftU = u.split("");
            for (int i = leftU.length - 2; i > 0; i--) {
                temp.append(leftU[i]);
            }
            temp.append(RIGHT);
            return temp.toString();
        }
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