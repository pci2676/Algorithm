package programers.practice.jaden;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("3people unFollowed me").equals("3people Unfollowed Me"));
        System.out.println(solution.solution("for the last week").equals("For The Last Week"));
        System.out.println(solution.solution("  for the last week  ").equals("  For The Last Week  "));
        System.out.println(solution.solution("for").equals("For"));
        System.out.println(solution.solution("for s").equals("For S"));
        System.out.println(solution.solution("a").equals("A"));
        System.out.println(solution.solution("a a  aA").equals("A A  Aa"));
        System.out.println(solution.solution("                   ").equals("                   "));
    }
}

class Solution {
    public String solution(String s) {
        if (s.trim().equals("")) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s.split("");
        String before = "";
        for (String each : split) {
            String now = each.toLowerCase();
            if (before.equals(" ") || before.equals("")) {
                now = each.toUpperCase();
            }
            stringBuilder.append(now);
            before = each;
        }

        return stringBuilder.toString();
    }
}