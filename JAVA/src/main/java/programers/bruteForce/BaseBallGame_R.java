package programers.bruteForce;

import java.util.HashSet;
import java.util.Set;


/**
 *  브루트 포스의 유명한 문제라고 한다.
 *  접근 방법을 찾지 못해서 결국 다른 사람의 답을 한번보고 작성하였다.
 *  정답을 가정하고 접근하는 문제였다.
 */
public class BaseBallGame_R {

    class Solution {
        public int solution(int[][] baseball) {
            int answer = 0;

            return answer;
        }
    }

    public static void main(String[] args) {

        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

        Set<String> answers = new HashSet<>();
        for (int init = 123; init <= 987; init++) {
            String maybe = String.valueOf(init);
            if (isDuplicate(maybe) || hasZero(maybe)) {
                continue;
            }
            answers.add(maybe);

            for (int i = 0; i < baseball.length; i++) {
                if (!canAnswer(maybe, baseball[i])) {
                    answers.remove(maybe);
                }
            }

        }

        System.out.println(answers);

    }

    private static boolean canAnswer(String maybe, int[] baseball) {
        String attack = String.valueOf(baseball[0]);
        int strike = baseball[1];
        int ball = baseball[2];

        return (strike == getStrike(maybe, attack)) && (ball == getBall(maybe, attack));

    }

    private static int getStrike(String maybe, String attack) {
        String[] maybeSplited = maybe.split("");
        String maybeFirst = maybeSplited[0];
        String maybeSecond = maybeSplited[1];
        String maybeThird = maybeSplited[2];

        String[] attackSplited = attack.split("");
        String attackFirst = attackSplited[0];
        String attackSecond = attackSplited[1];
        String attackThird = attackSplited[2];

        int count = 0;

        if (maybeFirst.equals(attackFirst)) {
            count++;
        }
        if (maybeSecond.equals(attackSecond)) {
            count++;
        }
        if (maybeThird.equals(attackThird)) {
            count++;
        }

        return count;
    }

    private static int getBall(String maybe, String attack) {
        String[] maybeSplited = maybe.split("");
        String maybeFirst = maybeSplited[0];
        String maybeSecond = maybeSplited[1];
        String maybeThird = maybeSplited[2];

        String[] attackSplited = attack.split("");
        String attackFirst = attackSplited[0];
        String attackSecond = attackSplited[1];
        String attackThird = attackSplited[2];

        int count = 0;
        if (maybeFirst.equals(attackSecond)||maybeFirst.equals(attackThird)) {
            count++;
        }
        if (maybeSecond.equals(attackFirst)||maybeSecond.equals(attackThird)) {
            count++;
        }
        if (maybeThird.equals(attackSecond)||maybeThird.equals(attackFirst)) {
            count++;
        }

        return count;
    }


    private static boolean hasZero(String src) {
        String[] maybe = src.split("");
        String first = maybe[0];
        String second = maybe[1];
        String third = maybe[2];

        return first.equals("0") || second.equals("0") || third.equals("0");
    }

    private static boolean isDuplicate(String src) {
        String[] maybe = src.split("");
        String first = maybe[0];
        String second = maybe[1];
        String third = maybe[2];

        return first.equals(second) || first.equals(third) || second.equals(third);
    }


}
